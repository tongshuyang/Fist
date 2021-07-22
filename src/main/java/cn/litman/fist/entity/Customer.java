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
    *客户ID
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
     *所属区域 0：未分类 1：华东 2：华南 3：华北
     */
    private Byte area;

    /**
     *客户等级 0：小体量 1：中等 2：重要 3：非常重要
     */
    private Byte level;

    /**
     *已签约 ？0：未签约 1：已签约 2：待续签 3：待回款 4：未续签
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
     *对接进度 0:了解产品 1：首次对接中 2：对接完成 3：升级版本
     */
    private Byte buttProgress;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *更新时间
     */
    private Date updateTime;
}