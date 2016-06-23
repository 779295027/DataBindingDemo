package com.sss.demo.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;

/**
 * Created by sss on 2016/6/15.
 */
public abstract class BaseAdapter<T extends ViewHolder> extends RecyclerView.Adapter<T> {
    private LayoutInflater inflater;
    private Context context;


}
