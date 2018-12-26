package org.timoshuk.computershop.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.entity.products.Components.*;
import org.timoshuk.computershop.entity.products.Computer;
import org.timoshuk.computershop.entity.products.Item;
import org.timoshuk.computershop.service.*;
import org.timoshuk.computershop.util.MessageManager;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping
public class ItemCatalogController {

    private final RamService ramService;

    private final VideocardService videocardService;

    private final CpuService cpuService;

    private final CaseService caseService;

    private final MotherboardService motherboardService;

    private final ComputerService computerService;

    @Autowired
    public ItemCatalogController(RamService ramService, VideocardService videocardService, CpuService cpuService, CaseService caseService, MotherboardService motherboardService, ComputerService computerService) {
        this.ramService = ramService;
        this.videocardService = videocardService;
        this.cpuService = cpuService;
        this.caseService = caseService;
        this.motherboardService = motherboardService;
        this.computerService = computerService;
    }

    @RequestMapping(value = "/rams", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<RAM> showCatalogRam (){
        List<RAM> ramList = ramService.findAll();
        return ramList;
    }

    @RequestMapping(value = "/videocards", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<VideoCard> showCatalogVideocard (){
        List<VideoCard> videoCards = videocardService.findAll();
        return videoCards;
    }

    @RequestMapping(value = "/cpus", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<CPU> showCatalogCPU (){
        List<CPU> cpuList = cpuService.findAll();
        return cpuList;
    }

    @RequestMapping(value = "/cases", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Case> showCatalogCase (){
        List<Case> caseList = caseService.findAll();
        return caseList;
    }

    @RequestMapping(value = "/motherboards", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<MotherBoard> showCatalogMotherboard (){
        List<MotherBoard> motherBoardList = motherboardService.findAll();
        return motherBoardList;
    }

    @RequestMapping(value = "/computers", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Computer> showCatalogComputer(){
        List<Computer> computerList = computerService.findAll();
        return computerList;
    }

    @RequestMapping(value = "/computers/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Computer showComputerInfo(@PathVariable("id") Long id){
        Computer computer = computerService.findById(id);
        return computer;
    }

    /*@PostMapping("/addToCart")
    public ModelAndView addToCart(@RequestParam String itemType,
                                  @RequestParam Long id,
                                  HttpSession session) {
        ModelAndView modelAndView = getModelAndViewByType(itemType);
        UserDTO user = (UserDTO) session.getAttribute("user");
        HashMap<Item, Integer> cart = (HashMap<Item, Integer>) session.getAttribute("cart");
        if(user == null){
            modelAndView.addObject("addToCartError", MessageManager.getProperty("message.addToCartError"));
            return modelAndView;
        }
        Item item = defineAndGetItemFromDB(id, itemType);
        cart.put(item,1);
        session.setAttribute("cart", cart);
        return modelAndView;
    }
*/

}
