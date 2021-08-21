package com.gujiedmc.tx.single.spring.serivce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author gujiedmc
 * @date 2021-08-20
 */
@Slf4j
@Service
public class PropagationServiceImpl implements PropagationService {

    @Override
    public void required() {
        log.info("execute required");
    }

    @Override
    public void requiresNew() {
        log.info("execute requiresNew");
    }

    @Override
    public void supports() {
        log.info("execute supports");
    }

    @Override
    public void notSupported() {
        log.info("execute notSupported");
    }

    @Override
    public void mandatory() {
        log.info("execute mandatory");
    }

    @Override
    public void never() {
        log.info("execute never");
    }

    @Override
    public void nested() {
        log.info("execute nested");
    }
}
