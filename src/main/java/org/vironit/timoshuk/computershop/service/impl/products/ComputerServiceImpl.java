package org.vironit.timoshuk.computershop.service.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vironit.timoshuk.computershop.entity.products.Computer;
import org.vironit.timoshuk.computershop.DAO.impl.productDAO.ComputerDAOImpl;
import org.vironit.timoshuk.computershop.service.ComputerService;

import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {

    @Autowired
    private ComputerDAOImpl computerDAO;

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
    public void create(Computer computer) {
        computerDAO.create(computer);
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
}
