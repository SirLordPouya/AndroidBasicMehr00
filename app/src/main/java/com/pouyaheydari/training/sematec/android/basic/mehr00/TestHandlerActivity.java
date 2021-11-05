package com.pouyaheydari.training.sematec.android.basic.mehr00;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TestHandlerActivity extends AppCompatActivity {

    boolean hasUserClickedOnBackBtn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_handler);
    }

    @Override
    public void onBackPressed() {
        if (hasUserClickedOnBackBtn)
            super.onBackPressed();
        else {
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
            hasUserClickedOnBackBtn = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    hasUserClickedOnBackBtn = false;
                }
            }, 2500);
        }
    }
}