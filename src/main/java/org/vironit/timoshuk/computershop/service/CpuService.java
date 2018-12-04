package org.vironit.timoshuk.computershop.service;

import org.vironit.timoshuk.computershop.entity.products.Components.CPU;

import java.util.List;

public interface CpuService {
    CPU findById(Long id);
    List<CPU> findAll();
    void create(final CPU cpu);
    void update(final CPU cpu);
    void delete(final CPU cpu);
    void deleteById(Long id);
}
