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

import com.android.tonight8.dao.entity.Vote;

import com.android.tonight8.dao.entity.VoteItem;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table VOTE_ITEM.
*/
public class VoteItemDao extends AbstractDao<VoteItem, Long> {

    public static final String TABLENAME = "VOTE_ITEM";

    /**
     * Properties of entity VoteItem.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "ID");
        public final static Property VoteId = new Property(1, Long.class, "VoteId", false, "VOTE_ID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property VoteCount = new Property(3, Integer.class, "voteCount", false, "VOTE_COUNT");
    };

    private DaoSession daoSession;


    public VoteItemDao(DaoConfig config) {
        super(config);
    }
    
    public VoteItemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'VOTE_ITEM' (" + //
                "'ID' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'VOTE_ID' INTEGER," + // 1: VoteId
                "'NAME' TEXT," + // 2: name
                "'VOTE_COUNT' INTEGER);"); // 3: voteCount
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'VOTE_ITEM'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, VoteItem entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        Long VoteId = entity.getVoteId();
        if (VoteId != null) {
            stmt.bindLong(2, VoteId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        Integer voteCount = entity.getVoteCount();
        if (voteCount != null) {
            stmt.bindLong(4, voteCount);
        }
    }

    @Override
    protected void attachEntity(VoteItem entity) {
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
    public VoteItem readEntity(Cursor cursor, int offset) {
        VoteItem entity = new VoteItem( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // VoteId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3) // voteCount
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, VoteItem entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setVoteId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setVoteCount(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(VoteItem entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(VoteItem entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getVoteDao().getAllColumns());
            builder.append(" FROM VOTE_ITEM T");
            builder.append(" LEFT JOIN VOTE T0 ON T.'VOTE_ID'=T0.'ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected VoteItem loadCurrentDeep(Cursor cursor, boolean lock) {
        VoteItem entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Vote vote = loadCurrentOther(daoSession.getVoteDao(), cursor, offset);
        entity.setVote(vote);

        return entity;    
    }

    public VoteItem loadDeep(Long key) {
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
    public List<VoteItem> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<VoteItem> list = new ArrayList<VoteItem>(count);
        
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
    
    protected List<VoteItem> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<VoteItem> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
