package org.vironit.timoshuk.computershop.model.entity.Users;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.vironit.timoshuk.computershop.model.entity.Busket;

@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
public class Customer {

    private Long id;
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String adress;
    private boolean isOnBlackList;

    private Busket busket;

}
