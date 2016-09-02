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
