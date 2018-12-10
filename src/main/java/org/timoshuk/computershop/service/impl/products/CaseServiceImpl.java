package org.timoshuk.computershop.service.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.timoshuk.computershop.entity.products.Components.Case;
import org.timoshuk.computershop.DAO.impl.productDAO.CaseDAOImpl;
import org.timoshuk.computershop.service.CaseService;

import java.util.List;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseDAOImpl caseDAO;

    @Transactional
    @Override
    public Case findById(Long id) {
        return caseDAO.findById(id);
    }

    @Transactional
    @Override
    public List<Case> findAll() {
        return caseDAO.findAll();
    }

    @Transactional
    @Override
    public void create(Case aCase) {
        caseDAO.create(aCase);
    }

    @Transactional
    @Override
    public void update(Case aCase) {
        caseDAO.update(aCase);
    }

    @Transactional
    @Override
    public void delete(Case aCase) {
        caseDAO.delete(aCase);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        caseDAO.deleteById(id);
    }
}
