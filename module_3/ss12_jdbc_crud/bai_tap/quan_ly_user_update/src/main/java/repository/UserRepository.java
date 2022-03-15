package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    public List<User> selectAllUsers();

    void insertUser(User user) throws SQLException;
}
