package org.vironit.timoshuk.computershop.model.entity.users;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
public class Administrator {

    private int id;
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    public Administrator(int id, String login, String password, String email, String firstName, String lastName) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}