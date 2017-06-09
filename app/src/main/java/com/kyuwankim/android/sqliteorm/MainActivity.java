package com.kyuwankim.android.sqliteorm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper helper = new DBHelper(this);

//        for(int i = 0 ; i < 10 ; i ++) {
//            Memo memo = new Memo();
//            memo.setTitle("title");
//            memo.setContent("Content");
//            helper.create(memo);
//        }
        // 데이터 하나 읽어오기
//        Memo one = helper.read(3);
//        Log.i("Memo",one.getId()+" title = "+one.getTitle()+", content ="+one.getContent());

        // 데이터 전체 읽어오기
//        List<Memo> datas =  helper.readAll();
//        for(Memo one : datas){
//        Log.i("Memo",one.getId()+" title = "+one.getTitle()+", content ="+one.getContent());
//        }

        // 기본 데이터 넣기
        helper.create(new Memo("AAA","BBB"));
        helper.create(new Memo("CCC","BBB"));
        helper.create(new Memo("DDD","BBB"));
        helper.create(new Memo("EEE","BBB"));
        // 데이터 검색하기
        List<Memo> datas =  helper.search("AAA");
        for(Memo one : datas){
            Log.i("Memo",one.getId()+" title = "+one.getTitle()+", content ="+one.getContent());
        }




    }
}
