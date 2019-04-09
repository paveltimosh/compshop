package org.timoshuk.computershop.service.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.timoshuk.computershop.exception.EntityNotFoundException;
import org.timoshuk.computershop.service.RamService;
import org.timoshuk.computershop.entity.products.Components.RAM;
import org.timoshuk.computershop.DAO.impl.productDAO.RamDAOImpl;

import java.util.List;

@Service
public class RamServiceImpl implements RamService {

    @Autowired
    private RamDAOImpl ramDAO;

    @Transactional
    @Override
    public RAM findById(Long id) {
        RAM ram = ramDAO.findById(id);
        if (ram == null){
            throw new EntityNotFoundException("RAM not found");
        }
        return ram;
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
        RAM ram = ramDAO.findById(id);
        if (ram == null){
            throw new EntityNotFoundException("RAM not found");
        }
        ramDAO.deleteById(id);
    }
}
