package com.example.learndeno.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    private Paint paint;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //        实例化画笔对象
        paint = new Paint();
//        设置画笔颜色
        paint.setColor(Color.YELLOW);
//        设置画笔属性
        paint.setStyle(Paint.Style.FILL);//实心圆
        //paint.setStyle(Paint.Style.STROKE);//空心圆
//        设置画笔粗细
        paint.setStrokeWidth(6);
//        x坐标，y坐标，半径，画笔
        canvas.drawCircle(getWidth() / 3 * 2 - 100, getHeight() / 3 + 100, 200, paint);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(getWidth() / 3, getHeight() / 2, 300, paint);
        canvas.drawCircle(getWidth() / 3 * 2, getHeight() / 5 * 3 - 50, 220, paint);
    }
}
