package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void save(User user);

    User findById(int id);

    void update(User user, int id);

    void delete(int id);
}
