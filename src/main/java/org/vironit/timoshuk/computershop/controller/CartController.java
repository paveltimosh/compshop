package org.vironit.timoshuk.computershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.vironit.timoshuk.computershop.entity.products.Item;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RequestMapping("/cart")
@Controller
@SessionAttributes("cart")
public class CartController {

    @GetMapping("delete")
    public ModelAndView deleteItem(@RequestParam Long id,
                                   @SessionAttribute HashMap<Item, Integer> cart,
                                   HttpSession session){
        ModelAndView modelAndView = new ModelAndView("user/cart");
        Iterator iterator = cart.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Item, Integer> pair = (Map.Entry<Item, Integer>) iterator.next();
            if (pair.getKey().getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
        session.setAttribute("cart", cart);
        return modelAndView;
    }

    @RequestMapping("")
    public String showCart(){
        return "user/cart";
    }
}
