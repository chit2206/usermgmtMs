package com.techarch.usermgmtMs.services.interfaces;
import com.techarch.usermgmtMs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(User user);
    boolean deleteUser(Long id);
    String getKycStatusById(Long id);
}