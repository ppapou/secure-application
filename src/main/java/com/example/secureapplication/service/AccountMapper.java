package com.example.secureapplication.service;


import com.example.secureapplication.config.MappingConfig;
import com.example.secureapplication.user.AccountRecord;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(config = MappingConfig.class)
@Component
public interface AccountMapper {
    AccountServiceLayerRecord toService(AccountRecord user);
    AccountRecord toRepo(AccountServiceLayerRecord user);

}
