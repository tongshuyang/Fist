package cn.litman.fist.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 客户信息实体类
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/6/15 21:14
 */
@Getter
@Setter
public class Customer {
    /**
    *顾客id
    */
    private Integer id;

    /**
    *公司名称
    */
    private String companyName;

    /**
    *所属销售
    */
    private String saleName;

    /**
     *所属区域
     */
    private Byte area;

    /**
     *规模等级
     */
    private Byte level;

    /**
     *是否签约
     */
    private Byte isSigned;

    /**
     *公司详情
     */
    private String companyDetail;

    /**
     *产品对接方式
     */
    private String buttType;

    /**
     *对接进度
     */
    private Byte buttProgress;

    /**
     *添加时间
     */
    private Date createTime;

    /**
     *更新时间
     */
    private Date updateTime;
}