package com.example.XindusProject.Repositories;

import com.example.XindusProject.Modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
     public User findByName(String username);
}
