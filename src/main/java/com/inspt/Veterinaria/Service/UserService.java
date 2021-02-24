package com.inspt.Veterinaria.Service;

import com.inspt.Veterinaria.Entity.User;
import com.inspt.Veterinaria.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Optional<User> findByUserName(String user){
        return this.userRepository.findByUserName(user);
    }
    public Optional<User> findById(int id){
        return this.userRepository.findById(id);
    }
    public List<User> findAll(){
        return this.userRepository.findAll();
    }
    public User save(User user){
        return this.userRepository.save(user);
    }
    public void deleteById(int id){
        this.userRepository.deleteById(id);
    }
}
