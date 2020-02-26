package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudDAOImpl;
import lk.ijse.dep.pos.dao.custom.OrderDAO;
import lk.ijse.dep.pos.entity.Order;

public class OrderDAOImpl extends CrudDAOImpl<Order, Integer> implements OrderDAO {

    @Override
    public int getLastOrderId() throws Exception {
        return (Integer) entityManager.createNativeQuery("SELECT id FROM `Order` ORDER BY id DESC LIMIT 1").getSingleResult();
    }

    @Override
    public boolean existsByCustomerId(String customerId) throws Exception {
        return entityManager.createNativeQuery("SELECT * FROM `Order` WHERE customerId=?1")
                .setParameter(1, customerId).getSingleResult()!=null;
    }
}
