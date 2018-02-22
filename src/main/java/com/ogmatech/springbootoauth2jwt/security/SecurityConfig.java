package com.ogmatech.springbootoauth2jwt.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity(debug = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .formLogin().disable() //disable form authentication
                .anonymous().disable() //disable anonymous user
                .httpBasic().and()
                //restricting access to authenticated users
                .authorizeRequests().anyRequest().denyAll(); //denying all access
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .inMemoryAuthentication() //creating user in memory
                .withUser("user")
                .password("password1").roles("USER")
                .and().withUser("admin")
                .password("password2").authorities("ROLE_ADMIN");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        //provides the default AuthenticationManager as a Bean
        return super.authenticationManagerBean();
    }
}
