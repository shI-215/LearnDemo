package com.example.learndeno.activity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learndeno.R;

public class TextShowActivity extends AppCompatActivity {

    private TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_show);
        initView();
    }

    private void initView() {
        tv_text = (TextView) findViewById(R.id.tv_text);

        tv_text.setSelected(true);
    }
}
