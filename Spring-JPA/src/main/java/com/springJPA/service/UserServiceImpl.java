package com.springJPA.service;

import com.springJPA.model.User;
import com.springJPA.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo repo;
    @Override
    public User createUser(User user) {
        return repo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return repo.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> requestedUser=repo.findById(id);
        return requestedUser.get();
    }

    @Override
    public User updateUser(long id,User user) {
        Optional<User> updateUser=repo.findById(id);
        updateUser.get().setFirstName(user.getFirstName());
        updateUser.get().setLastName(user.getLastName());
        return repo.save(updateUser.get());
    }

    @Override
    public String deleteUser(long id) {
        Optional<User> deleteUser=repo.findById(id);
        repo.deleteById(id);

        return "User "+deleteUser.get()+" Deleted Successfully";
    }
}
