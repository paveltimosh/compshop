package org.vironit.timoshuk.computershop;


import org.hibernate.Session;
import org.vironit.timoshuk.computershop.util.HibernateUtil;

public class Main  {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Session is succesfful");
    }

}

