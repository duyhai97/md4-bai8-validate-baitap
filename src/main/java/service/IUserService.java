package service;

import exception.NotfoundException;
import model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Long id) throws NotfoundException;

    void save(User user);

    void remove(Long id);
}
