package com.zoroapp.job_scheduler.user_security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

    String insertUser(UserEntity user);

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
