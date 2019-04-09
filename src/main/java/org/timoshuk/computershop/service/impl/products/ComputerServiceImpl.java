package org.timoshuk.computershop.service.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.timoshuk.computershop.DAO.impl.productDAO.*;
import org.timoshuk.computershop.DTO.ComputerDTO;
import org.timoshuk.computershop.entity.products.Components.MotherBoard;
import org.timoshuk.computershop.entity.products.Computer;
import org.timoshuk.computershop.service.ComputerService;

import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {


    private ComputerDAOImpl computerDAO;
    private CaseDAOImpl caseDAO;
    private CpuDAOImpl cpuDAO;
    private RamDAOImpl ramDAO;
    private MotherboardDAOImpl motherboardDAO;
    private VideocardDAOImpl videocardDAO;

    @Autowired
    public ComputerServiceImpl(CaseDAOImpl caseDAO, CpuDAOImpl cpuDAO, RamDAOImpl ramDAO,
                               MotherboardDAOImpl motherboardDAO, VideocardDAOImpl videocardDAO) {
        this.caseDAO = caseDAO;
        this.cpuDAO = cpuDAO;
        this.ramDAO = ramDAO;
        this.motherboardDAO = motherboardDAO;
        this.videocardDAO = videocardDAO;
    }

    @Transactional
    @Override
    public Computer findById(Long id) {
        return computerDAO.findById(id);
    }

    @Transactional
    @Override
    public List<Computer> findAll() {
        return computerDAO.findAll();
    }

    @Transactional
    @Override
    public void create(ComputerDTO computerDTO) {
        computerDAO.update(createComputerFromDTO(computerDTO));
    }

    @Transactional
    @Override
    public void update(Computer computer) {
        computerDAO.update(computer);
    }

    @Transactional
    @Override
    public void delete(Computer computer) {
        computerDAO.delete(computer);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        computerDAO.deleteById(id);
    }

    private Computer createComputerFromDTO(ComputerDTO computerDTO){
        Computer computer = new Computer();
        computer.setId(777L);
        computer.setModel("ffaf");
        computer.setPrice(1504);
        computer.setCases(caseDAO.findById(computerDTO.getIdCase()));
        computer.setCpu(cpuDAO.findById(computerDTO.getIdCPU()));
        computer.setRam(ramDAO.findById(computerDTO.getIdRAM()));
        computer.setMotherBoard(motherboardDAO.findById(computerDTO.getIdMotherBoard()));
        computer.setVideoCard(videocardDAO.findById(computerDTO.getIdVideocard()));
        System.out.println(computer);
        return computer;
    }
}
