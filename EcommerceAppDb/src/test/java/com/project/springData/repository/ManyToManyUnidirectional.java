package com.project.springData.repository;

import com.project.springData.entity.Role;
import com.project.springData.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToManyUnidirectional {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser(){

        User user = new User();
        user.setFirstName("Manjunatha");
        user.setLastName("D");
        user.setEmail("manjunatha.d@gmail.com");
        user.setPassword("pass@123");

        Role admin = new Role();
        admin.setName("ADMIN");

        Role customer = new Role();
        customer.setName("CUSTOMER");

        user.getRoles().add(admin);
        user.getRoles().add(customer);

        userRepository.save(user);

    }

    @Test
    void fetchUser(){

        User user = userRepository.findById(1l).get();
        System.out.println(user.getEmail());
        user.getRoles().stream().map(item -> item.getName()).forEach(System.out::println);

    }

    @Test
    void deleteUser(){

        userRepository.deleteById(1l);
    }
}
