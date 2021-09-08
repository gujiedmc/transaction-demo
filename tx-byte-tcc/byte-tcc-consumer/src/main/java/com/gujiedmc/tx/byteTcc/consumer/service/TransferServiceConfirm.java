package com.gujiedmc.tx.byteTcc.consumer.service;

import com.gujiedmc.tx.byteTcc.consumer.interfaces.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("transferServiceConfirm")
public class TransferServiceConfirm implements ITransferService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void transferAmount(String source, String target, double amount) {
		System.out.printf("confirm transfer: source= %s, target= %s, amount= %7.2f%n", source, target, amount);
	}

}
