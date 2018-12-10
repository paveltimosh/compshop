package org.timoshuk.computershop.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.timoshuk.computershop.DTO.transfer.CreateNewUser;
import org.timoshuk.computershop.DTO.transfer.EditUserData;
import org.timoshuk.computershop.entity.users.UserType;
import org.timoshuk.computershop.validator.annotations.FieldsValueMatch;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldsValueMatch.List({
        @FieldsValueMatch( field = "password", fieldMatch = "passwordTwo", message = "Passwords do not match!", groups = CreateNewUser.class)})
public class UserDTO {

    private Long id;

    private UserType userType;

    @Null(groups = EditUserData.class)
    @NotEmpty(message = "This field cannot be empty", groups = CreateNewUser.class)
    @Pattern(regexp = "^[a-zA-Z0-9_]{3,15}$", message = "Login incorrect! Use 3-15 letters or numbers!", groups = CreateNewUser.class)
    private String login;

    @Null(groups = EditUserData.class)
    @NotEmpty(message = "This field cannot be empty", groups = CreateNewUser.class)
    @Pattern(regexp = "[a-zA-Z0-9]{5,20}", message = "Login incorrect! Use 3-15 letters or numbers!", groups = CreateNewUser.class)
    private String password;

    @Null(groups = EditUserData.class)
    @NotEmpty(message = "This field cannot be empty!", groups = CreateNewUser.class)
    private String passwordTwo;

    @NotEmpty(message = "This field cannot be empty!", groups = {EditUserData.class, CreateNewUser.class})
    @Email(message = "Email incorrect! It must be like: email@email.com!", groups = {EditUserData.class, CreateNewUser.class})
    private String email;

    @NotEmpty(message = "This field cannot be empty!", groups = {EditUserData.class, CreateNewUser.class})
    @Size(max = 30, message = "First name cannot be longer than 30 characters!", groups = {EditUserData.class, CreateNewUser.class})
    private String firstName;

    @NotEmpty(message = "This field cannot be empty!", groups = {EditUserData.class, CreateNewUser.class})
    @Size(max = 30, message = "Last name cannot be longer than 30 characters!", groups = {EditUserData.class, CreateNewUser.class})
    private String lastName;

    @NotEmpty(message = "This field cannot be empty!", groups = {EditUserData.class, CreateNewUser.class})
    private String address;

    @NotEmpty(message = "This field cannot be empty!", groups = {EditUserData.class, CreateNewUser.class})
    @Pattern(regexp = "^(\\d{9}+)$", message = "Write only last 9 numbers of your telephone! ", groups = {EditUserData.class, CreateNewUser.class})
    private String phoneNumber;

    @NotEmpty(message = "This field cannot be empty!", groups = {EditUserData.class, CreateNewUser.class})
    @Size(min = 16, max = 16, message = "Length of bank card's id is might be equal 16!", groups = {EditUserData.class, CreateNewUser.class})
    private String idCard;

    private Integer ownMoney;
}