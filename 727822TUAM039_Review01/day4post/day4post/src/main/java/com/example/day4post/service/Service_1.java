package com.example.day4post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.day4post.model.User;
import com.example.day4post.repository.Repository;
@Service
public class Service_1 
{
    @Autowired
    public Repository ab;
    // private PasswordEncoun pe;

    //create new user

    public User createnewuser(@NonNull User user)
    {
        return ab.save(user);
    }

    //getuser

    public List<User> getAllusers()
    {
        return ab.findAll();
    }

    //EIETHER WAYS WE CAN FINDALL THE USERS BY FINDALL AS WELL AS THROUGH THE EMAIL
    
    //getuserusingemailid
    
    public Optional<User> getModelByEmail(String email)
    {
        return ab.findByEmail(email);
    }

    //updateUser

    public User updateUser(@NonNull String email,@RequestBody User user)
    {
        return ab.findByEmail(email)
        .map(existingUser -> {
        existingUser.setFullname(user.getFullname());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setProduct_name(user.getProduct_name());
        existingUser.setProduct_price(user.getProduct_price());
        return ab.save(existingUser);

        }
        )

        .orElseThrow(() -> new RuntimeException("User not found with this email: "+ email));

    }
    public void removeUser(@NonNull Integer userId)
    {
        ab.deleteById(userId);
    }


   

    
}