package pl.chrislem.phonebook.models.forms;


import lombok.Data;

@Data
public class ContactForm {
    private String name;
    private String surname;
    private String phone;
}
