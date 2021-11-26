package com.pouyaheydari.training.sematec.android.basic.mehr00;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TestViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_pager);

        ViewPager2 pager = findViewById(R.id.pager);
        TabLayout tab = findViewById(R.id.tab);

        TestPagerAdapter adapter = new TestPagerAdapter(this);
        pager.setAdapter(adapter);

        new TabLayoutMediator(tab, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("First Fragment");
                        break;
                    case 1:
                        tab.setText("Second Fragment");
                        break;
                }
            }
        }).attach();

    }
}