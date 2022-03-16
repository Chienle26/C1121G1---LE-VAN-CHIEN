package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public List<User> selectAllUsers();

    void insertUser(User user) throws SQLException;

    User selectUser(Integer id);

    boolean deleteUser(Integer id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    List<User> sortByName();

    List<User> searchByCountry(String country);
}
