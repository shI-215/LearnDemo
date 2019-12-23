package com.example.learndeno.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.learndeno.R;
import com.example.learndeno.view.LayoutView;

public class LayoutActivity extends AppCompatActivity {
    private LayoutView lv_update, lv_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        lv_update = findViewById(R.id.lv_update);
        lv_about = findViewById(R.id.lv_about);
        if (lv_update != null) {
            lv_update.setLVinit(0, "检查更新", "1.1.0", 1);
        }
        if (lv_about != null) {
            lv_about.setLVinit(0, "关于", "", 1);
        }
    }
}
