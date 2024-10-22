package com.einarr07.spring_boot_microservice_3_api_gateway.service;

import com.einarr07.spring_boot_microservice_3_api_gateway.model.Role;
import com.einarr07.spring_boot_microservice_3_api_gateway.model.User;
import com.einarr07.spring_boot_microservice_3_api_gateway.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setFechaCreacon(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public void  changeRole(Role newRole, String username){
        userRepository.updateuserRole(username, newRole);
    }
}
