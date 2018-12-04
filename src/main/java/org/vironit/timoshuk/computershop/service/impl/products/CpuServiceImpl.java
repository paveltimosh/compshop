package org.vironit.timoshuk.computershop.service.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vironit.timoshuk.computershop.entity.products.Components.CPU;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO.CpuDAOImpl;
import org.vironit.timoshuk.computershop.service.CpuService;

import java.util.List;

@Service
public class CpuServiceImpl implements CpuService {

    @Autowired
    private CpuDAOImpl cpuDAO;

    @Transactional
    @Override
    public CPU findById(Long id) {
        return cpuDAO.findById(id);
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
