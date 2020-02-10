package com.gtzz.autouserregister.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
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
public class Grant {

    /**
     * 授予id
     */
    @Id
    private Long grantId;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 职位id
     */
    private Long dutiesId;

    /**
     * 是否为用户默认登录企业
     */
    private Integer defaul;

    /**
     * 是否为企业系统管理员
     */
    private Integer grantAdmin;

    /**
     * 是否启用
     */
    private Integer state;

    /**
     * 菜单
     */
    private String menu;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    /**
     * 更新时间
     */
    private java.util.Date updateTime;

}
