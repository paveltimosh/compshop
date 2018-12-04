package org.vironit.timoshuk.computershop.service.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vironit.timoshuk.computershop.entity.products.Components.RAM;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO.RamDAOImpl;
import org.vironit.timoshuk.computershop.service.RamService;

import java.util.List;

@Service
public class RamServiceImpl implements RamService {

    @Autowired
    private RamDAOImpl ramDAO;

    @Transactional
    @Override
    public RAM findById(Long id) {
        return ramDAO.findById(id);
    }

    @Transactional
    @Override
    public List<RAM> findAll() {
        return ramDAO.findAll();
    }

    @Transactional
    @Override
    public void create(RAM ram) {
        ramDAO.create(ram);
    }

    @Transactional
    @Override
    public void update(RAM ram) {
        ramDAO.update(ram);
    }

    @Transactional
    @Override
    public void delete(RAM ram) {
        ramDAO.delete(ram);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        ramDAO.deleteById(id);
    }
}
