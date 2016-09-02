package com.sss.demo.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sss.demo.R;
import com.sss.demo.databinding.ActivityPlusMinusBinding;

/**
 * Created by sunshaoshuai on 16/9/2.
 */
public class PlusMinusActivity extends Activity {
    ActivityPlusMinusBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_plus_minus);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "" + binding.pam.getNumber(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
