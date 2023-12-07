package com.example.appdemo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class Config {

//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        UserDetails user = User.builder().username("admin").password("admin").roles("USER").build();
//        manager.createUser(User.withUsername("user").password("user").roles("USER").build());        return manager;
//    }
@Bean
public UserDetailsService userDetailsService() {
    // The builder will ensure the passwords are encoded before saving in memory
    UserBuilder users = User.withDefaultPasswordEncoder();
    UserDetails user = users
            .username("user")
            .password("user")
            .roles("USER")
            .build();
    UserDetails admin = users
            .username("admin")
            .password("admin")
            .roles("USER", "ADMIN")
            .build();
    System.out.println("Creating user and admin");
    return new InMemoryUserDetailsManager(user, admin);
}
}
