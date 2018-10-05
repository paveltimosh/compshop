package org.vironit.timoshuk.computershop.model.entity.users;

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

    public Customer(){

    }

    public Customer(Long id, String login, String password, String email, String firstName, String lastName, String adress, boolean isOnBlackList, Busket busket) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.isOnBlackList = isOnBlackList;
        this.busket = busket;
    }


}
