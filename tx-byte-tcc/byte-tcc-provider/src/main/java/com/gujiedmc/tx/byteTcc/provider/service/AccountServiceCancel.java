package com.gujiedmc.tx.byteTcc.provider.service;

import com.gujiedmc.tx.byteTcc.provider.dao.IAccountDao;
import com.gujiedmc.tx.byteTcc.provider.interfaces.IAccountService;
import com.gujiedmc.tx.byteTcc.provider.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountServiceCancel")
public class AccountServiceCancel implements IAccountService {
	@Autowired
	private IAccountDao accountDao;

	@Transactional
	public void increaseAmount(String acctId, double amount) {
		Account account = this.accountDao.findById(acctId);
		account.setAmount(account.getAmount() - amount);
		this.accountDao.update(account);
		System.out.printf("undo increase: acct= %s, amount= %7.2f%n", acctId, amount);
	}

	@Transactional
	public void decreaseAmount(String acctId, double amount) {
		Account account = this.accountDao.findById(acctId);
		account.setAmount(account.getAmount() + amount);
		this.accountDao.update(account);
		System.out.printf("undo decrease: acct= %s, amount= %7.2f%n", acctId, amount);
	}

}
