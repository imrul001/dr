package dr.hasan.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by Imrul on 7/14/2017.
 */
public class HibernatePersistence {
//    private static final SessionFactory sessionFactory = buildSessionFactory();

//    private static SessionFactory buildSessionFactory() {
//        try {
//            // Create the SessionFactory from hibernate.cfg.xml
//            Configuration config = new Configuration().configure();
//            ServiceRegistryBuilder srBuilder = new ServiceRegistryBuilder();
//            srBuilder.applySettings(config.getProperties());
//            ServiceRegistry serviceRegistry = srBuilder.buildServiceRegistry();
//            return config.buildSessionFactory(serviceRegistry);
//        }
//        catch (Throwable ex) {
//            // Make sure you log the exception, as it might be swallowed
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public static void shutdown() {
//        // Close caches and connection pools
//        getSessionFactory().close();
//    }
}
