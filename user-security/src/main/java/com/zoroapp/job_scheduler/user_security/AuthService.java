package com.zoroapp.job_scheduler.user_security;

public interface AuthService {

    public String register(RegisterRequest register);

    public UserEntity login(LoginRequest login);
}
