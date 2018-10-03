package org.vironit.timoshuk.computershop.model.entity.Users;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
public class Administrator {

    private Long id;
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

}