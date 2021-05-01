package cn.litman.fist.entity;

import java.util.Date;

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

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName == null ? null : saleName.trim();
    }

    public Byte getArea() {
        return area;
    }

    public void setArea(Byte area) {
        this.area = area;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getIsSigned() {
        return isSigned;
    }

    public void setIsSigned(Byte isSigned) {
        this.isSigned = isSigned;
    }

    public String getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(String companyDetail) {
        this.companyDetail = companyDetail == null ? null : companyDetail.trim();
    }

    public String getButtType() {
        return buttType;
    }

    public void setButtType(String buttType) {
        this.buttType = buttType == null ? null : buttType.trim();
    }

    public Byte getButtProgress() {
        return buttProgress;
    }

    public void setButtProgress(Byte buttProgress) {
        this.buttProgress = buttProgress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}