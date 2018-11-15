package pl.chrislem.phonebook.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.chrislem.phonebook.models.entities.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    boolean existsByLoginAndPassword(String login, String password);
    boolean existsByLogin(String login);


    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE login = ?1 AND password = ?2")
    Optional<UserEntity> getUserByLoginAndPassword(String login, String password);
}


