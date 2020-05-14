package coder.daos;

import coder.models.Users;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface UserDao{
    List<Users> getAllUser();
    Users getUserById(int id);
    void deleteUser(int id);
    void updateUser(Users user);
    void addUser(Users user);
}
