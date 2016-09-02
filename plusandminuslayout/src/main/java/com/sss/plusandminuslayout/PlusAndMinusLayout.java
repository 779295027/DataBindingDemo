package com.sss.plusandminuslayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sss.plusandminuslayout.circle.CircleMinusButton;
import com.sss.plusandminuslayout.circle.CirclePlusButton;

/**
 * Created by sunshaoshuai on 16/8/31.
 */
public class PlusAndMinusLayout extends LinearLayout {
    private int number = 0;

    public PlusAndMinusLayout(Context context) {
        super(context);
        init(context);
    }

    public PlusAndMinusLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PlusAndMinusLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context) {
        init(context, null, 0);
    }

    private void init(Context context, AttributeSet attrs) {
        init(context, attrs, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        final TextView textView = new TextView(context);
        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        //此处相当于布局文件中的Android:layout_gravity属性
        lp.gravity = Gravity.CENTER_VERTICAL;
        textView.setLayoutParams(lp);
        textView.setPadding(10,0,10,0);
        updateNumber(textView);
        CircleMinusButton button = new CircleMinusButton(context);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number <= 0)
                    return;
                number--;
                updateNumber(textView);
            }
        });
        CirclePlusButton circlePlusButton = new CirclePlusButton(context);
        circlePlusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                updateNumber(textView);
            }
        });
        this.setOrientation(HORIZONTAL);
        this.addView(button);
        this.addView(textView);
        this.addView(circlePlusButton);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void updateNumber(TextView text) {
        if (number < 10) {
            text.setText("0" + number);
        } else {
            text.setText("" + number);
        }
    }
}
