package com.sss.plusandminuslayout.circle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/**
 * Created by sunshaoshuai on 16/8/29.
 * 减号按钮
 */
public class CircleMinusButton extends CircleView {

    public CircleMinusButton(Context context) {
        super(context);
    }

    public CircleMinusButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleMinusButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) { //设置画笔颜色
        super.draw(canvas);
        drawMinus(canvas);
    }

}
