package com.zoroapp.job_scheduler.user_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private UserSecurityRepository userSecurityRepository;

    @Autowired
    public UserServiceImpl(UserSecurityRepository userSecurityRepository) {
        this.userSecurityRepository=userSecurityRepository;
    }

    @Override
    public String insertUser(UserEntity userEntity) {
        userSecurityRepository.saveAndFlush(userEntity);
        return "Registered";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userSecurityRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Invalid cred"));
    }
}
