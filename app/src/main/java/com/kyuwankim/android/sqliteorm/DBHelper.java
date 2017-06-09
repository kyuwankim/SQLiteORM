package com.kyuwankim.android.sqliteorm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kimkyuwan on 2017. 6. 9..
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {

    public static final String DATABASE_NAME = "database.db";
    public static int DATABASE_VERION = 1;

    // 최초 호출될 때 database.db 파일을 /data/data/패키지명/database/디렉토리 아래애 생성해준다
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERION);
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

    // DataBase 버전이 업그레이드 되면 호출된다
    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        // Memo 테이블의 특정 컬럼만 변경되었을 경우
        // 1. 기본 테이블을 백업하기위한 임시테이블을 생성하고 데이터를 담아둔다
        //    예) create table temp_memo < - 기존데이터
        // 2. Memo 테이블을 삭제하고 다시 생성한다
        // 3. 백업된 데이터를 다시 입력한다
        // 4. 임시 테이블 삭제
    }

    // Create
    public void create(Memo memo) {
        try {
            // 1. 테이블에 연결
            Dao<Memo, Integer> dao = getDao(Memo.class);
            // 2. 데이터를 입력
            dao.create(memo);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    // ReadAll
    public List<Memo> readAll() {
        List<Memo> datas = null;
        try {
            // 1. 테이블에 연결
            Dao<Memo, Integer> dao = getDao(Memo.class);
            // 2. 데이터를 전체 읽어오기
            datas = dao.queryForAll();
            // 2.2 ID로 데이터 조회하기


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datas;
    }

    // Read one
    public Memo read(int memoid) {
        Memo memo = null;
        try {
            // 1. 테이블에 연결
            Dao<Memo, Integer> dao = null;
            dao = getDao(Memo.class);
            // 2. 데이터를 한개 읽어오기
            memo = dao.queryForId(memoid);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memo;
    }

    // Search
    public List<Memo> search(String word){
        List<Memo> datas = null;

        try {
            // 1. 테이블에 연결
            Dao<Memo, Integer> dao = getDao(Memo.class);
            // 2. 데이터 검색하기
            String query = "select * from memo where content like '%"+word+"%'";
            GenericRawResults<Memo> temps = dao.queryRaw(query,dao.getRawRowMapper());
            datas = temps.getResults();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datas;
    }


    // Upate
    public void update() {

    }


    // Delete
    public void Delete() {

    }
}
