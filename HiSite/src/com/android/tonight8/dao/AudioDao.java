package com.android.tonight8.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.android.tonight8.dao.entity.Audio;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table AUDIO.
*/
public class AudioDao extends AbstractDao<Audio, Long> {

    public static final String TABLENAME = "AUDIO";

    /**
     * Properties of entity Audio.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "ID");
        public final static Property RelateType = new Property(1, Integer.class, "relateType", false, "RELATE_TYPE");
        public final static Property RelateId = new Property(2, Long.class, "relateId", false, "RELATE_ID");
        public final static Property PublisherRole = new Property(3, Integer.class, "publisherRole", false, "PUBLISHER_ROLE");
        public final static Property PublisherId = new Property(4, Long.class, "publisherId", false, "PUBLISHER_ID");
        public final static Property Url = new Property(5, String.class, "url", false, "URL");
    };


    public AudioDao(DaoConfig config) {
        super(config);
    }
    
    public AudioDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'AUDIO' (" + //
                "'ID' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'RELATE_TYPE' INTEGER," + // 1: relateType
                "'RELATE_ID' INTEGER," + // 2: relateId
                "'PUBLISHER_ROLE' INTEGER," + // 3: publisherRole
                "'PUBLISHER_ID' INTEGER," + // 4: publisherId
                "'URL' TEXT);"); // 5: url
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'AUDIO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Audio entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        Integer relateType = entity.getRelateType();
        if (relateType != null) {
            stmt.bindLong(2, relateType);
        }
 
        Long relateId = entity.getRelateId();
        if (relateId != null) {
            stmt.bindLong(3, relateId);
        }
 
        Integer publisherRole = entity.getPublisherRole();
        if (publisherRole != null) {
            stmt.bindLong(4, publisherRole);
        }
 
        Long publisherId = entity.getPublisherId();
        if (publisherId != null) {
            stmt.bindLong(5, publisherId);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(6, url);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Audio readEntity(Cursor cursor, int offset) {
        Audio entity = new Audio( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // relateType
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // relateId
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // publisherRole
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // publisherId
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // url
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Audio entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setRelateType(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setRelateId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setPublisherRole(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setPublisherId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setUrl(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Audio entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Audio entity) {
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