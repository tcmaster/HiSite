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

import com.android.tonight8.dao.entity.GoodsCategory;
import com.android.tonight8.dao.entity.GoodsSpecification;

import com.android.tonight8.dao.entity.GoodsSpecification;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table GOODS_SPECIFICATION.
*/
public class GoodsSpecificationDao extends AbstractDao<GoodsSpecification, Long> {

    public static final String TABLENAME = "GOODS_SPECIFICATION";

    /**
     * Properties of entity GoodsSpecification.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "ID");
        public final static Property Pid = new Property(1, Long.class, "pid", false, "PID");
        public final static Property GoodsCategoryId = new Property(2, Long.class, "goodsCategoryId", false, "GOODS_CATEGORY_ID");
        public final static Property Name = new Property(3, String.class, "name", false, "NAME");
    };

    private DaoSession daoSession;


    public GoodsSpecificationDao(DaoConfig config) {
        super(config);
    }
    
    public GoodsSpecificationDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'GOODS_SPECIFICATION' (" + //
                "'ID' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'PID' INTEGER," + // 1: pid
                "'GOODS_CATEGORY_ID' INTEGER," + // 2: goodsCategoryId
                "'NAME' TEXT);"); // 3: name
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'GOODS_SPECIFICATION'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, GoodsSpecification entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        Long pid = entity.getPid();
        if (pid != null) {
            stmt.bindLong(2, pid);
        }
 
        Long goodsCategoryId = entity.getGoodsCategoryId();
        if (goodsCategoryId != null) {
            stmt.bindLong(3, goodsCategoryId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
    }

    @Override
    protected void attachEntity(GoodsSpecification entity) {
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
    public GoodsSpecification readEntity(Cursor cursor, int offset) {
        GoodsSpecification entity = new GoodsSpecification( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // pid
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // goodsCategoryId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // name
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, GoodsSpecification entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setPid(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setGoodsCategoryId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(GoodsSpecification entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(GoodsSpecification entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getGoodsSpecificationDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getGoodsCategoryDao().getAllColumns());
            builder.append(" FROM GOODS_SPECIFICATION T");
            builder.append(" LEFT JOIN GOODS_SPECIFICATION T0 ON T.'PID'=T0.'ID'");
            builder.append(" LEFT JOIN GOODS_CATEGORY T1 ON T.'GOODS_CATEGORY_ID'=T1.'ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected GoodsSpecification loadCurrentDeep(Cursor cursor, boolean lock) {
        GoodsSpecification entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        GoodsSpecification goodsSpecification = loadCurrentOther(daoSession.getGoodsSpecificationDao(), cursor, offset);
        entity.setGoodsSpecification(goodsSpecification);
        offset += daoSession.getGoodsSpecificationDao().getAllColumns().length;

        GoodsCategory goodsCategory = loadCurrentOther(daoSession.getGoodsCategoryDao(), cursor, offset);
        entity.setGoodsCategory(goodsCategory);

        return entity;    
    }

    public GoodsSpecification loadDeep(Long key) {
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
    public List<GoodsSpecification> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<GoodsSpecification> list = new ArrayList<GoodsSpecification>(count);
        
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
    
    protected List<GoodsSpecification> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<GoodsSpecification> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}