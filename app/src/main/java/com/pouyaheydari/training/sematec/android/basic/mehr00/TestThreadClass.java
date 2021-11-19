package com.pouyaheydari.training.sematec.android.basic.mehr00;

import android.util.Log;

public class TestThreadClass extends Thread{

    @Override
    public void run() {
        super.run();
        String threadName = Thread.currentThread().getName();
        Log.d("TAG", "run: " + threadName);
    }
}
