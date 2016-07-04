package com.sss.demo.util;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sss.demo.R;
import com.sss.demo.bean.User;
import com.sss.demo.databinding.ListItemBinding;

import java.util.List;

/**
 * Created by sss on 2016/6/13.
 */
public class MyAdpter extends RecyclerView.Adapter<MyAdpter.BindingHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<User> list;
    private OnClickCallBack onClickCallBack;

    public void setOnClickCallBack(OnClickCallBack onClickCallBack) {
        this.onClickCallBack = onClickCallBack;
    }

    public interface OnClickCallBack {
        void onClick(String msg);
    }


    public MyAdpter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemBinding listItemBinding = DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false);
//        or
//        ListItemBinding binding = ListItemBinding.inflate(inflater, parent, false);
        BindingHolder bindingHolder = new BindingHolder(listItemBinding.getRoot());
        bindingHolder.setBinding(listItemBinding);
        return bindingHolder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, final int position) {
        User user = list.get(position);
        holder.binding.setUser(user);
        holder.binding.listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickCallBack != null)
                    onClickCallBack.onClick("这是我要传递的消息:" + position);
//                Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setList(List<User> l) {
        list.addAll(l);
        notifyItemInserted(list.size());
    }

    public void setFristData(User user) {
        list.add(0, user);
        notifyItemInserted(0);
    }

    public void setFristData(User user, SwipeRefreshLayout layout) {
        list.add(0, user);
        notifyItemInserted(0);
        layout.stopNestedScroll();
    }

    public void setUser(User user) {
        list.add(user);
//        notifyDataSetChanged();
        notifyItemInserted(list.size() - 1);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class BindingHolder extends RecyclerView.ViewHolder {
        private ListItemBinding binding;

        public BindingHolder(View v) {
            super(v);
        }

        public ListItemBinding getBinding() {
            return binding;
        }

        public void setBinding(ListItemBinding binding) {
            this.binding = binding;
        }


    }
}
