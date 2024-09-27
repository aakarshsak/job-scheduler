package com.zoroapp.job_scheduler.user_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @Autowired
    public AuthServiceImpl(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public String register(RegisterRequest register) {
        UserEntity user = UserEntity.builder()
                .email(register.getEmail())
                .username(register.getUsername())
                .firstname(register.getFirstname())
                .lastname(register.getLastname())
                .phoneNumber(register.getPhoneNumber())
                .createdAt(register.getCreatedAt())
                .updateAt(register.getUpdateAt())
                .role(register.getRole())
                .password(passwordEncoder.encode(register.getPassword()))
                .jobQuota(register.getJobQuota())
                .status(register.getStatus())
                .build();

        return userService.insertUser(user);
    }

    @Override
    public UserEntity login(LoginRequest login) {
        UserEntity user = (UserEntity) userService.loadUserByUsername(login.getUsername());
        boolean matches = passwordEncoder.matches(login.getPassword(), user.getPassword());

        if(user==null || !matches) {
            throw new UsernameNotFoundException("Invalid cred");
        }
        return user;
    }
}
