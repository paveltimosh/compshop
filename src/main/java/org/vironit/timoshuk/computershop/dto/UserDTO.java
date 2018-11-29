package org.vironit.timoshuk.computershop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vironit.timoshuk.computershop.entity.users.UserType;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    private UserType userType;

    @NotEmpty(message = "This field cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9_]{3,15}$", message = "Login incorrect! Use 3-15 letters or numbers")
    private String login;

    @NotEmpty(message = "This field cannot be empty")
    @Pattern(regexp = "[a-zA-Z0-9]{5,20}", message = "Login incorrect! Use 3-15 letters or numbers")
    private String password;

    @NotEmpty(message = "This field cannot be empty")
    @Email(message = "Email incorrect! It must be like: email@email.com")
    private String email;

    @NotEmpty(message = "This field cannot be empty")
    @Max(value = 30, message = "First name cannot be longer than 30 characters")
    private String firstName;

    @NotEmpty(message = "This field cannot be empty")
    @Max(value = 30, message = "Last name cannot be longer than 30 characters")
    private String lastName;

    @NotEmpty(message = "This field cannot be empty")
    private String address;

    @NotEmpty(message = "This field cannot be empty")
    @Pattern(regexp = "^(\\d{9}+)$", message = "Phone number incorrect! Write only last 9 numbers of your telephone!")
    @Size(min = 9, max = 9, message = "Phone number incorrect! Write only last 9 numbers of your telephone!")
    private String phoneNumber;

    @NotEmpty(message = "This field cannot be empty")
    @Size(min = 16, max = 16, message = "Length of bank card's id is might be equal 16!")
    private String idCard;

    private Integer ownMoney;
}