package com.project.springData.repository;

import com.project.springData.entity.Role;
import com.project.springData.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToManyBidirectional {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    void saveRole(){

        User user = new User();
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setEmail("admin@gmail.com");
        user.setPassword("admin@123");

        //User user1 = userRepository.findById(1l).get();

        Role role = roleRepository.findByName("ADMIN");
        role.getUsers().add(user);
        user.getRoles().add(role);

        roleRepository.save(role);

    }

    @Test
    void deleteAllUsers(){

        userRepository.deleteAll();
    }

}
