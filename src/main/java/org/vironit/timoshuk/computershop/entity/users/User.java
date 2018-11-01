package org.vironit.timoshuk.computershop.entity.users;

import lombok.*;
import javax.persistence.Table;

import javax.persistence.Entity;

@Builder
@Getter
@Setter
@ToString()
@EqualsAndHashCode(of = {"login", "id"})
@Entity
@Table(name = "users")
public class User {

    private Long id;
    private UserType userType;
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String idCard;
    private String address;
    private String phoneNumber;

    public User(){
    }

    public User( Long id, UserType userType, String login, String password, String email,
                String firstName, String lastName, String idCard, String address, String phoneNumber) {
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

