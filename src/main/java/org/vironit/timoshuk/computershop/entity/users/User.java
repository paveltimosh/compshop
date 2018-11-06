package org.vironit.timoshuk.computershop.entity.users;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString()
@EqualsAndHashCode(of = {"login", "id"})
@Entity
@Table(name = "users", schema = "public")
public class User  implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "customers_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "own_money")
    private Integer ownMoney;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    public User(){
    }

    public User(Long id, UserType userType, String login, String password, String email, Integer ownMoney,
                String firstName, String lastName, String idCard, String address, String phoneNumber) {
        this.id = id;
        this.userType = userType;
        this.login = login;
        this.password = password;
        this.email = email;
        this.ownMoney = ownMoney;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCard = idCard;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}