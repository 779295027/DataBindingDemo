package com.sss.demo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.sss.demo.R;
import com.sss.demo.bean.User;
import com.sss.demo.databinding.ActivityHaveHeaderRecyclerBinding;
import com.sss.demo.adapter.HaveHeaderRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sss on 2016/7/15.
 */
public class HaveHeaderRecyclerActivity extends FragmentActivity {

    private ActivityHaveHeaderRecyclerBinding binding;
    private List<User> list;
    private HaveHeaderRecyclerAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_have_header_recycler);
        list = new ArrayList<>();
        list.add(new User("第一", "1"));
        list.add(new User("第二", "2"));
        list.add(new User("第三", "3"));
        list.add(new User("第四", "4"));
        list.add(new User("第五", "5"));
        list.add(new User("第六", "6"));
        list.add(new User("第七", "7"));
        list.add(new User("第八", "8"));
        list.add(new User("第九", "9"));
        list.add(new User("第十", "0"));

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HaveHeaderRecyclerAdapter(this, list);
        binding.recyclerView.setAdapter(adapter);
    }
}
