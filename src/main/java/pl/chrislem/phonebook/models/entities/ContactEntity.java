package pl.chrislem.phonebook.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@Data
public class ContactEntity {
    @Id
    @GeneratedValue
    private  int id;

    private String name;
    private String surname;

    @Column(name = "phone")
    private String number;
}
