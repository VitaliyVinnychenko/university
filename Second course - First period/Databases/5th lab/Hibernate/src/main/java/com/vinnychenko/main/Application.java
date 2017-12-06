package com.vinnychenko.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Application {

    private static SessionFactory ourSessionFactory;
    static {
        try {
            ourSessionFactory =  new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) { throw new ExceptionInInitializerError(ex); }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {

        Session session = getSession();
        try {


            System.out.println("Finish work!");
        } finally {
            session.close();
            System.exit(0);
        }
    }

}