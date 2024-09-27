package com.zoroapp.job_scheduler.user_security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user-security")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private Role role;
    @Column
    private String phoneNumber;
    @Column
    private Date createdAt;
    @Column
    private Date updateAt;
    @Column
    private Status status;
//    private Date lastLogin;
//    private String organizationName;
    @Column
    private int jobQuota;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
//    private String profilePictureUrl;
//    private boolean twoFactorEnabled;
}
