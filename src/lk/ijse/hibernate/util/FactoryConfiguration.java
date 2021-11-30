package lk.ijse.hibernate.util;

import lk.ijse.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;


    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure().
                addAnnotatedClass(Customer.class).
//                addAnnotatedClass(CustomerOrder.class).
                addAnnotatedClass(Item.class);
//                addAnnotatedClass(Order.class);
//                addAnnotatedClass(OrderDetail.class);
        sessionFactory = configuration.buildSessionFactory();

    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration()
                : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
