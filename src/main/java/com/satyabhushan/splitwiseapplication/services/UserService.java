package com.satyabhushan.splitwiseapplication.services;

import com.satyabhushan.splitwiseapplication.exceptions.UserAlreadyExist;
import com.satyabhushan.splitwiseapplication.models.User;
import com.satyabhushan.splitwiseapplication.models.UserStatus;
import com.satyabhushan.splitwiseapplication.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    
    private UserRepository userRepository ;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(String userName, String phoneNumber, String password) throws UserAlreadyExist {
        Optional<User> userOptional = userRepository.findByPhoneNumber(phoneNumber);
        if(userOptional.isPresent()){
            if(userOptional.get().getUserStatus().equals(UserStatus.ACTIVE)){
                throw new UserAlreadyExist("A User with same phoneNumber exists");
            }else{
                User user = userOptional.get();
                user.setName(userName);
                user.setPassword(password);
                user.setPhoneNumber(phoneNumber);
                user.setUserStatus(UserStatus.ACTIVE);
                return userRepository.save(user);
            }
        }
//
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setUserStatus(UserStatus.ACTIVE);

        return userRepository.save(user);
    }
}
