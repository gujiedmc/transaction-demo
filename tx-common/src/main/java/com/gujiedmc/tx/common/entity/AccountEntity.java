package com.gujiedmc.tx.common.entity;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

/**
 * 用户账号
 *
 * @author gujiedmc
 * @date 2021-08-20
 */
@Data
@Table(name = "account")
public class AccountEntity {

    private Long id;

    private String username;

    private String password;

    private Integer age;

    private Date birthday;

    private Date createTime;
}
