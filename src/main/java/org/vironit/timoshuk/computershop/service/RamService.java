package org.vironit.timoshuk.computershop.service;

import org.vironit.timoshuk.computershop.entity.products.Components.RAM;

import java.util.List;

public interface RamService {

    RAM findById(Long id);
    List<RAM> findAll();
    void create(final RAM ram);
    void update(final RAM ram);
    void delete(final RAM ram);
    void deleteById(Long id);
}
