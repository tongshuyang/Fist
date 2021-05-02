package cn.litman.fist.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Customer {
    private Integer cId;

    private String companyName;

    private String saleName;

    private Byte area;

    private Byte level;

    private Byte isSigned;

    private String companyDetail;

    private String buttType;

    private Byte buttProgress;

    private Date createTime;

    private Date updateTime;
}