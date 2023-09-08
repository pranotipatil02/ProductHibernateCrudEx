package com.example;

import com.example.model.Product;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
 
            
            // HQL Queries
            // 1. Select all products
            Query<Product> query1 = session.createQuery("FROM Product", Product.class);
            List<Product> products1 = query1.getResultList();

            // 2. Select products with a specific price range
            Query<Product> query2 = session.createQuery("FROM Product WHERE price BETWEEN :minPrice AND :maxPrice", Product.class);
            query2.setParameter("minPrice", 10.0);
            query2.setParameter("maxPrice", 50.0);
            List<Product> products2 = query2.getResultList();

            // 3. Update product price
            Query updateQuery = session.createQuery("UPDATE Product SET price = price * 1.1 WHERE price < :threshold");
            updateQuery.setParameter("threshold", 30.0);
            int updatedCount = updateQuery.executeUpdate();

            // 4. Delete products by name
            Query deleteQuery = session.createQuery("DELETE FROM Product WHERE name LIKE :productName");
            deleteQuery.setParameter("productName", "%Old%");
            int deletedCount = deleteQuery.executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}
