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

import com.android.tonight8.dao.entity.Apply;
import com.android.tonight8.dao.entity.Event;

import com.android.tonight8.dao.entity.Apply;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table APPLY.
*/
public class ApplyDao extends AbstractDao<Apply, Long> {

    public static final String TABLENAME = "APPLY";

    /**
     * Properties of entity Apply.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "ID");
        public final static Property EventId = new Property(1, Long.class, "eventId", false, "EVENT_ID");
        public final static Property ApplyRole = new Property(2, Integer.class, "applyRole", false, "APPLY_ROLE");
        public final static Property Date = new Property(3, String.class, "date", false, "DATE");
        public final static Property Time = new Property(4, String.class, "time", false, "TIME");
        public final static Property ApplyId = new Property(5, Long.class, "applyId", false, "APPLY_ID");
    };

    private DaoSession daoSession;


    public ApplyDao(DaoConfig config) {
        super(config);
    }
    
    public ApplyDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'APPLY' (" + //
                "'ID' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'EVENT_ID' INTEGER," + // 1: eventId
                "'APPLY_ROLE' INTEGER," + // 2: applyRole
                "'DATE' TEXT," + // 3: date
                "'TIME' TEXT," + // 4: time
                "'APPLY_ID' INTEGER);"); // 5: applyId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'APPLY'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Apply entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        Long eventId = entity.getEventId();
        if (eventId != null) {
            stmt.bindLong(2, eventId);
        }
 
        Integer applyRole = entity.getApplyRole();
        if (applyRole != null) {
            stmt.bindLong(3, applyRole);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(4, date);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(5, time);
        }
 
        Long applyId = entity.getApplyId();
        if (applyId != null) {
            stmt.bindLong(6, applyId);
        }
    }

    @Override
    protected void attachEntity(Apply entity) {
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
    public Apply readEntity(Cursor cursor, int offset) {
        Apply entity = new Apply( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // eventId
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // applyRole
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // date
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // time
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5) // applyId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Apply entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setEventId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setApplyRole(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setDate(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setTime(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setApplyId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Apply entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Apply entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getEventDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getApplyDao().getAllColumns());
            builder.append(" FROM APPLY T");
            builder.append(" LEFT JOIN EVENT T0 ON T.'EVENT_ID'=T0.'ID'");
            builder.append(" LEFT JOIN APPLY T1 ON T.'APPLY_ID'=T1.'ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Apply loadCurrentDeep(Cursor cursor, boolean lock) {
        Apply entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Event event = loadCurrentOther(daoSession.getEventDao(), cursor, offset);
        entity.setEvent(event);
        offset += daoSession.getEventDao().getAllColumns().length;

        Apply apply = loadCurrentOther(daoSession.getApplyDao(), cursor, offset);
        entity.setApply(apply);

        return entity;    
    }

    public Apply loadDeep(Long key) {
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
    public List<Apply> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Apply> list = new ArrayList<Apply>(count);
        
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
    
    protected List<Apply> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Apply> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
