package com.inspt.Veterinaria.Repository;

import com.inspt.Veterinaria.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUserName(String user);
    Optional<User> findById(int id);
    List<User> findAll();
    User save(User user);
    void deleteById(int id);
}
