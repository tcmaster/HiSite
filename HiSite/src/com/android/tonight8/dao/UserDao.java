package com.android.tonight8.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import com.android.tonight8.dao.entity.Member;

import com.android.tonight8.dao.entity.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table USER.
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "ID");
        public final static Property MemberId = new Property(1, Long.class, "memberId", false, "MEMBER_ID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Gender = new Property(3, Integer.class, "gender", false, "GENDER");
        public final static Property Age = new Property(4, Integer.class, "age", false, "AGE");
        public final static Property Pic = new Property(5, String.class, "pic", false, "PIC");
        public final static Property MobilePhone = new Property(6, String.class, "mobilePhone", false, "MOBILE_PHONE");
        public final static Property Email = new Property(7, String.class, "email", false, "EMAIL");
        public final static Property CreateTime = new Property(8, String.class, "createTime", false, "CREATE_TIME");
        public final static Property FollowingCount = new Property(9, Integer.class, "followingCount", false, "FOLLOWING_COUNT");
        public final static Property FollowersCount = new Property(10, Integer.class, "followersCount", false, "FOLLOWERS_COUNT");
        public final static Property WishSupportCount = new Property(11, Integer.class, "wishSupportCount", false, "WISH_SUPPORT_COUNT");
    };

    private DaoSession daoSession;


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'USER' (" + //
                "'ID' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'MEMBER_ID' INTEGER," + // 1: memberId
                "'NAME' TEXT," + // 2: name
                "'GENDER' INTEGER," + // 3: gender
                "'AGE' INTEGER," + // 4: age
                "'PIC' TEXT," + // 5: pic
                "'MOBILE_PHONE' TEXT," + // 6: mobilePhone
                "'EMAIL' TEXT," + // 7: email
                "'CREATE_TIME' TEXT," + // 8: createTime
                "'FOLLOWING_COUNT' INTEGER," + // 9: followingCount
                "'FOLLOWERS_COUNT' INTEGER," + // 10: followersCount
                "'WISH_SUPPORT_COUNT' INTEGER);"); // 11: wishSupportCount
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'USER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        Long memberId = entity.getMemberId();
        if (memberId != null) {
            stmt.bindLong(2, memberId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        Integer gender = entity.getGender();
        if (gender != null) {
            stmt.bindLong(4, gender);
        }
 
        Integer age = entity.getAge();
        if (age != null) {
            stmt.bindLong(5, age);
        }
 
        String pic = entity.getPic();
        if (pic != null) {
            stmt.bindString(6, pic);
        }
 
        String mobilePhone = entity.getMobilePhone();
        if (mobilePhone != null) {
            stmt.bindString(7, mobilePhone);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(8, email);
        }
 
        String createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindString(9, createTime);
        }
 
        Integer followingCount = entity.getFollowingCount();
        if (followingCount != null) {
            stmt.bindLong(10, followingCount);
        }
 
        Integer followersCount = entity.getFollowersCount();
        if (followersCount != null) {
            stmt.bindLong(11, followersCount);
        }
 
        Integer wishSupportCount = entity.getWishSupportCount();
        if (wishSupportCount != null) {
            stmt.bindLong(12, wishSupportCount);
        }
    }

    @Override
    protected void attachEntity(User entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // memberId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // gender
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // age
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // pic
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // mobilePhone
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // email
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // createTime
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9), // followingCount
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // followersCount
            cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11) // wishSupportCount
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setMemberId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setGender(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setAge(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setPic(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setMobilePhone(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setEmail(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setCreateTime(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setFollowingCount(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
        entity.setFollowersCount(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setWishSupportCount(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getMemberDao().getAllColumns());
            builder.append(" FROM USER T");
            builder.append(" LEFT JOIN MEMBER T0 ON T.'MEMBER_ID'=T0.'ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected User loadCurrentDeep(Cursor cursor, boolean lock) {
        User entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Member member = loadCurrentOther(daoSession.getMemberDao(), cursor, offset);
        entity.setMember(member);

        return entity;    
    }

    public User loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<User> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<User> list = new ArrayList<User>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<User> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<User> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
