package com.wipro.cashback.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.cashback.dao.CashbackDao;
import com.wipro.cashback.model.Coupon;
import com.wipro.cashback.model.Customer;

@Service
public class CashbackService {

    private final CashbackDao dao;

    public CashbackService(CashbackDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = true)
    public Customer authenticate(String customerId, String password) {
        Customer customer = dao.findCustomer(customerId);
        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Customer getCustomer(String customerId) {
        return dao.findCustomer(customerId);
    }

    @Transactional
    public CashbackResult claimCashback(String customerId, String couponCode) {
        Customer customer = dao.findCustomer(customerId);
        Coupon coupon = dao.findCoupon(couponCode);

        if (customer == null) {
            return CashbackResult.error("Invalid Customer ID.");
        }
        if (coupon == null) {
            return CashbackResult.error("Invalid Coupon Code.");
        }

        double cashback = customer.getBalance() * coupon.getOfferPercentage() / 100.0;
        double updatedBalance = customer.getBalance() + cashback;
        customer.setBalance(updatedBalance);
        dao.updateCustomer(customer);

        return CashbackResult.success(coupon.getOfferPercentage(), cashback, updatedBalance);
    }

    public static class CashbackResult {
        private final boolean success;
        private final String message;
        private final double percentage;
        private final double cashback;
        private final double updatedBalance;

        private CashbackResult(boolean success, String message,
                               double percentage, double cashback, double updatedBalance) {
            this.success = success;
            this.message = message;
            this.percentage = percentage;
            this.cashback = cashback;
            this.updatedBalance = updatedBalance;
        }

        public static CashbackResult success(double percentage, double cashback, double updatedBalance) {
            return new CashbackResult(true, null, percentage, cashback, updatedBalance);
        }

        public static CashbackResult error(String message) {
            return new CashbackResult(false, message, 0, 0, 0);
        }

        public boolean isSuccess() { return success; }
        public String getMessage() { return message; }
        public double getPercentage() { return percentage; }
        public double getCashback() { return cashback; }
        public double getUpdatedBalance() { return updatedBalance; }
    }
}
