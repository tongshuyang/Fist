package cn.litman.fist.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 管理员用户信息实体类
 * @author Soyung
 * @email tsyon@qq.com
 * @date 2019/3/23 8:43
 */
@Getter
@Setter
public class User {
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色：0：super  1：admin
     */
    private Byte role;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否禁用：0 :否  1：是
     */
    private Byte isBan;
}