package com.redefine.welike.base.dao.im;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ACCOUNT_SETTING".
*/
public class AccountSettingDao extends AbstractDao<AccountSetting, String> {

    public static final String TABLENAME = "ACCOUNT_SETTING";

    /**
     * Properties of entity AccountSetting.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Uid = new Property(0, String.class, "uid", true, "UID");
        public final static Property ImMessageCursor = new Property(1, String.class, "imMessageCursor", false, "IM_MESSAGE_CURSOR");
        public final static Property MentionMsgUnReadCount = new Property(2, Integer.class, "mentionMsgUnReadCount", false, "MENTION_MSG_UN_READ_COUNT");
        public final static Property CommentMsgUnReadCount = new Property(3, Integer.class, "commentMsgUnReadCount", false, "COMMENT_MSG_UN_READ_COUNT");
        public final static Property LikeMsgUnReadCount = new Property(4, Integer.class, "likeMsgUnReadCount", false, "LIKE_MSG_UN_READ_COUNT");
    }


    public AccountSettingDao(DaoConfig config) {
        super(config);
    }
    
    public AccountSettingDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ACCOUNT_SETTING\" (" + //
                "\"UID\" TEXT PRIMARY KEY NOT NULL UNIQUE ," + // 0: uid
                "\"IM_MESSAGE_CURSOR\" TEXT," + // 1: imMessageCursor
                "\"MENTION_MSG_UN_READ_COUNT\" INTEGER," + // 2: mentionMsgUnReadCount
                "\"COMMENT_MSG_UN_READ_COUNT\" INTEGER," + // 3: commentMsgUnReadCount
                "\"LIKE_MSG_UN_READ_COUNT\" INTEGER);"); // 4: likeMsgUnReadCount
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ACCOUNT_SETTING\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AccountSetting entity) {
        stmt.clearBindings();
 
        String uid = entity.getUid();
        if (uid != null) {
            stmt.bindString(1, uid);
        }
 
        String imMessageCursor = entity.getImMessageCursor();
        if (imMessageCursor != null) {
            stmt.bindString(2, imMessageCursor);
        }
 
        Integer mentionMsgUnReadCount = entity.getMentionMsgUnReadCount();
        if (mentionMsgUnReadCount != null) {
            stmt.bindLong(3, mentionMsgUnReadCount);
        }
 
        Integer commentMsgUnReadCount = entity.getCommentMsgUnReadCount();
        if (commentMsgUnReadCount != null) {
            stmt.bindLong(4, commentMsgUnReadCount);
        }
 
        Integer likeMsgUnReadCount = entity.getLikeMsgUnReadCount();
        if (likeMsgUnReadCount != null) {
            stmt.bindLong(5, likeMsgUnReadCount);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AccountSetting entity) {
        stmt.clearBindings();
 
        String uid = entity.getUid();
        if (uid != null) {
            stmt.bindString(1, uid);
        }
 
        String imMessageCursor = entity.getImMessageCursor();
        if (imMessageCursor != null) {
            stmt.bindString(2, imMessageCursor);
        }
 
        Integer mentionMsgUnReadCount = entity.getMentionMsgUnReadCount();
        if (mentionMsgUnReadCount != null) {
            stmt.bindLong(3, mentionMsgUnReadCount);
        }
 
        Integer commentMsgUnReadCount = entity.getCommentMsgUnReadCount();
        if (commentMsgUnReadCount != null) {
            stmt.bindLong(4, commentMsgUnReadCount);
        }
 
        Integer likeMsgUnReadCount = entity.getLikeMsgUnReadCount();
        if (likeMsgUnReadCount != null) {
            stmt.bindLong(5, likeMsgUnReadCount);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public AccountSetting readEntity(Cursor cursor, int offset) {
        AccountSetting entity = new AccountSetting( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // uid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // imMessageCursor
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // mentionMsgUnReadCount
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // commentMsgUnReadCount
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4) // likeMsgUnReadCount
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AccountSetting entity, int offset) {
        entity.setUid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setImMessageCursor(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMentionMsgUnReadCount(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setCommentMsgUnReadCount(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setLikeMsgUnReadCount(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
     }
    
    @Override
    protected final String updateKeyAfterInsert(AccountSetting entity, long rowId) {
        return entity.getUid();
    }
    
    @Override
    public String getKey(AccountSetting entity) {
        if(entity != null) {
            return entity.getUid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(AccountSetting entity) {
        return entity.getUid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
