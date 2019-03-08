package dr.hasan.clientLogin.repository;

import dr.hasan.clientLogin.entity.UserLogin;
import dr.hasan.persistence.BaseRepository;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Imrul on 10/13/2017.
 */
@Repository
public class UserLoginRepository extends BaseRepository<UserLogin> {

    public void save(UserLogin userLogin){
        try {
            Session session = getSession();
//            session.beginTransaction();
            session.save(userLogin);
//            if(!session.getTransaction().wasCommitted()){
//                session.getTransaction().commit();
//            }
            session.clear();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    public void update(UserLogin userLogin){
        try {
            Session session = getSession();
            session.update(userLogin);
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    public void delete(UserLogin userLogin){
        try {
            Session session = getSession();
//            session.beginTransaction();
            session.delete(userLogin);
//            session.getTransaction().commit();
//            session.clear();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    public boolean isExist(String email){
        Session session = getSession();
        Criteria criteria  = session.createCriteria(UserLogin.class);
        return criteria.add(Restrictions.eq("email", email)).list().size() > 0;
    }
}
