package dr.hasan.clientRegistration.repository;

import dr.hasan.clientRegistration.entity.Client;
import dr.hasan.persistence.HibernatePersistence;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by Imrul on 9/11/2017.
 */
@Repository
public class ClientRepository extends HibernatePersistence {

    public Client registerClient(Client client) {
        Session session = super.getSessionFactory().openSession();
        Client newClient = new Client();
        session.beginTransaction();
        try {
            session.save(client);
            session.getTransaction().commit();
            newClient = client;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        super.shutdown();
        return newClient;
    }
}
