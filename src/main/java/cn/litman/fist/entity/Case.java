package cn.litman.fist.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Case {
    private Integer caseId;

    private Integer uId;

    private Integer cId;

    private Integer storyId;

    private String title;

    private String description;

    private String errorCode;

    private Byte category;

    private Byte status;

    private Byte productType;

    private String followInfo;

    private String solution;

    private Date createTime;

    private Date updateTime;

}