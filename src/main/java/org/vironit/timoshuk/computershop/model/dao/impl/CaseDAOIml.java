package org.vironit.timoshuk.computershop.model.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.model.dao.DAOException;
import org.vironit.timoshuk.computershop.model.dao.EntityDAOImpl;
import org.vironit.timoshuk.computershop.model.entity.products.Components.Case;
import org.vironit.timoshuk.computershop.model.util.DataBasePoolConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaseDAOIml extends EntityDAOImpl<Long, Case> {

    private static final Logger LOG = LogManager.getLogger(CaseDAOIml.class);

    private static final String SQL_SELECT_ALL_CASES = "SELECT * FROM cases";
    private static final String SQL_SELECT_CASE_BY_ID = "SELECT * FROM cases WHERE id =?";
    private static final String SQL_DELETE_CASE_BY_ID = "";
    private static final String SQL_INSERT_INTO_CASES = "";
    private static final String SQL_UPDATE_CASE_INFO = "";


    @Override
    public List<Case> findAll() throws DAOException {
        List <Case> cases = new ArrayList<>();
        try (Connection conn = DataBasePoolConnector.getConnection();
             PreparedStatement prepStat = conn.prepareStatement(SQL_SELECT_ALL_CASES);
             ResultSet rs = prepStat.executeQuery()) {
                 while (rs.next()){
                     Case aCase = new Case();
                     setCaseAllFields (aCase, rs);
                     cases.add(aCase);
                 }
        }catch (SQLException e){
            LOG.error("SQL exception (request or table failed) in method findAll() ", e);
            throw new DAOException("SQL Exception ",e);
        }
        return cases;
    }

    @Override
    public Case findEntityById(Long id) throws DAOException {
        Case aCase = new Case();
        try (Connection conn = DataBasePoolConnector.getConnection();
             PreparedStatement prepStat = conn.prepareStatement(SQL_SELECT_CASE_BY_ID)) {
            prepStat.setLong(1, id);
            ResultSet rs = prepStat.executeQuery();
            rs.next();
            setCaseAllFields(aCase, rs);
        }catch (SQLException e){
            LOG.error("SQL exeprion (request or table failed)in method findUserById(Long id) ", e);
            throw new DAOException("SQL Exception ",e);
        }
        return aCase;
    }

    @Override
    public boolean deleteEntity(Case user) throws DAOException {
        return false;
    }

    @Override
    public boolean deleteEntityById(Long id) {
        return false;
    }

    @Override
    public boolean createEntity(Case aCase) {
        return false;
    }

    @Override
    public boolean update(Case aCase, Long id) {
        return false;
    }

    private void setCaseAllFields(Case aCase, ResultSet rs) throws SQLException {
        aCase.setId(rs.getLong("id"));
        aCase.setMaker(rs.getString("maker"));
        aCase.setModel(rs.getString("model"));
        aCase.setPrice(rs.getInt("price"));
        aCase.setMaterial(rs.getString("material"));
        aCase.setPowerSupplyUnit(rs.getString("power_supply_unit"));
        aCase.setTypeOfCase(rs.getString("type_of_case"));
    }

}
