package pl.chrislem.phonebook.models.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.security.cert.Extension;


public class PasswordHashingService {

    @Service

    public String hash (String password){
        return getPasswordEncoder().encode(password);

    }

    public boolean matches (String password, String hash){
        return getPasswordEncoder().matches(password, hash);
    }

    private Extension getPasswordEncoder() {
    }

    @Bean
    public BCryptPasswordEncoder
}
