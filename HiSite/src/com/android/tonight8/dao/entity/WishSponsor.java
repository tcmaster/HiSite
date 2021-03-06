package com.android.tonight8.dao.entity;

import com.android.tonight8.dao.DaoSession;
import de.greenrobot.dao.DaoException;

import com.android.tonight8.dao.WishDao;
import com.android.tonight8.dao.WishItemDao;
import com.android.tonight8.dao.WishSponsorDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table WISH_SPONSOR.
 */
public class WishSponsor {

    private long id;
    private Long wishId;
    private Long wishItemId;
    private Integer type;
    private Integer sponsorId;
    private String describe;
    private String replyDescribe;
    private Integer status;
    private String sponsorDate;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient WishSponsorDao myDao;

    private Wish wish;
    private Long wish__resolvedKey;

    private WishItem wishItem;
    private Long wishItem__resolvedKey;


    public WishSponsor() {
    }

    public WishSponsor(long id) {
        this.id = id;
    }

    public WishSponsor(long id, Long wishId, Long wishItemId, Integer type, Integer sponsorId, String describe, String replyDescribe, Integer status, String sponsorDate) {
        this.id = id;
        this.wishId = wishId;
        this.wishItemId = wishItemId;
        this.type = type;
        this.sponsorId = sponsorId;
        this.describe = describe;
        this.replyDescribe = replyDescribe;
        this.status = status;
        this.sponsorDate = sponsorDate;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getWishSponsorDao() : null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getWishId() {
        return wishId;
    }

    public void setWishId(Long wishId) {
        this.wishId = wishId;
    }

    public Long getWishItemId() {
        return wishItemId;
    }

    public void setWishItemId(Long wishItemId) {
        this.wishItemId = wishItemId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(Integer sponsorId) {
        this.sponsorId = sponsorId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getReplyDescribe() {
        return replyDescribe;
    }

    public void setReplyDescribe(String replyDescribe) {
        this.replyDescribe = replyDescribe;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSponsorDate() {
        return sponsorDate;
    }

    public void setSponsorDate(String sponsorDate) {
        this.sponsorDate = sponsorDate;
    }

    /** To-one relationship, resolved on first access. */
    public Wish getWish() {
        Long __key = this.wishId;
        if (wish__resolvedKey == null || !wish__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WishDao targetDao = daoSession.getWishDao();
            Wish wishNew = targetDao.load(__key);
            synchronized (this) {
                wish = wishNew;
            	wish__resolvedKey = __key;
            }
        }
        return wish;
    }

    public void setWish(Wish wish) {
        synchronized (this) {
            this.wish = wish;
            wishId = wish == null ? null : wish.getId();
            wish__resolvedKey = wishId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public WishItem getWishItem() {
        Long __key = this.wishItemId;
        if (wishItem__resolvedKey == null || !wishItem__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WishItemDao targetDao = daoSession.getWishItemDao();
            WishItem wishItemNew = targetDao.load(__key);
            synchronized (this) {
                wishItem = wishItemNew;
            	wishItem__resolvedKey = __key;
            }
        }
        return wishItem;
    }

    public void setWishItem(WishItem wishItem) {
        synchronized (this) {
            this.wishItem = wishItem;
            wishItemId = wishItem == null ? null : wishItem.getId();
            wishItem__resolvedKey = wishItemId;
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
