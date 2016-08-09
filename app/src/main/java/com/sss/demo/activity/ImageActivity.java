package com.sss.demo.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.sss.demo.R;
import com.sss.demo.databinding.ActivityImageBinding;
import com.sss.demo.util.ImageLoad;

/**
 * Created by sss on 2016/7/1.
 */
public class ImageActivity extends Activity implements View.OnClickListener {

    private ActivityImageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image);
        binding.button.setOnClickListener(this);
        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.length() != 6) {
                    binding.textInputLayout.setError("密码错误");
                    binding.textInputLayout.setErrorEnabled(true);
                } else {
                    binding.textInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.length() != 6) {
                    binding.textInputEditText.setError("密码错误");
                } else {

                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String s = "http://dudongliang.blob.core.chinacloudapi.cn/images/758f9cf28593ada2b6a3bd34a7be0742.jpg";
                ImageLoad.getInstance().display(this, s, binding.img);
                break;
        }
    }
}
