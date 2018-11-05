package org.vironit.timoshuk.computershop.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.entity.order.PaymentDescription;
import org.vironit.timoshuk.computershop.entity.products.Components.*;
import org.vironit.timoshuk.computershop.entity.products.Computer;
import org.vironit.timoshuk.computershop.entity.users.User;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().build();
            Metadata metadata = new MetadataSources(standardRegistry)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(PaymentDescription.class)
                    .addAnnotatedClass(Computer.class)
                    .addAnnotatedClass(Case.class)
                    .addAnnotatedClass(MotherBoard.class)
                    .addAnnotatedClass(VideoCard.class)
                    .addAnnotatedClass(RAM.class)
                    .addAnnotatedClass(CPU.class)
                    .getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }
        return sessionFactory;
    }
}
