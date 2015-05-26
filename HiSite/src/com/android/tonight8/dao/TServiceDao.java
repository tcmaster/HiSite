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

import com.android.tonight8.dao.entity.Order;

import com.android.tonight8.dao.entity.TService;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table TSERVICE.
*/
public class TServiceDao extends AbstractDao<TService, Long> {

    public static final String TABLENAME = "TSERVICE";

    /**
     * Properties of entity TService.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "ID");
        public final static Property OrderId = new Property(1, Long.class, "orderId", false, "ORDER_ID");
        public final static Property Type = new Property(2, Integer.class, "type", false, "TYPE");
        public final static Property Content = new Property(3, String.class, "content", false, "CONTENT");
    };

    private DaoSession daoSession;


    public TServiceDao(DaoConfig config) {
        super(config);
    }
    
    public TServiceDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'TSERVICE' (" + //
                "'ID' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'ORDER_ID' INTEGER," + // 1: orderId
                "'TYPE' INTEGER," + // 2: type
                "'CONTENT' TEXT);"); // 3: content
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TSERVICE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, TService entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        Long orderId = entity.getOrderId();
        if (orderId != null) {
            stmt.bindLong(2, orderId);
        }
 
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(3, type);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
    }

    @Override
    protected void attachEntity(TService entity) {
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
    public TService readEntity(Cursor cursor, int offset) {
        TService entity = new TService( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // orderId
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // type
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // content
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, TService entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setOrderId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setType(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setContent(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(TService entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(TService entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getOrderDao().getAllColumns());
            builder.append(" FROM TSERVICE T");
            builder.append(" LEFT JOIN ORDER T0 ON T.'ORDER_ID'=T0.'ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected TService loadCurrentDeep(Cursor cursor, boolean lock) {
        TService entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Order order = loadCurrentOther(daoSession.getOrderDao(), cursor, offset);
        entity.setOrder(order);

        return entity;    
    }

    public TService loadDeep(Long key) {
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
    public List<TService> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<TService> list = new ArrayList<TService>(count);
        
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
    
    protected List<TService> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<TService> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
