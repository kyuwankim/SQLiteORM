package com.kyuwankim.android.sqliteorm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by kimkyuwan on 2017. 6. 9..
 */

public class DBHelper extends OrmLiteSqliteOpenHelper{

    public static final String DATABASE_NAME = "database.db";
    public static int DATABASE_VERION = 1;

    // 최초 호출될 때 database.db 파일을 /data/data/패키지명/database/디렉토리 아래애 생성해준다
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERION);
    }

    // 최초에 생성되면 버전을 체크해서 onCreate 를 호출한다
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        // 테이블을 생성해야 한다
        try {
            TableUtils.createTable(connectionSource, Memo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
