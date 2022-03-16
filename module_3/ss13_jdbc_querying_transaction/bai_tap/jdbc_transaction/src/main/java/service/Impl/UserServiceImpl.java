package service.Impl;

import model.User;
import repository.Impl.UserRepositoryImpl;
import repository.UserRepository;
import service.UserService;

import java.sql.Connection;
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
        userRepository.insertUserStore(user);
    }

    @Override
    public User selectUser(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    public boolean deleteUser(Integer id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userRepository.updateUser(user);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }

    @Override
    public List<User> searchByCountry(String country) {
        return userRepository.searchByCountry(country);
    }

    @Override
    public List<User> selectAllUserStore() {
        return userRepository.selectAllUserStore();
    }

    @Override
    public void updateUserStore(User user) {
        userRepository.updateUserStore(user);
    }

    @Override
    public void deleteUserStore(Integer id) {
        userRepository.deleteUserStore(id);
    }

    @Override
    public void addUserTransaction(User user) {
        userRepository.addUserTransaction(user);
    }
}
