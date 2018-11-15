package pl.chrislem.phonebook.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.chrislem.phonebook.models.entities.ContactEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM contact")
    List<ContactEntity> findAllContacts();

    @Query(nativeQuery = true, value = "SELECT * FROM contact WHERE LOWER(surname) = LOWER(?1)")
    Optional<ContactEntity> findContactBySurname(String surname);

    boolean existsBySurname(String surname);
}
