package com.techarch.usermgmtMs.controller;


import com.techarch.usermgmtMs.model.User;
import com.techarch.usermgmtMs.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.logging.Logger;

@AllArgsConstructor
//@NoArgsConstructor

@RestController
public class UserController {
    private final UserServiceImpl userServiceImpl;
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAlluser() {

        return new ResponseEntity<List<User>>(userServiceImpl.getAllUsers(), HttpStatus.OK);


    }
    @PostMapping ("/users/{id}")
    public ResponseEntity<User> addCustomer(@PathVariable Long id, @RequestBody User user) {

        return new ResponseEntity<>(userServiceImpl.addUser(user), HttpStatus.CREATED);
    }
    @GetMapping("users/{id}")
    public ResponseEntity<User> getdataUserById(@PathVariable Long id) {
        User user = userServiceImpl.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUserData(@PathVariable Long id, @RequestBody User user) {

        return new ResponseEntity<>(userServiceImpl.updateUser(user), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        return new ResponseEntity<>(userServiceImpl.addUser(user), HttpStatus.CREATED);

    }
    @DeleteMapping ("/users/{id}")
    public ResponseEntity<String> deleteUserData(@PathVariable Long id) {

        boolean isDeleted = userServiceImpl.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.ok("User deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }

    }
    @GetMapping ("/users/{id}/kyc")
    public ResponseEntity<String> getKycStatus(@PathVariable Long id) {
            String kycStatus = userServiceImpl.getKycStatusById(id);
        System.out.println("kuc status is" +"="+kycStatus);
            return ResponseEntity.ok(kycStatus);

    }


    @ExceptionHandler
    public ResponseEntity<String> respondWithError(Exception e) {
        logger.error("Exception occured.Details {} ", e.getMessage());
        return new ResponseEntity<>("exception Occur" + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public class ResourceNotFoundException extends RuntimeException {
//        public ResourceNotFoundException(String message) {
//            super(message);
//        }
//    }

}
