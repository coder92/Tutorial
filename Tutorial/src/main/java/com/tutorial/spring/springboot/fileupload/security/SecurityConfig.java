package com.tutorial.spring.springboot.fileupload.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.tutorial.spring.springboot.fileupload.exception.AuthenticationException;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
         .csrf().disable()
         .authorizeRequests().anyRequest().authenticated()
         .and()
         .httpBasic();
    }
  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws AuthenticationException
    {
        try {
			auth.inMemoryAuthentication()
			    .withUser("admin")
			    .password("{noop}admin")
			    .roles("USER");
		} catch (Exception e) {
			throw new AuthenticationException();
		}
    }
}