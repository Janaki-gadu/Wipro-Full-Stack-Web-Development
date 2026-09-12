package com.wipro.hibernate;

import org.hibernate.Session;
import java.util.List;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Main {
    public static void main(String[] args) {
        String color = args.length > 0 ? args[0] : "White";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<CarDetail> cq = cb.createQuery(CarDetail.class);
            Root<CarDetail> root = cq.from(CarDetail.class);
            cq.select(root).where(cb.equal(root.get("color"), color));

            List<CarDetail> cars = session.createSelectionQuery(cq).getResultList();
            cars.forEach(c -> System.out.println(
                    c.getRegNo() + " " + c.getModel() + " " + c.getColor() + " " + c.getManufacturer()));
        }
        HibernateUtil.getSessionFactory().close();
    }
}
