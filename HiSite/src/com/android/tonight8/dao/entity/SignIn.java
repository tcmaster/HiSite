package com.android.tonight8.dao.entity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table SIGN_IN.
 */
public class SignIn {

    private long id;
    private Integer relateType;
    private Long relateId;
    private String content;
    private Integer serviceMark;
    private String time;

    public SignIn() {
    }

    public SignIn(long id) {
        this.id = id;
    }

    public SignIn(long id, Integer relateType, Long relateId, String content, Integer serviceMark, String time) {
        this.id = id;
        this.relateType = relateType;
        this.relateId = relateId;
        this.content = content;
        this.serviceMark = serviceMark;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getRelateType() {
        return relateType;
    }

    public void setRelateType(Integer relateType) {
        this.relateType = relateType;
    }

    public Long getRelateId() {
        return relateId;
    }

    public void setRelateId(Long relateId) {
        this.relateId = relateId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getServiceMark() {
        return serviceMark;
    }

    public void setServiceMark(Integer serviceMark) {
        this.serviceMark = serviceMark;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}