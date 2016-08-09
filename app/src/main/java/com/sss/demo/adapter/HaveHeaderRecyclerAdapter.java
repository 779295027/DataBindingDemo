package com.sss.demo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sss.demo.R;
import com.sss.demo.bean.User;
import com.sss.demo.databinding.ItemTestBinding;
import com.sss.demo.databinding.ListItemBinding;

import java.util.List;

/**
 * Created by sss on 2016/7/15.
 */
public class HaveHeaderRecyclerAdapter extends RecyclerView.Adapter<HaveHeaderRecyclerAdapter.BindingHolder> {

    private final static int HEADER = 0;//头部
    private final static int ITEM = 1;//item
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


    public HaveHeaderRecyclerAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER;
        }
        return ITEM;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BindingHolder bindingHolder;
        if (viewType == ITEM) {
            ListItemBinding listItemBinding = DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false);
//        or
//        ListItemBinding binding = ListItemBinding.inflate(inflater, parent, false);
            bindingHolder = new BindingHolder(listItemBinding.getRoot());
            bindingHolder.setBinding(listItemBinding);
        } else {
            ItemTestBinding itemTestBinding = DataBindingUtil.inflate(inflater, R.layout.item_test, parent, false);
            bindingHolder = new BindingHolder(itemTestBinding.getRoot());
            bindingHolder.setItemTestBinding(itemTestBinding);
        }
        bindingHolder.setViewType(viewType);
        return bindingHolder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, final int position) {
        if (holder.viewType == HEADER) {
//            这里可以对holder.headerBinding，也就是头部进行操作
        } else {
            User user = list.get(position - 1);
            holder.binding.setUser(user);
            holder.binding.listItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickCallBack != null)
                        onClickCallBack.onClick("这是我要传递的消息:" + position);
                }
            });
        }


    }

    public void setList(List<User> l) {
        list.addAll(l);
        notifyItemInserted(list.size());
    }

    public void setFristData(User user) {
        list.add(0, user);
        notifyItemInserted(0);//该方法本身就是在后台运行，不要放到异步中，否则会报错
    }

    public void setFristData(User user, SwipeRefreshLayout layout) {
        list.add(0, user);
        notifyItemInserted(0);//该方法本身就是在后台运行，不要放到异步中，否则会报错
        layout.stopNestedScroll();
    }

    public void setUser(User user) {
        list.add(user);
//        notifyDataSetChanged();
        notifyItemInserted(list.size() - 1);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() + 1 : 1;
    }

    public class BindingHolder extends RecyclerView.ViewHolder {
        private int viewType;
        private ListItemBinding binding;
        private ItemTestBinding headerBinding;

        public void setItemTestBinding(ItemTestBinding itemTestBinding) {
            this.headerBinding = itemTestBinding;
        }

        public void setViewType(int viewType) {
            this.viewType = viewType;
        }

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
