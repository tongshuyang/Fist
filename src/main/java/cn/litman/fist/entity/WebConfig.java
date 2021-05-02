package cn.litman.fist.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 网站配置实体类
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 15:07
 */
@Getter
@Setter
public class WebConfig {

    /**
     * 配置项ID
     */
    private Integer id;

    /**
     * 配置项
     */
    private String key;

    /**
     * 配置项值
     */
    private String value;

    /**
     * 配置说明
     */
    private String remark;

    /**
     * 是否私有 0：公开 1：私有
     */
    private Integer isPrivate;

    /**
     * 修改时间
     */
    private Date updateTime;
}