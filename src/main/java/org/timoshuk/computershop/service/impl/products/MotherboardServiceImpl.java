package org.timoshuk.computershop.service.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.timoshuk.computershop.entity.products.Components.MotherBoard;
import org.timoshuk.computershop.DAO.impl.productDAO.MotherboardDAOImpl;
import org.timoshuk.computershop.service.MotherboardService;

import java.util.List;

@Service
public class MotherboardServiceImpl implements MotherboardService {

    @Autowired
    private MotherboardDAOImpl motherboardDAO;

    @Transactional
    @Override
    public MotherBoard findById(Long id) {
        return motherboardDAO.findById(id);
    }

    @Transactional
    @Override
    public List<MotherBoard> findAll() {
        return motherboardDAO.findAll();
    }

    @Transactional
    @Override
    public void create(MotherBoard motherBoard) {
        motherboardDAO.create(motherBoard);
    }

    @Transactional
    @Override
    public void update(MotherBoard motherBoard) {
        motherboardDAO.update(motherBoard);
    }

    @Transactional
    @Override
    public void delete(MotherBoard motherBoard) {
        motherboardDAO.delete(motherBoard);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        motherboardDAO.deleteById(id);
    }
}
