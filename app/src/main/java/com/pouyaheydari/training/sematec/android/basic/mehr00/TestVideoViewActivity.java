package com.pouyaheydari.training.sematec.android.basic.mehr00;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class TestVideoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_video_view);
        VideoView vv = findViewById(R.id.vv);

        String url = "https://hajifirouz5.cdn.asset.aparat.com/aparat-video/32af81adebd417233c464567cc18bb1938967895-144p.mp4?wmsAuthSign=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6IjQ0MmM1ZTFiZGRhZDk5NWZjMzFlNmE5MjQ5NjRlODI3IiwiZXhwIjoxNjM1NTE0MjQyLCJpc3MiOiJTYWJhIElkZWEgR1NJRyJ9.KJdfvgMso1K-x5f7cMAsgk1ydbnJJ50OKqN_n4aeIJU";
        vv.setVideoURI(Uri.parse(url));
        vv.setMediaController(new MediaController(TestVideoViewActivity.this));
        vv.start();
    }
}