package com.android.tonight8.dao.entity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table TRANSLATE.
 */
public class Translate {

    private long id;
    private Integer type;
    private String code;
    private Integer roleType;
    private Integer byId;
    private Integer toId;
    private Integer status;
    private String date;
    private String time;

    public Translate() {
    }

    public Translate(long id) {
        this.id = id;
    }

    public Translate(long id, Integer type, String code, Integer roleType, Integer byId, Integer toId, Integer status, String date, String time) {
        this.id = id;
        this.type = type;
        this.code = code;
        this.roleType = roleType;
        this.byId = byId;
        this.toId = toId;
        this.status = status;
        this.date = date;
        this.time = time;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Integer getById() {
        return byId;
    }

    public void setById(Integer byId) {
        this.byId = byId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
