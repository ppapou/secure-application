package com.example.secureapplication.service;


import com.example.secureapplication.user.Role;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.HashSet;
import java.util.Set;

@Value
@Builder
@EqualsAndHashCode
public class AccountServiceLayerRecord {

    @EqualsAndHashCode.Include
    Long id;
    String username;
    String password;
    String email;
    Set<Role> roles = new HashSet<>();
    boolean enabled;
}
