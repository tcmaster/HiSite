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

import com.android.tonight8.dao.entity.Org;

import com.android.tonight8.dao.entity.Event;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table EVENT.
*/
public class EventDao extends AbstractDao<Event, Long> {

    public static final String TABLENAME = "EVENT";

    /**
     * Properties of entity Event.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "ID");
        public final static Property Rid = new Property(1, Long.class, "rid", false, "RID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Status = new Property(3, Integer.class, "status", false, "STATUS");
        public final static Property Distance = new Property(4, Integer.class, "distance", false, "DISTANCE");
        public final static Property TimeRangeStart = new Property(5, String.class, "timeRangeStart", false, "TIME_RANGE_START");
        public final static Property TimeRangeEnd = new Property(6, String.class, "timeRangeEnd", false, "TIME_RANGE_END");
        public final static Property TimeStamp = new Property(7, Integer.class, "timeStamp", false, "TIME_STAMP");
        public final static Property PublishTime = new Property(8, String.class, "publishTime", false, "PUBLISH_TIME");
        public final static Property RuleDesc = new Property(9, String.class, "ruleDesc", false, "RULE_DESC");
        public final static Property WinningStatus = new Property(10, Integer.class, "winningStatus", false, "WINNING_STATUS");
        public final static Property WinningLimit = new Property(11, Integer.class, "winningLimit", false, "WINNING_LIMIT");
        public final static Property GoodsCount = new Property(12, Integer.class, "goodsCount", false, "GOODS_COUNT");
        public final static Property ApplyCount = new Property(13, Integer.class, "applyCount", false, "APPLY_COUNT");
        public final static Property ConsultCount = new Property(14, Integer.class, "consultCount", false, "CONSULT_COUNT");
        public final static Property SubjectCount = new Property(15, Integer.class, "subjectCount", false, "SUBJECT_COUNT");
        public final static Property SignInCount = new Property(16, Integer.class, "signInCount", false, "SIGN_IN_COUNT");
        public final static Property CityAll = new Property(17, Integer.class, "cityAll", false, "CITY_ALL");
        public final static Property AwardCount = new Property(18, Integer.class, "awardCount", false, "AWARD_COUNT");
        public final static Property IsCouponNoneAward = new Property(19, Integer.class, "isCouponNoneAward", false, "IS_COUPON_NONE_AWARD");
    };

    private DaoSession daoSession;


    public EventDao(DaoConfig config) {
        super(config);
    }
    
    public EventDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'EVENT' (" + //
                "'ID' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'RID' INTEGER," + // 1: rid
                "'NAME' TEXT," + // 2: name
                "'STATUS' INTEGER," + // 3: status
                "'DISTANCE' INTEGER," + // 4: distance
                "'TIME_RANGE_START' TEXT," + // 5: timeRangeStart
                "'TIME_RANGE_END' TEXT," + // 6: timeRangeEnd
                "'TIME_STAMP' INTEGER," + // 7: timeStamp
                "'PUBLISH_TIME' TEXT," + // 8: publishTime
                "'RULE_DESC' TEXT," + // 9: ruleDesc
                "'WINNING_STATUS' INTEGER," + // 10: winningStatus
                "'WINNING_LIMIT' INTEGER," + // 11: winningLimit
                "'GOODS_COUNT' INTEGER," + // 12: goodsCount
                "'APPLY_COUNT' INTEGER," + // 13: applyCount
                "'CONSULT_COUNT' INTEGER," + // 14: consultCount
                "'SUBJECT_COUNT' INTEGER," + // 15: subjectCount
                "'SIGN_IN_COUNT' INTEGER," + // 16: signInCount
                "'CITY_ALL' INTEGER," + // 17: cityAll
                "'AWARD_COUNT' INTEGER," + // 18: awardCount
                "'IS_COUPON_NONE_AWARD' INTEGER);"); // 19: isCouponNoneAward
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'EVENT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Event entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        Long rid = entity.getRid();
        if (rid != null) {
            stmt.bindLong(2, rid);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(4, status);
        }
 
        Integer distance = entity.getDistance();
        if (distance != null) {
            stmt.bindLong(5, distance);
        }
 
        String timeRangeStart = entity.getTimeRangeStart();
        if (timeRangeStart != null) {
            stmt.bindString(6, timeRangeStart);
        }
 
        String timeRangeEnd = entity.getTimeRangeEnd();
        if (timeRangeEnd != null) {
            stmt.bindString(7, timeRangeEnd);
        }
 
        Integer timeStamp = entity.getTimeStamp();
        if (timeStamp != null) {
            stmt.bindLong(8, timeStamp);
        }
 
        String publishTime = entity.getPublishTime();
        if (publishTime != null) {
            stmt.bindString(9, publishTime);
        }
 
        String ruleDesc = entity.getRuleDesc();
        if (ruleDesc != null) {
            stmt.bindString(10, ruleDesc);
        }
 
        Integer winningStatus = entity.getWinningStatus();
        if (winningStatus != null) {
            stmt.bindLong(11, winningStatus);
        }
 
        Integer winningLimit = entity.getWinningLimit();
        if (winningLimit != null) {
            stmt.bindLong(12, winningLimit);
        }
 
        Integer goodsCount = entity.getGoodsCount();
        if (goodsCount != null) {
            stmt.bindLong(13, goodsCount);
        }
 
        Integer applyCount = entity.getApplyCount();
        if (applyCount != null) {
            stmt.bindLong(14, applyCount);
        }
 
        Integer consultCount = entity.getConsultCount();
        if (consultCount != null) {
            stmt.bindLong(15, consultCount);
        }
 
        Integer subjectCount = entity.getSubjectCount();
        if (subjectCount != null) {
            stmt.bindLong(16, subjectCount);
        }
 
        Integer signInCount = entity.getSignInCount();
        if (signInCount != null) {
            stmt.bindLong(17, signInCount);
        }
 
        Integer cityAll = entity.getCityAll();
        if (cityAll != null) {
            stmt.bindLong(18, cityAll);
        }
 
        Integer awardCount = entity.getAwardCount();
        if (awardCount != null) {
            stmt.bindLong(19, awardCount);
        }
 
        Integer isCouponNoneAward = entity.getIsCouponNoneAward();
        if (isCouponNoneAward != null) {
            stmt.bindLong(20, isCouponNoneAward);
        }
    }

    @Override
    protected void attachEntity(Event entity) {
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
    public Event readEntity(Cursor cursor, int offset) {
        Event entity = new Event( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // rid
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // status
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // distance
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // timeRangeStart
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // timeRangeEnd
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // timeStamp
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // publishTime
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // ruleDesc
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // winningStatus
            cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11), // winningLimit
            cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12), // goodsCount
            cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13), // applyCount
            cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14), // consultCount
            cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15), // subjectCount
            cursor.isNull(offset + 16) ? null : cursor.getInt(offset + 16), // signInCount
            cursor.isNull(offset + 17) ? null : cursor.getInt(offset + 17), // cityAll
            cursor.isNull(offset + 18) ? null : cursor.getInt(offset + 18), // awardCount
            cursor.isNull(offset + 19) ? null : cursor.getInt(offset + 19) // isCouponNoneAward
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Event entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setRid(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setStatus(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setDistance(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setTimeRangeStart(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setTimeRangeEnd(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setTimeStamp(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setPublishTime(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setRuleDesc(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setWinningStatus(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setWinningLimit(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
        entity.setGoodsCount(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
        entity.setApplyCount(cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13));
        entity.setConsultCount(cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14));
        entity.setSubjectCount(cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15));
        entity.setSignInCount(cursor.isNull(offset + 16) ? null : cursor.getInt(offset + 16));
        entity.setCityAll(cursor.isNull(offset + 17) ? null : cursor.getInt(offset + 17));
        entity.setAwardCount(cursor.isNull(offset + 18) ? null : cursor.getInt(offset + 18));
        entity.setIsCouponNoneAward(cursor.isNull(offset + 19) ? null : cursor.getInt(offset + 19));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Event entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Event entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getOrgDao().getAllColumns());
            builder.append(" FROM EVENT T");
            builder.append(" LEFT JOIN ORG T0 ON T.'RID'=T0.'ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Event loadCurrentDeep(Cursor cursor, boolean lock) {
        Event entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Org org = loadCurrentOther(daoSession.getOrgDao(), cursor, offset);
        entity.setOrg(org);

        return entity;    
    }

    public Event loadDeep(Long key) {
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
    public List<Event> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Event> list = new ArrayList<Event>(count);
        
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
    
    protected List<Event> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Event> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
