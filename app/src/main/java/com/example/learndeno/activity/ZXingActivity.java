package com.example.learndeno.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learndeno.R;

public class ZXingActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_my_code;
    private TextView tv_look;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);
        initView();
    }

    private void initView() {
        tv_my_code = (TextView) findViewById(R.id.tv_my_code);
        tv_look = (TextView) findViewById(R.id.tv_look);

        tv_my_code.setOnClickListener(this);
        tv_look.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())) {
            case R.id.tv_my_code:
                startActivity(new Intent(ZXingActivity.this, ZXing2Activity.class));
                break;
            case R.id.tv_look:

                break;
        }
    }
}
