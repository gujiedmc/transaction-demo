package com.gujiedmc.tx.byteTcc.provider.service;

import com.gujiedmc.tx.byteTcc.provider.dao.IAccountDao;
import com.gujiedmc.tx.byteTcc.provider.interfaces.IAccountService;
import com.gujiedmc.tx.byteTcc.provider.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountServiceConfirm")
public class AccountServiceConfirm implements IAccountService {
	@Autowired
	private IAccountDao accountDao;

	@Transactional
	public void increaseAmount(String acctId, double amount) {
		System.out.printf("confirm increase: acct= %s, amount= %7.2f%n", acctId, amount);
	}

	@Transactional
	public void decreaseAmount(String acctId, double amount) {
		System.out.printf("confirm decrease: acct= %s, amount= %7.2f%n", acctId, amount);
	}

}
