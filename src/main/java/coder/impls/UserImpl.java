package coder.impls;

import coder.daos.UserDao;
import coder.models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session session(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Users> getAllUser() {
        Query query = session().createQuery("from Users");
        List<Users> users = query.list();
        session().flush();
        return users;
    }

    @Override
    public Users getUserById(int id) {
        Users user = session().get(Users.class, id);
        session().flush();
        return user;
    }

    @Override
    public void deleteUser(int id) {
        session().delete(getUserById(id));
        session().flush();
    }

    @Override
    public void updateUser(Users user) {
        session().saveOrUpdate(user);
        session().flush();
    }

    @Override
    public void addUser(Users user) {
        session().save(user);
        session().flush();
    }
}
