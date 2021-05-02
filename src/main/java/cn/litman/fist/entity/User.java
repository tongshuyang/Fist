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

    /**
     * 用户ID
     */
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
     * 姓名
     */
    private String name;

    /**
     * 角色, 0：admin 1：user
     */
    private Byte role;

    /**
     * 是否禁用：0 :否  1：是
     */
    private Byte isBan;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

}