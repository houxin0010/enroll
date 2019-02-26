package com.school.enroll.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.school.enroll.entity.Role;
import com.school.enroll.entity.User;
import com.school.enroll.entity.UserRole;
import com.school.enroll.mapper.RoleMapper;
import com.school.enroll.mapper.UserMapper;
import com.school.enroll.mapper.UserRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houxin
 */
@Slf4j
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("username = {}", s);
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, s));
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<Role> roles = new ArrayList<>();
        List<UserRole> userRoles = userRoleMapper.selectList(new LambdaQueryWrapper<UserRole>().eq(UserRole::getId, user.getId()));
        userRoles.forEach((userRole -> roles.add(roleMapper.selectById(userRole.getRoleId()))));
        return new MyUserDetails(user, roles);
    }
}
