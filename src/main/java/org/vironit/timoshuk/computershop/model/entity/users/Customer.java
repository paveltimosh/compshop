package org.vironit.timoshuk.computershop.model.entity.users;

import lombok.*;
import org.vironit.timoshuk.computershop.model.entity.Busket;
import org.vironit.timoshuk.computershop.model.entity.Entity;

@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
public class Customer  {

    private Long id;
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private int idCard;
    private String adress;
    private boolean onBlackList;

    private Busket busket;

    public Customer(){

    }

    public Customer(Long id, String login, String password, String email, String firstName, String lastName, String adress, boolean onBlackList, Busket busket) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.onBlackList = onBlackList;
        this.busket = busket;
    }


}
