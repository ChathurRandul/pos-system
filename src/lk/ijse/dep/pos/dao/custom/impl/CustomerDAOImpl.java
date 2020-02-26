package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudDAOImpl;
import lk.ijse.dep.pos.dao.custom.CustomerDAO;
import lk.ijse.dep.pos.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerDAOImpl extends CrudDAOImpl<Customer, String> implements CustomerDAO {

    @Override
    public String getLastCustomerId() throws Exception {
        return (String) entityManager.createNativeQuery("SELECT customerId FROM Customer ORDER BY customerId DESC LIMIT 1").getSingleResult();
    }
}
