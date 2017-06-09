package com.kyuwankim.android.sqliteorm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by kimkyuwan on 2017. 6. 9..
 */


@DatabaseTable(tableName = "memo")
public class Memo {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String title;
    @DatabaseField
    private String content;
    @DatabaseField
    private Date date;

    public Memo() {
        // OrmLite는 기본생성자가 없으면 동작하지 않는다
        setDate();
    }

    public Memo(String title, String content) {

        this.title = title;
        this.content = content;

        setDate();
    }

    public Date getDate() {
        return date;
    }

    private void setDate() {
        this.date = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
