package com.example.learndeno;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learndeno.activity.CanvasActivity;
import com.example.learndeno.activity.DialogActivity;
import com.example.learndeno.activity.HandleThreadActivity;
import com.example.learndeno.activity.LayoutActivity;
import com.example.learndeno.activity.ServiceActivity;
import com.example.learndeno.activity.TextShowActivity;
import com.example.learndeno.activity.ZBarActivity;
import com.example.learndeno.activity.ZXingActivity;
import com.example.learndeno.adapter.ListAdapter;
import com.example.learndeno.bean.MBook;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv_demo;
    private List<MBook> mBooks = new ArrayList<>();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MBook");
        context = this;
        initView();
        initData();
        ListAdapter listAdapter = new ListAdapter(MainActivity.this, R.layout.list_item, mBooks);
        lv_demo.setAdapter(listAdapter);
    }

    private void initView() {
        lv_demo = (ListView) findViewById(R.id.lv_demo);

        lv_demo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MBook mBook = mBooks.get(position);
                Intent intent = new Intent();
                switch (mBook.getId()) {
                    case 1:
                        intent.setClass(context, TextShowActivity.class);
                        break;
                    case 2:
                        intent.setClass(context, DialogActivity.class);
                        break;
                    case 3:
                        intent.setClass(context, CanvasActivity.class);
                        break;
                    case 4:
                        intent.setClass(context, LayoutActivity.class);
                        break;
                    case 5:
                        intent.setClass(context, HandleThreadActivity.class);
                        break;
                    case 6:
                        intent.setClass(context, ServiceActivity.class);
                        break;
                    case 7:
                        intent.setClass(context, ZBarActivity.class);
                        break;
                    case 8:
                        intent.setClass(context, ZXingActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }

    private void initData() {
        mBooks.add(new MBook(1, "跑马灯", "2019-12-15"));
        mBooks.add(new MBook(2, "提示框", "2019-12-16"));
        mBooks.add(new MBook(3, "自定义View", "2019-12-16"));
        mBooks.add(new MBook(4, "自定义布局", "2019-12-17"));
        mBooks.add(new MBook(5, "线程、handle", "2019-12-18"));
        mBooks.add(new MBook(6, "服务", "2019-12-18"));
        mBooks.add(new MBook(7, "二维码(ZBar)", "2019-12-22"));
        mBooks.add(new MBook(8, "二维码(ZXing)", "2019-12-21"));
    }
}
