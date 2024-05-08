package com.todoapp.todoproject.repositories;

import com.todoapp.todoproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {  // we create a repository for every entity we create
    User findByUsernameAndPassword(String username, String password);
    //the first get method to find user based on username and password
    User findTopByUsername(String username);
    //looks for the first user in our db that has a username
    User findTopByPassword(String password);
//looks for the first user that has a password
}