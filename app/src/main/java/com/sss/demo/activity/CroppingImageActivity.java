package com.sss.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sss.demo.R;
import com.sss.demo.databinding.ActivityCroppingBinding;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

/**
 * Created by sunshaoshuai on 16/8/23.
 */
public class CroppingImageActivity extends Activity implements CropImageView.OnSetImageUriCompleteListener, CropImageView.OnCropImageCompleteListener {

    ActivityCroppingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cropping);
        //添加加载图像监听
        binding.cropImageView.setOnSetImageUriCompleteListener(this);
        //添加剪切图像监听
        binding.cropImageView.setOnCropImageCompleteListener(this);
//        binding.cropImageView.setImageResource(R.drawable.checktile);
        binding.cropImageView.setImageResource(R.mipmap.cat);
        binding.xuanzhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.cropImageView.rotateImage(90);
            }
        });
        binding.cropping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.cropImageView.getCroppedImageAsync();
            }
        });
    }

    @Override
    public void onCropImageComplete(CropImageView view, CropImageView.CropResult result) {
        handleCropResult(result);
    }

    private void handleCropResult(CropImageView.CropResult result) {
        if (result.getError() == null) {
            Intent intent = new Intent(this, CropResultActivity.class);
            intent.putExtra("SAMPLE_SIZE", result.getSampleSize());
            if (result.getUri() != null) {
                intent.putExtra("URI", result.getUri());
            } else {
                CropResultActivity.mImage = binding.cropImageView.getCropShape() == CropImageView.CropShape.OVAL
                        ? CropImage.toOvalBitmap(result.getBitmap())
                        : result.getBitmap();
            }
            startActivity(intent);
        } else {
            Log.e("AIC", "Failed to crop image", result.getError());
            Toast.makeText(this, "Image crop failed: " + result.getError().getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSetImageUriComplete(CropImageView view, Uri uri, Exception error) {
        if (error == null) {//加载成功
            Toast.makeText(this, "Image load successful", Toast.LENGTH_SHORT).show();
        } else {
            //加载失败
            Log.e("AIC", "Failed to load image by URI", error);
            Toast.makeText(this, "Image load failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
