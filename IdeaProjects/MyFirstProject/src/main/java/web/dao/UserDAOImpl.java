package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT c FROM users c", User.class).getResultList();
    }


    public void save(User user) {
        entityManager.persist(user);
    }


    public User findById(int id) {
        return entityManager.find(User.class, id);
    }


    public void update(User user, int id) {
        entityManager.merge(user);
    }


    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));


    }
}
