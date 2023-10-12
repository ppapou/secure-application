package com.example.secureapplication.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
//TODO:Remove the logger
// - remove userDetails
// - is it better to use ENUM for static values, like User roles?
@Slf4j
@Configuration
@EnableWebSecurity
public class SecSecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("user")
//                .password(passwordEncoder().encode("userPass1"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("adminPass1"))
//                .roles("ADMIN")
//                .build();
//        manager.createUser(user);
//        manager.createUser(admin);
//        return manager;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/info").hasRole("USER")
                        .requestMatchers("/about").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
