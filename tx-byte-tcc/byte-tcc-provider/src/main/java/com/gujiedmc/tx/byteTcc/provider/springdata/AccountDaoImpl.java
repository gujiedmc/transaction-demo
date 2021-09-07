package com.gujiedmc.tx.byteTcc.provider.springdata;

import com.gujiedmc.tx.byteTcc.provider.dao.IAccountDao;
import com.gujiedmc.tx.byteTcc.provider.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("accountDao")
public class AccountDaoImpl implements IAccountDao {
	@Autowired
	private AccountRepository repository;

	public Account findById(String identifier) {
		return this.repository.findById(identifier).get();
	}

	public void insert(Account account) {
		this.repository.saveAndFlush(account);
	}

	public void update(Account account) {
		this.repository.saveAndFlush(account);
	}

	public void delete(Account account) {
		this.repository.delete(account);
	}

}
