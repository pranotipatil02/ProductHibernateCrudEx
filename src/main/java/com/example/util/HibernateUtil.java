package com.example.util;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.example.model.Product;
public class HibernateUtil {
private static final SessionFactory sessionFactory=buildSessionFactory();

private static SessionFactory buildSessionFactory() {
	// TODO Auto-generated method stub
try
{
	return new Configuration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
}
catch(Throwable ex)
{
	System.err.println("Initial SessionFactory creation failed. " + ex);
    throw new ExceptionInInitializerError(ex);	
}
}


public static SessionFactory getSessionFactory()
{
	return sessionFactory;
}
}
