package ru.gothmog.ws.dao;

import ru.gothmog.ws.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDao extends JpaDAO<User> implements GenericDao<User> {

    public UserDao(EntityManager entityManager) {
        super(entityManager);
    }

    public User create(User user){
        return super.create(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User get(Object id) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
