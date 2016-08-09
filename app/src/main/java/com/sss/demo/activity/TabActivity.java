package com.sss.demo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;

import com.sss.demo.R;
import com.sss.demo.databinding.ActivityTabBinding;
import com.sss.demo.fragment.FourFragment;
import com.sss.demo.fragment.OneFragment;
import com.sss.demo.fragment.ThreeFragment;
import com.sss.demo.fragment.TwoFragment;

/**
 * Created by sss on 2016/7/5.
 */
public class TabActivity extends FragmentActivity {

    private ActivityTabBinding binding;
    private Fragment fragmentone, fragmenttwo, fragmentthree, fragmentfour;
    private String[] mTitles = new String[]{"第1个", "第2个", "第3个", "第4个"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tab);
        fragmentone = new OneFragment();
        fragmenttwo = new TwoFragment();
        fragmentthree = new ThreeFragment();
        fragmentfour = new FourFragment();
        binding.viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return fragmentone;
                    case 1:
                        return fragmenttwo;
                    case 2:
                        return fragmentthree;
                    case 3:
                        return fragmentfour;
                    default:
                        return fragmentone;
                }
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });

        //添加viewpager
            binding.tabLayout.setupWithViewPager(binding.viewPager);

            //第一个item是默认选中的，所以把图片设置成选中状态的图片
            binding.tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.mipmap.page2));

            //获取item的总数，并从第二个开始把图片设置成未选中状态的图片
            int i = binding.tabLayout.getTabCount();
            for (int j = 1; j < i; j++) {
                binding.tabLayout.getTabAt(j).setIcon(getResources().getDrawable(R.mipmap.page1));
            }

            //当添加item选择改变时将要调用的
                binding.tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            /**
             * 当调用一个选项卡进入选中状态。
             * @param tab
             */
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setIcon(getResources().getDrawable(R.mipmap.page2));
                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            /**
             * 当某个标签页退出选中状态时调用。
             * @param tab
             */
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(getResources().getDrawable(R.mipmap.page1));
            }

            /**
             * 当由用户再次选择一个已选择的标签调用。某些应用程序可以使用该操作返回到一个类别的顶层。
             * @param tab
             */
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
