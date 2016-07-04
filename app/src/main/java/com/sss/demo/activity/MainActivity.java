package com.sss.demo.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.sss.demo.R;
import com.sss.demo.bean.User;
import com.sss.demo.databinding.ActivityMainBinding;
import com.sss.demo.util.MyAdpter;
import com.sss.demo.util.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<User> list;
    private ActivityMainBinding mainBinding;
    private MyAdpter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setName("name=这是我的databinding");
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
        User u = new User();
        u.setName(null);
        u.setAge("20");
        mainBinding.setUser(u);
        mainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("clicked button");
//                adapter.setUser(new User("点击", "1"));
//                adapter.setList(list);
                startActivity(new Intent(getApplicationContext(), ImageActivity.class));
            }
        });
        // 设置下拉圆圈上的颜色，蓝色、绿色、橙色、红色
        mainBinding.swipe.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        mainBinding.swipe.setDistanceToTriggerSync(400);
        // 设置下拉动画的背景色
        mainBinding.swipe.setProgressBackgroundColor(android.R.color.holo_red_light);
        // 设置下拉动画的大小
        mainBinding.swipe.setSize(SwipeRefreshLayout.LARGE);
        // 设置下拉动画的下拉事件
        mainBinding.swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                adapter.setFristData(new User("刷新", "刷新"), mainBinding.swipe);
                new OnRefreshAsyncTask().execute();
                adapter.setFristData(new User("刷新", "刷新"));
//                mainBinding.recyclerView.smoothScrollBy(0, -1000);//通过沿任一轴的像素的规定量动画滚动。（水平，垂直）
                mainBinding.recyclerView.smoothScrollToPosition(0);//启动一个平滑滚动到适配器的位置。
            }
        });
        mainBinding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager mLayoutManager = (LinearLayoutManager) mainBinding.recyclerView.getLayoutManager();
                int lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition();
                int totalCount = mLayoutManager.getItemCount();
                if (totalCount - lastVisibleItemPosition < 5) {
                    adapter.setList(list);
                }
            }
        });
        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mainBinding.recyclerView.seton
        adapter = new MyAdpter(this, list);
        adapter.setOnClickCallBack(new MyAdpter.OnClickCallBack() {
            @Override
            public void onClick(String msg) {
                showToast(msg);
            }
        });
        //添加间距，间距为1dp
        mainBinding.recyclerView.addItemDecoration(new SpaceItemDecoration(1));
        mainBinding.recyclerView.setAdapter(adapter);
        mainBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("clicked fab  ");
            }
        });
    }

    public void showToast(String s) {
        Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show();
    }


    class OnRefreshAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //停止刷新
            mainBinding.swipe.setRefreshing(false);

        }
    }

}
