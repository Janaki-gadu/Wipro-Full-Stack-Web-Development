package com.wipro.cashback.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.wipro.cashback.model.Coupon;
import com.wipro.cashback.model.Customer;

@Repository
public class CashbackDao {

    private final SessionFactory sessionFactory;

    public CashbackDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Customer findCustomer(String customerId) {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customers = session.createQuery(
                "from Customer c where c.customerId = :id", Customer.class)
                .setParameter("id", customerId)
                .setMaxResults(1)
                .getResultList();
        return customers.isEmpty() ? null : customers.get(0);
    }

    public Coupon findCoupon(String couponCode) {
        Session session = sessionFactory.getCurrentSession();
        List<Coupon> coupons = session.createQuery(
                "from Coupon c where c.couponCode = :code", Coupon.class)
                .setParameter("code", couponCode)
                .setMaxResults(1)
                .getResultList();
        return coupons.isEmpty() ? null : coupons.get(0);
    }

    public void updateCustomer(Customer customer) {
        sessionFactory.getCurrentSession().merge(customer);
    }
}
