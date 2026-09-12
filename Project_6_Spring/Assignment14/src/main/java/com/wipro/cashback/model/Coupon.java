package com.wipro.cashback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "COUPON")
public class Coupon {

    @Id
    @Column(name = "CouponCode", length = 20)
    private String couponCode;

    @Column(name = "OfferPercentage", nullable = false)
    private double offerPercentage;

    public Coupon() {}

    public Coupon(String couponCode, double offerPercentage) {
        this.couponCode = couponCode;
        this.offerPercentage = offerPercentage;
    }

    public String getCouponCode() { return couponCode; }
    public void setCouponCode(String couponCode) { this.couponCode = couponCode; }

    public double getOfferPercentage() { return offerPercentage; }
    public void setOfferPercentage(double offerPercentage) { this.offerPercentage = offerPercentage; }
}
