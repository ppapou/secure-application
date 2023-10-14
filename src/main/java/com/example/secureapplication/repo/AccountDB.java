package com.example.secureapplication.repo;

import com.example.secureapplication.user.AccountRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountDB extends JpaRepository<AccountRecord, Long>, JpaSpecificationExecutor<AccountRecord> {
    AccountRecord findByUsername(String username);
}
