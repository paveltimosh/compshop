package org.vironit.timoshuk.computershop.service;

import org.vironit.timoshuk.computershop.entity.products.Components.Case;

import java.util.List;

public interface CaseService {
    Case findById(Long id);
    List<Case> findAll();
    void create(final Case aCase);
    void update(final Case aCase);
    void delete(final Case aCase);
    void deleteById(Long id);
}
