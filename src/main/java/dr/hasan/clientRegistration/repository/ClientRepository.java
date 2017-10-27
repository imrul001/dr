package dr.hasan.clientRegistration.repository;

import dr.hasan.clientRegistration.entity.Client;
import dr.hasan.persistence.HibernatePersistence;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
//            session.flush();
//            session.close();
//            super.shutdown();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.clear();
        return newClient;
    }

    public Client getClient(String email, String password){
        Session session = super.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Client.class);
        criteria.add(Restrictions.eq("email", email))
                .add(Restrictions.eq("password", password));
        return (Client) criteria.uniqueResult();
    }
}
