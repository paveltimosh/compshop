package org.vironit.timoshuk.computershop.service;

import org.vironit.timoshuk.computershop.entity.products.Components.Case;
import org.vironit.timoshuk.computershop.entity.products.Computer;

import java.util.List;

public interface ComputerService {
    Computer findById(Long id);
    List<Computer> findAll();
    void create(final Computer computer);
    void update(final Computer computer);
    void delete(final Computer computer);
    void deleteById(Long id);
}
