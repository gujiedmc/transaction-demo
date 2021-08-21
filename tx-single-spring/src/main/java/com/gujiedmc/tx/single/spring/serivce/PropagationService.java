package com.gujiedmc.tx.single.spring.serivce;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 模拟各种传播类型的事务付昂发
 * @author gujiedmc
 * @date 2021-08-20
 */
public interface PropagationService {

    @Transactional(propagation = Propagation.REQUIRED)
    void required();

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void requiresNew();

    @Transactional(propagation = Propagation.SUPPORTS)
    void supports();

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void notSupported();

    @Transactional(propagation = Propagation.MANDATORY)
    void mandatory();

    @Transactional(propagation = Propagation.NEVER)
    void never();

    @Transactional(propagation = Propagation.NESTED)
    void nested();
}
