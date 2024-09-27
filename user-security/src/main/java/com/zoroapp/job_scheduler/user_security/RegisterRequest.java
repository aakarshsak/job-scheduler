package com.zoroapp.job_scheduler.user_security;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Role role;
    private String phoneNumber;
    private Date createdAt;
    private Date updateAt;
    private Status status;
    //    private Date lastLogin;
//    private String organizationName;
    private int jobQuota;
    
}
