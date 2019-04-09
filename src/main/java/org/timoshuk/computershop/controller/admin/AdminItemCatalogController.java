package org.timoshuk.computershop.controller.admin;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.timoshuk.computershop.DTO.ComputerDTO;
import org.timoshuk.computershop.entity.products.Components.*;
import org.timoshuk.computershop.service.*;


@RestController
@RequestMapping(value = "/admins")
public class AdminItemCatalogController {

    private final RamService ramService;
    private final VideocardService videocardService;
    private final CpuService cpuService;
    private final CaseService caseService;
    private final MotherboardService motherboardService;
    private final ComputerService computerService;

    @Autowired
    public AdminItemCatalogController(RamService ramService, VideocardService videocardService, CpuService cpuService,
                                      CaseService caseService, MotherboardService motherboardService, ComputerService computerService) {
        this.ramService = ramService;
        this.videocardService = videocardService;
        this.cpuService = cpuService;
        this.caseService = caseService;
        this.motherboardService = motherboardService;
        this.computerService = computerService;
    }

    @RequestMapping(value = "/cases", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Case createCase(@Validated @RequestBody Case aCase){
        caseService.create(aCase);
        return aCase;
    }

    @RequestMapping(value = "/cpu", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public CPU createCPU(@RequestBody CPU cpu){
        cpuService.create(cpu);
        return cpu;
    }

    @RequestMapping(value = "/motherboards", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MotherBoard createMotherBoard(@RequestBody MotherBoard motherBoard){
        motherboardService.create(motherBoard);
        return motherBoard;
    }

    @RequestMapping(value = "/rams", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public RAM createRAM(@RequestBody RAM ram){
        ramService.create(ram);
        return ram;
    }

    @RequestMapping(value = "/videocards", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public VideoCard createVideoCard(@RequestBody VideoCard videoCard){
        videocardService.create(videoCard);
        return videoCard;
    }

    @RequestMapping(value = "/cases/{id}", method = RequestMethod.PUT)
    public Case changeCase(@Validated @RequestBody Case aCase,
                           @PathVariable Long id){
        Case aCasefromDB = caseService.findById(id);
        BeanUtils.copyProperties(aCase, aCasefromDB, "id");
        caseService.update(aCasefromDB);
        return aCasefromDB;
    }

    @RequestMapping(value = "/cpu/{id}", method = RequestMethod.PUT)
    public CPU changeCPU(@RequestBody CPU cpu,
                         @PathVariable Long id){
        CPU cpuFromDB = cpuService.findById(id);
        BeanUtils.copyProperties(cpu, cpuFromDB, "id");
        cpuService.update(cpuFromDB);
        return cpuFromDB;
    }

    @RequestMapping(value = "/motherboards/{id}", method = RequestMethod.PUT)
    public MotherBoard changeMotherBoard(@RequestBody MotherBoard motherBoard,
                                         @PathVariable Long id){
        MotherBoard motherBoardFromDB = motherboardService.findById(id);
        BeanUtils.copyProperties(motherBoard, motherBoardFromDB, "id");
        motherboardService.update(motherBoardFromDB);
        return motherBoardFromDB;
    }

    @RequestMapping(value = "/rams/{id}", method = RequestMethod.PUT)
    public RAM changeRAM(@RequestBody RAM ram,
                         @PathVariable Long id){
        RAM ramFromDB = ramService.findById(id);
        BeanUtils.copyProperties(ram, ramFromDB, "id");
        ramService.create(ramFromDB);
        return ramFromDB;
    }

    @RequestMapping(value = "/videocards/{id}", method = RequestMethod.PUT)
    public VideoCard changeVideocard(@RequestBody VideoCard videoCard,
                                     @PathVariable Long id){
        VideoCard videoCardFromDB = videocardService.findById(id);
        BeanUtils.copyProperties(videoCard, videoCardFromDB, "id");
        videocardService.create(videoCardFromDB);
        return videoCardFromDB;
    }

    @RequestMapping(value = "/computers", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ComputerDTO createComputer(@RequestBody ComputerDTO computerDTO){
        computerService.create(computerDTO);
        return computerDTO;
    }
}
