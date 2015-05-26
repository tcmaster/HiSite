package com.android.tonight8.dao.entity;

import com.android.tonight8.dao.DaoSession;
import de.greenrobot.dao.DaoException;

import com.android.tonight8.dao.MemberDao;
import com.android.tonight8.dao.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table USER.
 */
public class User {

    private long id;
    private Long memberId;
    private String name;
    private Integer gender;
    private Integer age;
    private String pic;
    private String mobilePhone;
    private String email;
    private String createTime;
    private Integer followingCount;
    private Integer followersCount;
    private Integer wishSupportCount;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient UserDao myDao;

    private Member member;
    private Long member__resolvedKey;


    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public User(long id, Long memberId, String name, Integer gender, Integer age, String pic, String mobilePhone, String email, String createTime, Integer followingCount, Integer followersCount, Integer wishSupportCount) {
        this.id = id;
        this.memberId = memberId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.pic = pic;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.createTime = createTime;
        this.followingCount = followingCount;
        this.followersCount = followersCount;
        this.wishSupportCount = wishSupportCount;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getWishSupportCount() {
        return wishSupportCount;
    }

    public void setWishSupportCount(Integer wishSupportCount) {
        this.wishSupportCount = wishSupportCount;
    }

    /** To-one relationship, resolved on first access. */
    public Member getMember() {
        Long __key = this.memberId;
        if (member__resolvedKey == null || !member__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MemberDao targetDao = daoSession.getMemberDao();
            Member memberNew = targetDao.load(__key);
            synchronized (this) {
                member = memberNew;
            	member__resolvedKey = __key;
            }
        }
        return member;
    }

    public void setMember(Member member) {
        synchronized (this) {
            this.member = member;
            memberId = member == null ? null : member.getId();
            member__resolvedKey = memberId;
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