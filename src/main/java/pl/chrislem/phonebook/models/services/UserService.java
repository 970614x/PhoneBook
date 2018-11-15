package pl.chrislem.phonebook.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.chrislem.phonebook.models.UserSession;
import pl.chrislem.phonebook.models.forms.LoginForm;
import pl.chrislem.phonebook.models.forms.RegisterForm;
import pl.chrislem.phonebook.models.entities.UserEntity;
import pl.chrislem.phonebook.models.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;
    final UserSession userSession;

    @Autowired
    public UserService(UserRepository userRepository, UserSession userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public boolean checkIfLoginExists(String login){
        return userRepository.existsByLogin(login);
    }

    public void addUser(RegisterForm userForm){
        UserEntity newUser = new UserEntity();
        newUser.setLogin(userForm.getLogin());
        newUser.setPassword(userForm.getPassword());

        userRepository.save(newUser);
    }

    public boolean tryLogin(LoginForm loginForm){
        Optional<UserEntity> userOptional =
                userRepository.getUserByLoginAndPassword(loginForm.getLogin(),
                        loginForm.getPassword());
        if(userOptional.isPresent()){
            userSession.setLogin(true);
            userSession.setUserEntity(userOptional.get());
        }
        return userOptional.isPresent();
    }
}
