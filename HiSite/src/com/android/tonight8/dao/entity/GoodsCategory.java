package com.android.tonight8.dao.entity;

import com.android.tonight8.dao.DaoSession;
import de.greenrobot.dao.DaoException;

import com.android.tonight8.dao.GoodsCategoryDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table GOODS_CATEGORY.
 */
public class GoodsCategory {

    private long id;
    private Long pid;
    private String name;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient GoodsCategoryDao myDao;

    private GoodsCategory goodsCategory;
    private Long goodsCategory__resolvedKey;


    public GoodsCategory() {
    }

    public GoodsCategory(long id) {
        this.id = id;
    }

    public GoodsCategory(long id, Long pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGoodsCategoryDao() : null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** To-one relationship, resolved on first access. */
    public GoodsCategory getGoodsCategory() {
        Long __key = this.pid;
        if (goodsCategory__resolvedKey == null || !goodsCategory__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            GoodsCategoryDao targetDao = daoSession.getGoodsCategoryDao();
            GoodsCategory goodsCategoryNew = targetDao.load(__key);
            synchronized (this) {
                goodsCategory = goodsCategoryNew;
            	goodsCategory__resolvedKey = __key;
            }
        }
        return goodsCategory;
    }

    public void setGoodsCategory(GoodsCategory goodsCategory) {
        synchronized (this) {
            this.goodsCategory = goodsCategory;
            pid = goodsCategory == null ? null : goodsCategory.getId();
            goodsCategory__resolvedKey = pid;
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