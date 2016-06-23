package com.sss.demo.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.sss.demo.R;
import com.sss.demo.databinding.MyActivtyLayoutBinding;

/**
 * Created by sss on 2016/6/13.
 */
public class DemoActivty extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyActivtyLayoutBinding binding = DataBindingUtil.setContentView(this, R.layout.my_activty_layout);
        binding.setName("测试成功");
    }
}
