package com.gujiedmc.tx.byteTcc.provider.interfaces;

public interface IAccountService {

	public void increaseAmount(String accountId, double amount);

	public void decreaseAmount(String accountId, double amount);

}
