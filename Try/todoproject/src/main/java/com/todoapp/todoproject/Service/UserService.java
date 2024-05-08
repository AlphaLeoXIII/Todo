package com.todoapp.todoproject.Service;
//we're going to only get and create in this feature.
import com.todoapp.todoproject.entity.User;
import com.todoapp.todoproject.repositories.UserRepository;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUser(User user){
        System.out.print("Service get *****");
     return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
     //validates the username and password with a return boolean
    }
    public boolean getUserByUsername(String username, String password) {
        boolean username_present;
        boolean password_present;
        try {
            username_present = userRepository.findTopByUsername(username) != null ? true : false;
            System.out.print("username present: " + username_present);
            password_present = userRepository.findTopByPassword(password) != null ? true : false;
            System.out.print("Password present: " + password_present);
        } catch (NonUniqueResultException nre) {
            return true;
        }
        return username_present && password_present;
    }
     public  boolean findUserByUsername(String username){
        boolean username_present;
         try{
             username_present = userRepository.findTopByUsername(username) != null ? true:false;
             //is there to check if the user already exists on the database
             System.out.println("Username present(U): "+ username_present);
         }catch(NonUniqueResultException nre){
             return true;
         }
         return username_present;
     }
     public  void saveUser(User user){
        userRepository.save(user);
        //saveUser method to add user to the database
     }
}

