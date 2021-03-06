package com.android.tonight8.dao.entity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table PPTFRAME.
 */
public class PPTFrame {

    private long id;
    private Integer relateType;
    private Long relateId;
    private Integer frameNumber;
    private Integer secondNumber;
    private String content;

    public PPTFrame() {
    }

    public PPTFrame(long id) {
        this.id = id;
    }

    public PPTFrame(long id, Integer relateType, Long relateId, Integer frameNumber, Integer secondNumber, String content) {
        this.id = id;
        this.relateType = relateType;
        this.relateId = relateId;
        this.frameNumber = frameNumber;
        this.secondNumber = secondNumber;
        this.content = content;
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

    public Integer getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(Integer frameNumber) {
        this.frameNumber = frameNumber;
    }

    public Integer getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Integer secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
