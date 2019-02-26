package com.nhnent.edu.spring_boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// TODO : #11 @EnableWebSecurity is set by default.
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/redirect-index").authenticated()
                    .anyRequest().permitAll()
                    .and()
                // TODO : #13 activate oauth2 login.
                .oauth2Login()
                    .and()
                .csrf()
                    .disable();
    }
}
