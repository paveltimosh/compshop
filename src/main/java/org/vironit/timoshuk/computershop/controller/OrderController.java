package org.vironit.timoshuk.computershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.vironit.timoshuk.computershop.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/make_order")
    public ModelAndView makeOrder(){
        ModelAndView modelAndView = new ModelAndView();

        return modelAndView;
    }
}
