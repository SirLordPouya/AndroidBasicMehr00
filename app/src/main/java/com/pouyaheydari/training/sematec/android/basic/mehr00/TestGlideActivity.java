package com.pouyaheydari.training.sematec.android.basic.mehr00;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class TestGlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_glilde);

        ImageView imgProfile = findViewById(R.id.imgProfile);
        String url = "https://raw.githubusercontent.com/bumptech/glide/master/static/glide_logo.png";
        Glide.with(this).load(url).into(imgProfile);
    }
}