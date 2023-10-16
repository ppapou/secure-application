package com.example.secureapplication.service;

import com.example.secureapplication.user.AccountRecord;
import com.example.secureapplication.user.Role;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-15T09:59:06-0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountServiceLayerRecord toService(AccountRecord user) {
        if ( user == null ) {
            return null;
        }

        AccountServiceLayerRecord.AccountServiceLayerRecordBuilder accountServiceLayerRecord = AccountServiceLayerRecord.builder();

        accountServiceLayerRecord.id( user.getId() );
        accountServiceLayerRecord.username( user.getUsername() );
        accountServiceLayerRecord.password( user.getPassword() );
        accountServiceLayerRecord.email( user.getEmail() );
        accountServiceLayerRecord.enabled( user.isEnabled() );

        return accountServiceLayerRecord.build();
    }

    @Override
    public AccountRecord toRepo(AccountServiceLayerRecord user) {
        if ( user == null ) {
            return null;
        }

        AccountRecord accountRecord = new AccountRecord();

        accountRecord.setId( user.getId() );
        accountRecord.setUsername( user.getUsername() );
        accountRecord.setPassword( user.getPassword() );
        accountRecord.setEmail( user.getEmail() );
        Set<Role> set = user.getRoles();
        if ( set != null ) {
            accountRecord.setRoles( new LinkedHashSet<Role>( set ) );
        }
        accountRecord.setEnabled( user.isEnabled() );

        return accountRecord;
    }
}
