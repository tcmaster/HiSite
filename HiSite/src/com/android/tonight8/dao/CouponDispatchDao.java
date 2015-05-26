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

import com.android.tonight8.dao.entity.CouponProvide;
import com.android.tonight8.dao.entity.Subject;

import com.android.tonight8.dao.entity.CouponDispatch;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table COUPON_DISPATCH.
*/
public class CouponDispatchDao extends AbstractDao<CouponDispatch, Long> {

    public static final String TABLENAME = "COUPON_DISPATCH";

    /**
     * Properties of entity CouponDispatch.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "ID");
        public final static Property CouponProvideId = new Property(1, Long.class, "couponProvideId", false, "COUPON_PROVIDE_ID");
        public final static Property SubjectId = new Property(2, Long.class, "subjectId", false, "SUBJECT_ID");
    };

    private DaoSession daoSession;


    public CouponDispatchDao(DaoConfig config) {
        super(config);
    }
    
    public CouponDispatchDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'COUPON_DISPATCH' (" + //
                "'ID' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'COUPON_PROVIDE_ID' INTEGER," + // 1: couponProvideId
                "'SUBJECT_ID' INTEGER);"); // 2: subjectId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'COUPON_DISPATCH'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, CouponDispatch entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        Long couponProvideId = entity.getCouponProvideId();
        if (couponProvideId != null) {
            stmt.bindLong(2, couponProvideId);
        }
 
        Long subjectId = entity.getSubjectId();
        if (subjectId != null) {
            stmt.bindLong(3, subjectId);
        }
    }

    @Override
    protected void attachEntity(CouponDispatch entity) {
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
    public CouponDispatch readEntity(Cursor cursor, int offset) {
        CouponDispatch entity = new CouponDispatch( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // couponProvideId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // subjectId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, CouponDispatch entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setCouponProvideId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setSubjectId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(CouponDispatch entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(CouponDispatch entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getCouponProvideDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getSubjectDao().getAllColumns());
            builder.append(" FROM COUPON_DISPATCH T");
            builder.append(" LEFT JOIN COUPON_PROVIDE T0 ON T.'COUPON_PROVIDE_ID'=T0.'ID'");
            builder.append(" LEFT JOIN SUBJECT T1 ON T.'SUBJECT_ID'=T1.'ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected CouponDispatch loadCurrentDeep(Cursor cursor, boolean lock) {
        CouponDispatch entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        CouponProvide couponProvide = loadCurrentOther(daoSession.getCouponProvideDao(), cursor, offset);
        entity.setCouponProvide(couponProvide);
        offset += daoSession.getCouponProvideDao().getAllColumns().length;

        Subject subject = loadCurrentOther(daoSession.getSubjectDao(), cursor, offset);
        entity.setSubject(subject);

        return entity;    
    }

    public CouponDispatch loadDeep(Long key) {
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
    public List<CouponDispatch> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<CouponDispatch> list = new ArrayList<CouponDispatch>(count);
        
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
    
    protected List<CouponDispatch> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<CouponDispatch> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
