package dr.hasan.clientRegistration.repository;

import dr.hasan.clientRegistration.entity.Client;
import dr.hasan.persistence.BaseRepository;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Imrul on 9/11/2017.
 */
@Repository
public class ClientRepository extends BaseRepository<Client> {

    public Client registerClient(Client client) {
        Client newClient = new Client();
        Session session = getSession();
        try {
            session.save(client);
            newClient = client;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return newClient;
    }

    public Client getClient(String email, String password){
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("email", email))
                .add(Restrictions.eq("password", password));
        return (Client) criteria.uniqueResult();
    }
}
