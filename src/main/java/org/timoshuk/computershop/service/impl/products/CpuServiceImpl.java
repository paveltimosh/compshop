package org.timoshuk.computershop.service.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.timoshuk.computershop.exception.EntityNotFoundException;
import org.timoshuk.computershop.service.CpuService;
import org.timoshuk.computershop.entity.products.Components.CPU;
import org.timoshuk.computershop.DAO.impl.productDAO.CpuDAOImpl;

import java.util.List;

@Service
public class CpuServiceImpl implements CpuService {

    @Autowired
    private CpuDAOImpl cpuDAO;

    @Transactional
    @Override
    public CPU findById(Long id) {
        CPU cpu = cpuDAO.findById(id);
        if (cpu == null){
            throw new EntityNotFoundException("Cpu not found!");
        }
        return cpu;
    }

    @Transactional
    @Override
    public List<CPU> findAll() {
        return cpuDAO.findAll();
    }

    @Transactional
    @Override
    public void create(CPU cpu) {
        cpuDAO.create(cpu);
    }

    @Transactional
    @Override
    public void update(CPU cpu) {
        cpuDAO.update(cpu);
    }

    @Transactional
    @Override
    public void delete(CPU cpu) {
        cpuDAO.delete(cpu);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        cpuDAO.deleteById(id);
    }
}
