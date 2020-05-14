package coder.services;

import coder.daos.UserDao;
import coder.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<Users> getAllUser(){
        return userDao.getAllUser();
    }

    public Users getUserById(int id){
        return userDao.getUserById(id);
    }

    public void deleteUser(int id){
        userDao.deleteUser(id);
    }

    public void updateUser(Users user){
        userDao.updateUser(user);
    }

    public void addUser(Users user){
        userDao.addUser(user);
    }
}
