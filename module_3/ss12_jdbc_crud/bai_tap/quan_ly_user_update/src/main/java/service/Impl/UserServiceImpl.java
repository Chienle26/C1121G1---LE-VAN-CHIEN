package service.Impl;

import model.User;
import repository.Impl.UserRepositoryImpl;
import repository.UserRepository;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public List<User> selectAllUsers() {
        return userRepository.selectAllUsers();
    }

    @Override
    public void insertUser(User user) throws SQLException {
        userRepository.insertUser(user);
    }
}
