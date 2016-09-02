/*
 * Copyright (c) 2016.  sss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sss.plusandminuslayout.circle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by sunshaoshuai on 16/8/29.
 * 圆形按钮
 */
public class CircleView extends View {
    private Paint mPaint;

    public CircleView(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);     //防止边缘的锯齿
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);     //防止边缘的锯齿
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);     //防止边缘的锯齿
    }

    //大圆半径
    private int bigRadius;
    //小圆半径，视加号或减号为一个小圆
    private int samllRadius;
    //环宽，是小圆和大圆之间的边距为一个圆环
    private int ringWidth;

    public void draw(Canvas canvas) { //设置画笔颜色
        //设置填充
        mPaint.setStyle(Paint.Style.FILL);

        //画一个圆
        canvas.drawCircle(bigRadius, bigRadius, bigRadius, mPaint);

        super.draw(canvas);
    }


    /**
     * 画一个减号
     */
    public void drawMinus(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        canvas.drawCircle(ringWidth, bigRadius, 5, paint);
        canvas.drawCircle(bigRadius + samllRadius, bigRadius, 5, paint);
        //设置画笔的粗细
        paint.setStrokeWidth(10);
        //画一条线
        canvas.drawLine(ringWidth, bigRadius, bigRadius + samllRadius, bigRadius, paint);
    }

    /**
     * 画一个加号
     *
     * @param canvas
     */
    public void drawPlus(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        canvas.drawCircle(ringWidth, bigRadius, 5, paint);
        canvas.drawCircle(bigRadius, ringWidth, 5, paint);
        canvas.drawCircle(bigRadius, bigRadius + samllRadius, 5, paint);
        canvas.drawCircle(bigRadius + samllRadius, bigRadius, 5, paint);
        //设置画笔的粗细
        paint.setStrokeWidth(10);
        //画一条线
        canvas.drawLine(ringWidth, bigRadius, bigRadius + samllRadius, bigRadius, paint);
        canvas.drawLine(bigRadius, ringWidth, bigRadius, bigRadius + samllRadius, paint);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = getCircleDefaultSize(100, heightMeasureSpec);
        int width = getCircleDefaultSize(100, widthMeasureSpec);
        if (width < height) {
            height = width;
        } else {
            width = height;
        }
        setMeasuredDimension(width, height);
        bigRadius = getHeight() / 2;
        samllRadius = bigRadius - 30;
        ringWidth = bigRadius - samllRadius;

    }

    /**
     * 处理高度或宽度
     * 父类有一个getDefaultSize()方法，是静态方法，不想想重写那个，所以就换了一个名字
     *
     * @param defaultSize 默认大小
     * @param measureSpec 当前大小
     * @return
     */
    public int getCircleDefaultSize(int defaultSize, int measureSpec) {
        int mySize = defaultSize;

        int mode = MeasureSpec.getMode(measureSpec);//获取填充的样式
        int size = MeasureSpec.getSize(measureSpec);//获取size

        switch (mode) {
            case MeasureSpec.UNSPECIFIED: {//如果没有指定大小，就设置为默认大小
                mySize = defaultSize;
                break;
            }
            case MeasureSpec.AT_MOST: {//如果测量模式是最大取值为size
                //我们将大小取默认值,你也可以取其他值
                mySize = defaultSize;
                break;
            }
            case MeasureSpec.EXACTLY: {//如果是固定的大小，那就不要去改变它
                mySize = size;
                break;
            }
        }
        return mySize;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:// 手指压下
                mPaint.setColor(Color.WHITE);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:// 手指离开
                mPaint.setColor(Color.RED);
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }
}