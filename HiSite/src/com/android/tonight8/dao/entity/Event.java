package com.android.tonight8.dao.entity;

import com.android.tonight8.dao.DaoSession;
import de.greenrobot.dao.DaoException;

import com.android.tonight8.dao.EventDao;
import com.android.tonight8.dao.OrgDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table EVENT.
 */
public class Event {

    private long id;
    private Long rid;
    private String name;
    private Integer status;
    private Integer distance;
    private String timeRangeStart;
    private String timeRangeEnd;
    private Integer timeStamp;
    private String publishTime;
    private String ruleDesc;
    private Integer winningStatus;
    private Integer winningLimit;
    private Integer goodsCount;
    private Integer applyCount;
    private Integer consultCount;
    private Integer subjectCount;
    private Integer signInCount;
    private Integer cityAll;
    private Integer awardCount;
    private Integer isCouponNoneAward;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient EventDao myDao;

    private Org org;
    private Long org__resolvedKey;


    public Event() {
    }

    public Event(long id) {
        this.id = id;
    }

    public Event(long id, Long rid, String name, Integer status, Integer distance, String timeRangeStart, String timeRangeEnd, Integer timeStamp, String publishTime, String ruleDesc, Integer winningStatus, Integer winningLimit, Integer goodsCount, Integer applyCount, Integer consultCount, Integer subjectCount, Integer signInCount, Integer cityAll, Integer awardCount, Integer isCouponNoneAward) {
        this.id = id;
        this.rid = rid;
        this.name = name;
        this.status = status;
        this.distance = distance;
        this.timeRangeStart = timeRangeStart;
        this.timeRangeEnd = timeRangeEnd;
        this.timeStamp = timeStamp;
        this.publishTime = publishTime;
        this.ruleDesc = ruleDesc;
        this.winningStatus = winningStatus;
        this.winningLimit = winningLimit;
        this.goodsCount = goodsCount;
        this.applyCount = applyCount;
        this.consultCount = consultCount;
        this.subjectCount = subjectCount;
        this.signInCount = signInCount;
        this.cityAll = cityAll;
        this.awardCount = awardCount;
        this.isCouponNoneAward = isCouponNoneAward;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEventDao() : null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getTimeRangeStart() {
        return timeRangeStart;
    }

    public void setTimeRangeStart(String timeRangeStart) {
        this.timeRangeStart = timeRangeStart;
    }

    public String getTimeRangeEnd() {
        return timeRangeEnd;
    }

    public void setTimeRangeEnd(String timeRangeEnd) {
        this.timeRangeEnd = timeRangeEnd;
    }

    public Integer getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public Integer getWinningStatus() {
        return winningStatus;
    }

    public void setWinningStatus(Integer winningStatus) {
        this.winningStatus = winningStatus;
    }

    public Integer getWinningLimit() {
        return winningLimit;
    }

    public void setWinningLimit(Integer winningLimit) {
        this.winningLimit = winningLimit;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public Integer getConsultCount() {
        return consultCount;
    }

    public void setConsultCount(Integer consultCount) {
        this.consultCount = consultCount;
    }

    public Integer getSubjectCount() {
        return subjectCount;
    }

    public void setSubjectCount(Integer subjectCount) {
        this.subjectCount = subjectCount;
    }

    public Integer getSignInCount() {
        return signInCount;
    }

    public void setSignInCount(Integer signInCount) {
        this.signInCount = signInCount;
    }

    public Integer getCityAll() {
        return cityAll;
    }

    public void setCityAll(Integer cityAll) {
        this.cityAll = cityAll;
    }

    public Integer getAwardCount() {
        return awardCount;
    }

    public void setAwardCount(Integer awardCount) {
        this.awardCount = awardCount;
    }

    public Integer getIsCouponNoneAward() {
        return isCouponNoneAward;
    }

    public void setIsCouponNoneAward(Integer isCouponNoneAward) {
        this.isCouponNoneAward = isCouponNoneAward;
    }

    /** To-one relationship, resolved on first access. */
    public Org getOrg() {
        Long __key = this.rid;
        if (org__resolvedKey == null || !org__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OrgDao targetDao = daoSession.getOrgDao();
            Org orgNew = targetDao.load(__key);
            synchronized (this) {
                org = orgNew;
            	org__resolvedKey = __key;
            }
        }
        return org;
    }

    public void setOrg(Org org) {
        synchronized (this) {
            this.org = org;
            rid = org == null ? null : org.getId();
            org__resolvedKey = rid;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
