package com.zaahid.user_management.services;

import java.util.List;

import com.zaahid.user_management.model.User;
import com.zaahid.user_management.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    
    @Autowired
    private UserRepository repo;

    public List<User> listAll(){
        return repo.findAll();
    }

    public void save(User user ){
        repo.save(user);
    }

    public User get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
