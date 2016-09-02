package com.sss.plusandminuslayout.circle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/**
 * Created by sunshaoshuai on 16/8/29.
 * 加号按钮
 */
public class CirclePlusButton extends CircleView {

    public CirclePlusButton(Context context) {
        super(context);
    }

    public CirclePlusButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CirclePlusButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawPlus(canvas);
    }

}
