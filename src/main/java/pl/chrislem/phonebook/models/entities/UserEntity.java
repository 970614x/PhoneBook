package pl.chrislem.phonebook.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
    private @Id @GeneratedValue int id;
    private String login;
    private String password;
    private @Column(name = "creation_time") LocalDateTime creationTime;
}
