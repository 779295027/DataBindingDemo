package com.sss.demo.util;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.sss.demo.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sss on 2016/7/1.
 */
public class ImageLoad {
    private static ImageLoad imageLoad;
    private static final String IMAGE_RESOURCE = "你的域名";
    private static final String TOKEN_NAME = "你的域名";
    private String token;

    public ImageLoad() {
    }

    public void addToken(String token) {
        this.token = token;
    }

    public static ImageLoad getInstance() {
        return imageLoad != null ? imageLoad : new ImageLoad();
    }

    /**
     * 加载图片
     *
     * @param context   上下文
     * @param url       图片地址
     * @param imageView 控件
     */
    public void display(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)//图片地址
                .placeholder(R.mipmap.ic_loading)//加载时显示的图，找不到图片时也显示这个
                .into(imageView);//imageview对象
    }


    /**
     * 加载需要身份验证的图片
     * 使用前请确保点添加过token
     *
     * @param context   上下文
     * @param url       图片地址
     * @param imageView 控件
     */
    public void displayNeedToken(Context context, String url, ImageView imageView) {
        GlideUrl glideUrl = new GlideUrl(url, new Headers() {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> map = new HashMap<>();
                map.put(TOKEN_NAME, token);
                return map;
            }
        });

        Glide.with(context)
                .load(glideUrl)//图片地址
                .placeholder(R.mipmap.ic_loading)//加载时显示的图，找不到图片时也显示这个
                .into(imageView);//imageview对象
    }


}
