
package com.techarch.usermgmtMs.repositories;
import com.techarch.usermgmtMs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findById(Long id);
}

