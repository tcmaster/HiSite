package com.android.tonight8.dao.entity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table DETAIL_PIC.
 */
public class DetailPic {

    private long id;
    private Integer type;
    private Long relateId;
    private String url;
    private String size;
    private String describe;

    public DetailPic() {
    }

    public DetailPic(long id) {
        this.id = id;
    }

    public DetailPic(long id, Integer type, Long relateId, String url, String size, String describe) {
        this.id = id;
        this.type = type;
        this.relateId = relateId;
        this.url = url;
        this.size = size;
        this.describe = describe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getRelateId() {
        return relateId;
    }

    public void setRelateId(Long relateId) {
        this.relateId = relateId;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}