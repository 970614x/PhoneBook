package pl.chrislem.phonebook.models.forms;


import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegisterForm {
    @Pattern(regexp = "[a-zA-Z0-9]{3,20}")
    private String login;
    @Size(min = 3, max = 50)
    private String password;
}
