package com.gujiedmc.tx.byteTcc.provider.springdata;

import com.gujiedmc.tx.byteTcc.provider.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account, String> {
}
