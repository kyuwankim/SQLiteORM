package com.kyuwankim.android.sqliteorm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by kimkyuwan on 2017. 6. 9..
 */

public class DBHelper extends OrmLiteSqliteOpenHelper{

    public static final String DATABASE_NAME = "database.db";
    public static int DATABASE_VERION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
