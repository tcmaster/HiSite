package com.android.tonight8.dao.entity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table SOURCE.
 */
public class Source {

    private long id;
    private Integer relateType;
    private Long relateId;
    private Integer publisherRole;
    private Long publisherId;
    private String url;

    public Source() {
    }

    public Source(long id) {
        this.id = id;
    }

    public Source(long id, Integer relateType, Long relateId, Integer publisherRole, Long publisherId, String url) {
        this.id = id;
        this.relateType = relateType;
        this.relateId = relateId;
        this.publisherRole = publisherRole;
        this.publisherId = publisherId;
        this.url = url;
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

    public Integer getPublisherRole() {
        return publisherRole;
    }

    public void setPublisherRole(Integer publisherRole) {
        this.publisherRole = publisherRole;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}