package dr.hasan.clientLogin.repository;

import dr.hasan.clientLogin.entity.UserLogin;
import dr.hasan.persistence.HibernatePersistence;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by Imrul on 10/13/2017.
 */
@Repository
public class UserLoginRepository extends HibernatePersistence {

    public void save(UserLogin userLogin){
        try {
            Session session = super.getSessionFactory().openSession();
            session.persist(userLogin);
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    public void update(UserLogin userLogin){
        try {
            Session session = super.getSessionFactory().openSession();
            session.update(userLogin);
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    public void delete(UserLogin userLogin){
        try {
            Session session = super.getSessionFactory().openSession();
            session.delete(userLogin);
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }
}
