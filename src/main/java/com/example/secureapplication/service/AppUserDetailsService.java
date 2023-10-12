package com.example.secureapplication.service;

import com.example.secureapplication.repo.UserRepository;
import com.example.secureapplication.user.User;
import com.example.secureapplication.user.AppUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new AppUserDetails(user);
    }

    public UserDetails createUser(User user) {
        User newUser = userRepository.save(user);
        return new AppUserDetails(newUser);
    }
}