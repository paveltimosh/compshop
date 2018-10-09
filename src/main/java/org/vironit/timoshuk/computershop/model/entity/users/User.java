package org.vironit.timoshuk.computershop.model.entity.users;


import lombok.*;
import org.vironit.timoshuk.computershop.model.entity.Entity;

@Builder
@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
public class User implements Entity {

    private Long id;
    private UserType userType;
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Integer idCard;
    private String address;
    private String phoneNumber;

    public User(){

    }

    public User(Long id, UserType userType, String login, String password, String email,
                String firstName, String lastName, Integer idCard, String address, String phoneNumber) {
        this.id = id;
        this.userType = userType;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCard = idCard;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}

