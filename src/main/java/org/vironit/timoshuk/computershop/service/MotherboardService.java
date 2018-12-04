package org.vironit.timoshuk.computershop.service;

import org.vironit.timoshuk.computershop.entity.products.Components.MotherBoard;
import java.util.List;

public interface MotherboardService {

    MotherBoard findById(Long id);
    List<MotherBoard> findAll();
    void create(final MotherBoard motherBoard);
    void update(final MotherBoard motherBoard);
    void delete(final MotherBoard motherBoard);
    void deleteById(Long id);

}
