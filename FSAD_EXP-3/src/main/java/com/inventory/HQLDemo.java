
package com.inventory;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class HQLDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(new Product("Laptop","Electronics",50000,5));
        session.persist(new Product("Mobile","Electronics",20000,10));
        session.persist(new Product("Tablet","Electronics",30000,7));
        session.persist(new Product("Printer","Electronics",15000,3));
        session.persist(new Product("Mouse","Accessories",500,20));
        session.persist(new Product("Keyboard","Accessories",1200,15));

        System.out.println("Products Inserted");

        Query<Product> q1 = session.createQuery("from Product order by price asc",Product.class);
        List<Product> list1 = q1.list();
        System.out.println("Sorted by Price ASC:");
        list1.forEach(p->System.out.println(p.getName()+" "+p.getPrice()));

        Query<Product> q2 = session.createQuery("from Product order by price desc",Product.class);
        List<Product> list2 = q2.list();
        System.out.println("Sorted by Price DESC:");
        list2.forEach(p->System.out.println(p.getName()+" "+p.getPrice()));

        Query<Product> q3 = session.createQuery("from Product",Product.class);
        q3.setFirstResult(0);
        q3.setMaxResults(3);
        System.out.println("First 3 products:");
        q3.list().forEach(p->System.out.println(p.getName()));

        Long count = session.createQuery("select count(*) from Product",Long.class).uniqueResult();
        System.out.println("Total Products: "+count);

        Double min = session.createQuery("select min(price) from Product",Double.class).uniqueResult();
        Double max = session.createQuery("select max(price) from Product",Double.class).uniqueResult();

        System.out.println("Min Price: "+min);
        System.out.println("Max Price: "+max);

        session.getTransaction().commit();
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
