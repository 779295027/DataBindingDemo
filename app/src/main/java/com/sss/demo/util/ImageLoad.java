package com.sss.demo.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sss.demo.R;

/**
 * Created by sss on 2016/7/1.
 */
public class ImageLoad {
    private static ImageLoad imageLoad;

    public ImageLoad() {
    }

    public static ImageLoad getInstance() {
        return imageLoad != null ? imageLoad : new ImageLoad();
    }

    public void display(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)//图片地址
                .placeholder(R.mipmap.ic_loading)//加载时显示的图，找不到图片时也显示这个
                .into(imageView);//imageview对象
    }

}
