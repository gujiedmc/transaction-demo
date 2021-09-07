package com.gujiedmc.tx.byteTcc.provider.controller;

import com.gujiedmc.tx.byteTcc.provider.dao.IAccountDao;
import com.gujiedmc.tx.byteTcc.provider.interfaces.IAccountService;
import com.gujiedmc.tx.byteTcc.provider.model.Account;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Compensable(interfaceClass = IAccountService.class, cancellableKey = "accountServiceCancel")
@RestController
public class ProviderController {
	@Autowired
	private IAccountDao accountDao;

	@ResponseBody
	@RequestMapping(value = "/increase/{acctId}/{amount}", method = RequestMethod.POST)
	@Transactional
	public void increaseAmount(@PathVariable("acctId") String acctId, @PathVariable("amount") double amount) {
		Account account = this.accountDao.findById(acctId);
		account.setAmount(account.getAmount() + amount);
		this.accountDao.update(account);
		System.out.printf("exec increase: acct= %s, amount= %7.2f%n", acctId, amount);
	}

	@ResponseBody
	@RequestMapping(value = "/decrease/{acctId}/{amount}", method = RequestMethod.POST)
	@Transactional
	public void decreaseAmount(@PathVariable("acctId") String acctId, @PathVariable("amount") double amount) {
		Account account = this.accountDao.findById(acctId);
		account.setAmount(account.getAmount() - amount);
		this.accountDao.update(account);
		System.out.printf("exec decrease: acct= %s, amount= %7.2f%n", acctId, amount);
	}

}
