package com.android.tonight8.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.android.tonight8.dao.entity.Translate;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table TRANSLATE.
*/
public class TranslateDao extends AbstractDao<Translate, Long> {

    public static final String TABLENAME = "TRANSLATE";

    /**
     * Properties of entity Translate.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "ID");
        public final static Property Type = new Property(1, Integer.class, "type", false, "TYPE");
        public final static Property Code = new Property(2, String.class, "code", false, "CODE");
        public final static Property RoleType = new Property(3, Integer.class, "roleType", false, "ROLE_TYPE");
        public final static Property ById = new Property(4, Integer.class, "byId", false, "BY_ID");
        public final static Property ToId = new Property(5, Integer.class, "toId", false, "TO_ID");
        public final static Property Status = new Property(6, Integer.class, "status", false, "STATUS");
        public final static Property Date = new Property(7, String.class, "date", false, "DATE");
        public final static Property Time = new Property(8, String.class, "time", false, "TIME");
    };


    public TranslateDao(DaoConfig config) {
        super(config);
    }
    
    public TranslateDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'TRANSLATE' (" + //
                "'ID' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'TYPE' INTEGER," + // 1: type
                "'CODE' TEXT," + // 2: code
                "'ROLE_TYPE' INTEGER," + // 3: roleType
                "'BY_ID' INTEGER," + // 4: byId
                "'TO_ID' INTEGER," + // 5: toId
                "'STATUS' INTEGER," + // 6: status
                "'DATE' TEXT," + // 7: date
                "'TIME' TEXT);"); // 8: time
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TRANSLATE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Translate entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(2, type);
        }
 
        String code = entity.getCode();
        if (code != null) {
            stmt.bindString(3, code);
        }
 
        Integer roleType = entity.getRoleType();
        if (roleType != null) {
            stmt.bindLong(4, roleType);
        }
 
        Integer byId = entity.getById();
        if (byId != null) {
            stmt.bindLong(5, byId);
        }
 
        Integer toId = entity.getToId();
        if (toId != null) {
            stmt.bindLong(6, toId);
        }
 
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(7, status);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(8, date);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(9, time);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Translate readEntity(Cursor cursor, int offset) {
        Translate entity = new Translate( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // type
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // code
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // roleType
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // byId
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // toId
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // status
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // date
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // time
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Translate entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setType(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setCode(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setRoleType(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setById(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setToId(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setStatus(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setDate(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setTime(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Translate entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Translate entity) {
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
    
}