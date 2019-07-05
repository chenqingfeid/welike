package com.redefine.welike.base.dao.storage;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "UPLOAD".
*/
public class UploadDao extends AbstractDao<Upload, String> {

    public static final String TABLENAME = "UPLOAD";

    /**
     * Properties of entity Upload.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Sign = new Property(0, String.class, "sign", true, "SIGN");
        public final static Property Uploadid = new Property(1, String.class, "uploadid", false, "UPLOADID");
    }


    public UploadDao(DaoConfig config) {
        super(config);
    }
    
    public UploadDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"UPLOAD\" (" + //
                "\"SIGN\" TEXT PRIMARY KEY NOT NULL UNIQUE ," + // 0: sign
                "\"UPLOADID\" TEXT NOT NULL );"); // 1: uploadid
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"UPLOAD\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Upload entity) {
        stmt.clearBindings();
 
        String sign = entity.getSign();
        if (sign != null) {
            stmt.bindString(1, sign);
        }
        stmt.bindString(2, entity.getUploadid());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Upload entity) {
        stmt.clearBindings();
 
        String sign = entity.getSign();
        if (sign != null) {
            stmt.bindString(1, sign);
        }
        stmt.bindString(2, entity.getUploadid());
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public Upload readEntity(Cursor cursor, int offset) {
        Upload entity = new Upload( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // sign
            cursor.getString(offset + 1) // uploadid
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Upload entity, int offset) {
        entity.setSign(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setUploadid(cursor.getString(offset + 1));
     }
    
    @Override
    protected final String updateKeyAfterInsert(Upload entity, long rowId) {
        return entity.getSign();
    }
    
    @Override
    public String getKey(Upload entity) {
        if(entity != null) {
            return entity.getSign();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Upload entity) {
        return entity.getSign() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}