package com.gujiedmc.tx.single.spring.serivce;

import com.gujiedmc.tx.common.entity.AccountEntity;
import com.gujiedmc.tx.single.spring.dao.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gujiedmc
 * @date 2021-08-20
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private PropagationService propagationService;

    @Transactional
    @Override
    public void add(AccountEntity account) {
        log.info("execute add account start");

        propagationService.mandatory();

        accountMapper.insertSelective(account);

        log.info("execute add account completed");
    }


}
