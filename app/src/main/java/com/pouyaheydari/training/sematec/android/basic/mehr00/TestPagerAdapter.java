package com.pouyaheydari.training.sematec.android.basic.mehr00;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TestPagerAdapter extends FragmentStateAdapter {

    public TestPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                TestFragment fragment = new TestFragment();
                return fragment;
            case 1:
                BlankFragment fragment1 = new BlankFragment();
                return fragment1;
            default:
                BlankFragment fragment2 = new BlankFragment();
                return fragment2;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
