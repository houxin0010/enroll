package com.school.enroll.security;

import com.school.enroll.entity.Role;
import com.school.enroll.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author houxin
 */
public class MyUserDetails extends User implements UserDetails {
    private static final long serialVersionUID = 8468506701836672264L;

    private List<Role> roles;

    public MyUserDetails() {
    }

    MyUserDetails(User user, List<Role> roles) {
        super(user);
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = this.roles;
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleCode())));
        return authorities;
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
}
