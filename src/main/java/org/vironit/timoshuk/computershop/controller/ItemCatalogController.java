package org.vironit.timoshuk.computershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.vironit.timoshuk.computershop.dto.UserDTO;
import org.vironit.timoshuk.computershop.entity.products.Components.*;
import org.vironit.timoshuk.computershop.entity.products.Computer;
import org.vironit.timoshuk.computershop.entity.products.Item;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO.*;
import org.vironit.timoshuk.computershop.resource.MessageManager;
import org.vironit.timoshuk.computershop.service.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("catalog")
public class ItemCatalogController {

    @Autowired
    private RamService ramService;

    @Autowired
    private VideocardService videocardService;

    @Autowired
    private CpuService cpuService;

    @Autowired
    private CaseService caseService;

    @Autowired
    private MotherboardService motherboardService;

    @Autowired
    private ComputerService computerService;

    @GetMapping("/ram")
    public ModelAndView showCatalogRam (){
        ModelAndView modelAndView = new ModelAndView("catalog/ram");
        List<RAM> ramList = ramService.findAll();
        modelAndView.addObject("rams", ramList);
        return modelAndView;
    }

    @GetMapping("/videocard")
    public ModelAndView showCatalogVideocard (){
        ModelAndView modelAndView = new ModelAndView("catalog/videocards");
        List<VideoCard> videoCards = videocardService.findAll();
        modelAndView.addObject("videoCards", videoCards);
        return modelAndView;
    }

    @GetMapping("/cpu")
    public ModelAndView showCatalogCPU (){
        ModelAndView modelAndView = new ModelAndView("catalog/cpu");
        List<CPU> cpuList = cpuService.findAll();
        modelAndView.addObject("cpuList", cpuList);
        return modelAndView;
    }

    @GetMapping("/case")
    public ModelAndView showCatalogCase (){
        ModelAndView modelAndView = new ModelAndView("catalog/cases");
        List<Case> caseList = caseService.findAll();
        modelAndView.addObject("caseList", caseList);
        return modelAndView;
    }

    @GetMapping("/motherboard")
    public ModelAndView showCatalogMotherboard (){
        ModelAndView modelAndView = new ModelAndView("catalog/mother_boards");
        List<MotherBoard> motherBoardList = motherboardService.findAll();
        modelAndView.addObject("motherboardList", motherBoardList);
        return modelAndView;
    }

    @GetMapping("/computer")
    public ModelAndView showCatalogComputer(){
        ModelAndView modelAndView = new ModelAndView("catalog/computers");
        List<Computer> computerList = computerService.findAll();
        modelAndView.addObject("computerList", computerList);
        return modelAndView;
    }

    @GetMapping("/computer/info/{id}")
    public ModelAndView showComputerInfo(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/catalog/view/computerInfo");
        Computer computer = computerService.findById(id);
        modelAndView.addObject("computer",computer);
        return modelAndView;
    }

    @PostMapping("/addToCart")
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

    @GetMapping("/")
    public String showMain(){
        return "main";
    }

    private Item defineAndGetItemFromDB(Long itemId, String itemType) {
        Item item = null;
        switch (itemType){
            case "computers" :
                item = computerService.findById(itemId);
                break;
            case "cases":
                item = caseService.findById(itemId);
                break;
            case "cpu":
                item = cpuService.findById(itemId);
                break;
            case "ram":
                item = ramService.findById(itemId);
                break;
            case "videocards":
                item = videocardService.findById(itemId);
                break;
            case "mother_boards":
                item = motherboardService.findById(itemId);
                break;
            default:
                item = null;
        }
        return item;
    }

    private ModelAndView getModelAndViewByType(String itemType) {
        ModelAndView modelAndView = null;
        switch (itemType){
            case "computers" :
                modelAndView = showCatalogComputer();
                break;
            case "cases":
                modelAndView = showCatalogCase();
                break;
            case "cpu":
                modelAndView = showCatalogCPU();
                break;
            case "ram":
                modelAndView = showCatalogRam();
                break;
            case "videocards":
                modelAndView = showCatalogVideocard();
                break;
            case "mother_boards":
                modelAndView = showCatalogMotherboard();
                break;
        }
        return modelAndView;
    }
}
