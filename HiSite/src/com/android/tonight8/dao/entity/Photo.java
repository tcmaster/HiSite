package com.android.tonight8.dao.entity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table PHOTO.
 */
public class Photo {

    private long id;
    private Integer relateType;
    private Long relateId;
    private Integer publisherRole;
    private Long publisherId;
    private String url;
    private String size;

    public Photo() {
    }

    public Photo(long id) {
        this.id = id;
    }

    public Photo(long id, Integer relateType, Long relateId, Integer publisherRole, Long publisherId, String url, String size) {
        this.id = id;
        this.relateType = relateType;
        this.relateId = relateId;
        this.publisherRole = publisherRole;
        this.publisherId = publisherId;
        this.url = url;
        this.size = size;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
