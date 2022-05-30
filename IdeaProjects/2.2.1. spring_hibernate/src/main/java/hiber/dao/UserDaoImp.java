package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {

        Query query = sessionFactory.getCurrentSession().createQuery("from User");

        return query.getResultList();
    }

    @Override
    public User getUserByCar(String model, int series) {
        String query = "from User u where u.car.model= :mod and u.car.series = :ser";
        Query<User> query2 = sessionFactory.getCurrentSession().createQuery(query, User.class);
        query2.setParameter("mod", model).setParameter("ser", series);
        return query2.setMaxResults(1).getSingleResult();
    }
}
