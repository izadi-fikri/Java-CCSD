//usersService.java
package com.example.ccsd.Users;

import com.mongodb.client.MongoIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usersService {

    @Autowired
    private usersRepository usersRepository;

    public Optional<users> getUserById(String userId) {
        return usersRepository.findById(userId);
    }

    public users addUser(users user) {
        return usersRepository.save(user);
    }

    public List<users> getAllUsers() {
        return usersRepository.findAll();
    }

    public users updateUser(String id, users userDetails) {
        return usersRepository.findById(id).map(existingUser -> {
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setFirstName(userDetails.getFirstName());
            existingUser.setLastName(userDetails.getLastName());
            existingUser.setPhoneNumber(userDetails.getPhoneNumber());
            existingUser.setAddress(userDetails.getAddress());
            existingUser.setRole(userDetails.getRole());
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setDob(userDetails.getDob());
            existingUser.setProfPic(userDetails.getProfPic());
            return usersRepository.save(existingUser);
        }).orElse(null);
    }

    public users getUserByEmail(Object email) {
        return usersRepository.findByEmail(email.toString());
    }

    public void deleteUser(String userId) {
        usersRepository.deleteById(userId);
    }
}
