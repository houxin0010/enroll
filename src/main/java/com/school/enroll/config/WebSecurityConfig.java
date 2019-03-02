package com.school.enroll.config;

import com.school.enroll.security.CustomUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author houxin
 */
@Slf4j
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService() { //注册CustomUserService的Bean
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                return bCryptPasswordEncoder.encode(charSequence.toString());
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                boolean matches = bCryptPasswordEncoder.matches(charSequence.toString(), s);
                if (!matches) {
                    log.info("密码错误");
                }
                return matches;
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement()
                .maximumSessions(1)
                .sessionRegistry(new SessionRegistryImpl());
        http.authorizeRequests()
                //后台管理只允许管理员角色访问
                .antMatchers("/backstage/**").hasRole("ADMIN")
                //其他请求需要登录认证
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/backstage/primary/index").permitAll()
                .failureUrl("/login?error").permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/login").permitAll();
    }
}
