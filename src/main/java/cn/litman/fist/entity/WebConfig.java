package cn.litman.fist.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 网站配置实体类
 * @author Soyung
 * @email tsyon@qq.com
 * @date 2019/3/23 10:04
 */
@Getter
@Setter
public class WebConfig {
    private Integer id;

    /**
     * 配置项
     */
    private String key;

    /**
     * 配置值
     */
    private String value;

    /**
     * 配置说明
     */
    private String remark;

    /**
     * 修改时间
     */
    private Date updateTime;
}