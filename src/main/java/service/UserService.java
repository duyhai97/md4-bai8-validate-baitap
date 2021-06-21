package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IUserRepository;

import java.util.List;

public class UserService implements IUserService{

    @Autowired
    private IUserRepository repository;

    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void remove(Long id) {
        repository.delete(id);
    }
}
