package com.gtzz.autouserregister.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author: create by qinjianfie
 * @version: v1.0
 * @description: cn.cncommdata.authorization.model
 * @date:2019/3/25
 */
@Data
@Entity
@NoArgsConstructor
public class UserAccount {

    /**
     * 用户帐号id
     */
    @Id
    private Long userAccountId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户帐号类型
     */
    private String accountType;

    /**
     * 用户登录类型
     */
    private Integer loginType;

    /**
     * 用户帐号
     */
    private String identifier;

    /**
     * 账号密码
     */
    private String credential;

    /**
     * 新建时间
     */
    private java.util.Date createTime;

    /**
     * 更新时间
     */
    private java.util.Date updateTime;

}
