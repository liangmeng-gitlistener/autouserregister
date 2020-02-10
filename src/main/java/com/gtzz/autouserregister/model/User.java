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
public class User {

    /**
     * 用户id
     */
    @Id
    private Long userId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 新建时间
     */
    private java.util.Date createTime;

    /**
     * 更新时间
     */
    private java.util.Date updateTime;

}
