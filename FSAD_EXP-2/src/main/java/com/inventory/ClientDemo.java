package com.inventory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop","Gaming Laptop",80000,5);
        session.persist(p1);

        Product p2 = new Product("Mobile","Android Phone",20000,10);
        session.persist(p2);

        System.out.println("Products Inserted");

        Product p = session.get(Product.class,1);
        if(p!=null){
            System.out.println("Product Name: "+p.getName());
            p.setPrice(75000);
            session.merge(p);
            System.out.println("Product Updated");
        }

        Product d = session.get(Product.class,2);
        if(d!=null){
            session.remove(d);
            System.out.println("Product Deleted");
        }

        tx.commit();
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
