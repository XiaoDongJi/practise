package com.cckeep.elastic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/save")
    public User saveUser(Integer id){
        User user = new User();
        user.setAddress("sdfsdfsd");
        user.setAge(232);
        user.setPhoneNumber("223333");
        return userRepository.save(user);
    }

}
