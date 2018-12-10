package org.timoshuk.computershop.secure;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.entity.products.Item;
import org.timoshuk.computershop.service.UserService;

@Component("customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication a
    ) throws IOException, ServletException {
        System.out.println("обработчик аутентификатор");
        Set<String> roles = AuthorityUtils.authorityListToSet(a.getAuthorities());
        System.out.println(roles);
            HashMap<Item, Integer> cart = new HashMap<>();
            UserDTO userDTO = userService.findByLogin(a.getName());
            request.getSession().setAttribute("user", userDTO);
            request.getSession().setAttribute("role", userDTO.getUserType().toString());
            request.getSession().setAttribute("cart", cart);
            response.sendRedirect(servletContext.getContextPath()+ "/main");

        /*if (roles.contains("ROLE_ADMIN") || roles.contains("ROLE_STAFF")) {
            response.sendRedirect(servletContext.getContextPath() + "/admin/");
        } else {
            response.sendRedirect(servletContext.getContextPath() + "/");
        }*/
    }
}