package com.example.learndeno.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learndeno.R;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_confirm;
    private Button btn_double;
    private Button btn_input;
    private Button btn_one;
    private Button btn_more;
    private Button btn_list;
    private Button btn_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        initView();
    }

    private void initView() {
        btn_confirm = (Button) findViewById(R.id.btn_confirm);
        btn_double = (Button) findViewById(R.id.btn_double);
        btn_input = (Button) findViewById(R.id.btn_input);
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_more = (Button) findViewById(R.id.btn_more);
        btn_list = (Button) findViewById(R.id.btn_list);
        btn_image = (Button) findViewById(R.id.btn_image);

        btn_confirm.setOnClickListener(this);
        btn_double.setOnClickListener(this);
        btn_input.setOnClickListener(this);
        btn_one.setOnClickListener(this);
        btn_more.setOnClickListener(this);
        btn_list.setOnClickListener(this);
        btn_image.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_confirm:
                confirmDialog();
                break;
            case R.id.btn_double:
                doubleDialog();
                break;
            case R.id.btn_input:
                inputDialog();
                break;
            case R.id.btn_one:
                oneDialog();
                break;
            case R.id.btn_more:
                moreDialog();
                break;
            case R.id.btn_list:
                listDialog();
                break;
            case R.id.btn_image:
                imageDialog();
                break;
        }
    }

    private void confirmDialog() {
        new AlertDialog.Builder(this).setTitle("消息")
                .setMessage("下载成功！")
                .setPositiveButton("确定", null).show();
    }

    private void doubleDialog() {
        new AlertDialog.Builder(this).setTitle("警告")
                .setMessage("确定删除吗？")
                .setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("否", null).show();
    }

    private void inputDialog() {
        final EditText editText = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入你的名字：")
                .setView(editText)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", null).show();
    }

    private void oneDialog() {
        new AlertDialog.Builder(this).setTitle("请选择：")
                .setSingleChoiceItems(new String[]{
                        "one", "two", "three", "four", "five"
                }, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String str = null;
                        switch (which) {
                            case 0:
                                str = "one";
                                break;
                            case 1:
                                str = "two";
                                break;
                            case 2:
                                str = "three";
                                break;
                            case 3:
                                str = "four";
                                break;
                            case 4:
                                str = "five";
                                break;
                        }
                        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).setNegativeButton("取消", null).show();
    }

    private void moreDialog() {
        new AlertDialog.Builder(this).setTitle("多选项：")
                .setMultiChoiceItems(new String[]{
                        "one", "two", "three", "four", "five"
                }, null, null).setPositiveButton("确定", null)
                .setNegativeButton("取消", null).show();
    }


    private void listDialog() {
        new AlertDialog.Builder(this).setTitle("列表选项：")
                .setItems(new String[]{
                        "one", "two", "three", "four", "five"
                }, null)
                .setNegativeButton("确定", null).show();
    }

    private void imageDialog() {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_launcher_background);
        new AlertDialog.Builder(this).setTitle("图片")
                .setView(imageView)
                .setPositiveButton("确定", null).show();
    }

}
