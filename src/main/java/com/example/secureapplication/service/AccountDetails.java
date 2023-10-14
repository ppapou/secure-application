package com.example.secureapplication.service;

import com.example.secureapplication.repo.AccountDB;
import com.example.secureapplication.user.AccountRecord;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountDetails implements UserDetailsService {
    private final AccountDB accountDB;
    private final AccountMapper mapper;

    public AccountDetails(AccountDB accountDB, AccountMapper mapper) {
        this.accountDB = accountDB;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountRecord accountRecord = accountDB.findByUsername(username);
        if (accountRecord == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new com.example.secureapplication.user.AccountDetails(accountRecord);
    }

    public UserDetails createUser(AccountServiceLayerRecord user) {
        AccountRecord newAccountRecord = accountDB.save(mapper.toRepo(user));
        return new com.example.secureapplication.user.AccountDetails(newAccountRecord);
    }
}