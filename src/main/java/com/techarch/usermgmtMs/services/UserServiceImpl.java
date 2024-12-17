package com.techarch.usermgmtMs.services;

import com.techarch.usermgmtMs.model.User;
import com.techarch.usermgmtMs.repositories.UserRepository;
import com.techarch.usermgmtMs.services.interfaces.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    private static final Logger logger = LogManager.getLogger(UserRepository.class);
    @Transactional
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
        //return ;
    }
    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public User updateUser(User user) {

        if (!userRepository.existsById(user.getUser_id())) {
            logger.error("User with ID {} not found for update", user.getUser_id());
            return null;
        }

        logger.info("Updating user: {}", user.getUsername());
        return userRepository.save(user);


    }
    @Transactional
    @Override
    public boolean deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            logger.error("User with ID {} not found for deletion", id);
            return false;  // User doesn't exist
        }
        userRepository.deleteById(id);
        logger.info("Deleted user with ID: {}", id);
        return true;
    }
    @Transactional
    @Override
    public String getKycStatusById(Long id){
       Optional<User> user=userRepository.findById(id);
        User user1=user.get();
        return user1.getKyc_status();
    }



}
