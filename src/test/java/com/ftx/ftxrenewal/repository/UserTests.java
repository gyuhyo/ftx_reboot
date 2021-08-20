package com.ftx.ftxrenewal.repository;

import com.ftx.ftxrenewal.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void getUserTest() {
        Optional<User> result = userRepository.findById("qkrrbgy");
        User user = result.get();

        System.out.println(user);
    }
}
