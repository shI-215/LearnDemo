package com.example.learndeno.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.learndeno.R;

public class LayoutView extends RelativeLayout {
    private ImageView iv_back, iv_next;
    private TextView tv_title, tv_other;

    public LayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_view, this);
    }

    public void setLVinit(int back, String title, String other, int next) {
        init();
        if (back == 0) {
            iv_back.setVisibility(GONE);
        }
        tv_title.setText(title);
        tv_other.setText(other);
        if (next == 0) {
            iv_next.setVisibility(GONE);
        }
    }

    private void init() {
        iv_back = findViewById(R.id.iv_back);
        tv_title = findViewById(R.id.tv_title);
        tv_other = findViewById(R.id.tv_other);
        iv_next = findViewById(R.id.iv_next);
    }
}
