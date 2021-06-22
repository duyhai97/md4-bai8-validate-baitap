package service;

import exception.NotfoundException;
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
    public User findById(Long id) throws NotfoundException{
        User user = repository.findOne(id);
        if (user != null) return user;
        throw new NotfoundException("Khong tim thay");

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
