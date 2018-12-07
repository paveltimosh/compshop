package org.vironit.timoshuk.computershop.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.vironit.timoshuk.computershop.DTO.UserDTO;
import org.vironit.timoshuk.computershop.entity.users.UserType;
import org.vironit.timoshuk.computershop.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        System.out.println("user detail service");
        UserDTO user = userService.findByLogin(login);

        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(UserType.USER.name()));
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getLogin(),
                        user.getPassword(),
                        roles);
        System.out.println(userDetails);

        return userDetails;
    }

}