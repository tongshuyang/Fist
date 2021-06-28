package cn.litman.fist.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Case {
    /**
     *案例id
     */
    private Integer id;

    /**
    *用户id
    */
    private Integer uId;

    /**
     *客户id
     */
    private Integer cId;

    /**
     *禅道id
     */
    private Integer storyId;

    /**
     *标题
     */
    private String title;

    /**
     *案例描述
     */
    private String description;

    /**
     *关键错误代码
     */
    private String errorCode;

    /**
     *问题分类：0 :未分类  1：API 2：Android 3：iOS 4：JSSDK 5：小程序 6：使用问题
     */
    private Byte category;

    /**
     *状态：0 :活动  1：关闭
     */
    private Byte status;

    /**
     *产品类型：0 :未分类  1：大班课-直播 2：大班课-回放： 3：小班课-直播 4：小班课-回放 5：点播
     */
    private Byte productType;

    /**
     *跟进信息记录
     */
    private String followInfo;

    /**
     *解决方式总结
     */
    private String solution;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *更新时间
     */
    private Date updateTime;

}