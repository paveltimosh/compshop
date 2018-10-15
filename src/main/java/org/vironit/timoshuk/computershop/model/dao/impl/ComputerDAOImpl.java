package org.vironit.timoshuk.computershop.model.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.model.dao.ComputerDAO;
import org.vironit.timoshuk.computershop.model.dao.DAOException;
import org.vironit.timoshuk.computershop.model.entity.products.Components.*;
import org.vironit.timoshuk.computershop.model.entity.products.Computer;
import org.vironit.timoshuk.computershop.model.util.DataBasePoolConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerDAOImpl implements ComputerDAO <Long, Computer> {

    private static final Logger LOG = LogManager.getLogger(ComputerDAOImpl.class);
    private static final String SQL_SELECT_ALL_COMPUTERS = "SELECT computers.id as id_comp, cases.id AS case_id, cases.maker AS case_maker,  cases.model AS case_model, cases.price AS case_price, cases.power_supply_unit AS case_power_supply_unit, cases.type_of_case AS case_type_of_case, cases.material AS case_material, " +
            "cpu.id AS cpu_id, cpu.maker AS cpu_maker, cpu.model AS cpu_model, cpu.price AS cpu_price,  cpu.speed AS cpu_speed, cpu.processor_type AS cpu_processor_type, cpu.number_of_cores AS cpu_number_of_cores, " +
            "motherboards.id AS moth_id, motherboards.maker AS moth_maker, motherboards.model AS moth_model, motherboards.price AS moth_price, motherboards.cpu_socket_type AS moth_cpu_socket_type, motherboards.form_factor AS moth_form_factor, motherboards.memory_technology AS moth_memory_technology," +
            "rams.id AS ram_id, rams.maker AS ram_maker, rams.model AS ram_model, rams.price AS ram_price, rams.type AS ram_type, rams.memory_capacity AS rams_memory_capacity, " +
            "videocards.id AS videocard_id, videocards.maker AS videocard_maker, videocards.model AS videocard_model, videocards.price AS videocard_price,videocards.type_graphics_processor AS videocard_type_graphics_processor, videocards.type_video_memory AS videocard_type_video_memory, videocards.video_capacity AS videocard_video_capacity " +
            "FROM computers, cases, videocards, cpu, rams, motherboards WHERE  (cases.id = computers.id_case)" +
            "AND (videocards.id = computers.id_videocard)" +
            "AND (cpu.id = computers.id_cpu)" +
            "AND (rams.id = computers.id_ram)" +
            "AND (motherboards.id = computers.id_motherboard) ";


    @Override
    public List<Computer> findAll() throws DAOException {
        List <Computer> computers = new ArrayList<>();
        try (Connection conn = DataBasePoolConnector.getConnection();
             PreparedStatement prepStat = conn.prepareStatement(SQL_SELECT_ALL_COMPUTERS);
             ResultSet rs = prepStat.executeQuery()) {
            while (rs.next()){
                Computer computer = new Computer();
                setComputerAllFields (computer, rs);
                computers.add(computer);
            }

        }catch (SQLException e){
            LOG.error("SQL exception (request or table failed) in method findAll() ", e);
            throw new DAOException("SQL Exception ",e);
        }
        return computers;
    }

    @Override
    public Computer findComputerById(Long id) {
        return null;
    }

    @Override
    public boolean deleteComputerById(Long id) {
        return false;
    }

    @Override
    public boolean createComputer(Computer computerDAO) {
        return false;
    }

    @Override
    public boolean update(Computer computerDAO, Long id) {
        return false;
    }

    private void setComputerAllFields(Computer computer, ResultSet rs) throws SQLException {
        computer.setId(rs.getLong("id_comp"));
        setCaseAllFields (computer, rs);
        setCPUAllFields (computer, rs);
        setMotherboardAllFields (computer, rs);
        setRAMAllFields (computer, rs);
        setVideocardAllFields(computer, rs);
    }

    private void setVideocardAllFields(Computer computer, ResultSet rs) throws SQLException {
        VideoCard videoCard = new VideoCard();
        videoCard.setId(rs.getLong("videocard_id"));
        videoCard.setMaker(rs.getString("videocard_maker"));
        videoCard.setModel(rs.getString("videocard_model"));
        videoCard.setPrice(rs.getInt("videocard_price"));
        videoCard.setTypeGraphicsProcessor(rs.getString("videocard_type_graphics_processor"));
        videoCard.setTypeVideoMemory(rs.getString("videocard_type_video_memory"));
        videoCard.setVideoCapacity(rs.getString("videocard_video_capacity"));
        computer.setVideoCard(videoCard);
        LOG.info("method setVideocardAllFields is worked");

    }

    private void setRAMAllFields(Computer computer, ResultSet rs) throws SQLException {
        RAM ram = new RAM();
        ram.setId(rs.getLong("ram_id"));
        ram.setMaker(rs.getString("ram_maker"));
        ram.setModel(rs.getString("ram_model"));
        ram.setPrice(rs.getInt("ram_price"));
        ram.setMemoryCapacity(rs.getString("rams_memory_capacity"));
        ram.setType(rs.getString("ram_type"));
        computer.setRam(ram);
        LOG.info("method setRAMAllFields is worked");
    }

    private void setMotherboardAllFields(Computer computer, ResultSet rs) throws SQLException {
        MotherBoard motherBoard = new MotherBoard();
        motherBoard.setId(rs.getLong("moth_id"));
        motherBoard.setMaker(rs.getString("moth_maker"));
        motherBoard.setModel(rs.getString("moth_model"));
        motherBoard.setPrice(rs.getInt("moth_price"));
        motherBoard.setCpuSocketType(rs.getString("moth_cpu_socket_type"));
        motherBoard.setFormFactor(rs.getString("moth_form_factor"));
        motherBoard.setMemoryTechnology(rs.getString("moth_memory_technology"));
        computer.setMotherBoard(motherBoard);
        LOG.info("method setMotherboardAllFields is worked");
        //LOG.debug("id =" + motherBoard.getId());
    }

    private void setCPUAllFields(Computer computer, ResultSet rs) throws SQLException {
        CPU cpu = new CPU();
        cpu.setId(rs.getLong("cpu_id"));
        cpu.setMaker(rs.getString("cpu_maker"));
        cpu.setModel(rs.getString("cpu_model"));
        cpu.setPrice(rs.getInt("cpu_price"));
        cpu.setCpuSpeed(rs.getString("cpu_speed"));
        cpu.setNumberOfCores(rs.getInt("cpu_number_of_cores"));
        cpu.setProcessorType(rs.getString("cpu_processor_type"));
        computer.setCpu(cpu);
        LOG.info("method setCPUAllFields is worked");
    }

    private void setCaseAllFields(Computer computer, ResultSet rs) throws SQLException {
        Case aCase = new Case();
        aCase.setId(rs.getLong("case_id"));
        aCase.setPrice(rs.getInt("case_price"));
        aCase.setModel(rs.getString("case_model"));
        aCase.setMaker(rs.getString("case_maker"));
        aCase.setTypeOfCase(rs.getString("case_type_of_case"));
        aCase.setPowerSupplyUnit(rs.getString("case_power_supply_unit"));
        aCase.setMaterial(rs.getString("case_material"));
        computer.setACase(aCase);
        LOG.info("method setCaseAllFields is worked");
    }
}
