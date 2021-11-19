package com.pouyaheydari.training.sematec.android.basic.mehr00;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TestRecyclerViewActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recycler_view);

        RecyclerView recycler = findViewById(R.id.recycler);

        String threadName = Thread.currentThread().getName();
        Log.d("TAG", "onCreate: " + threadName);

        TestThreadClass threadClass = new TestThreadClass();
        threadClass.start();

        Thread thread = new Thread(this);
        thread.start();

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Pouya", "Heydari"));

//        ArrayList<String> names = new ArrayList<>();
//        names.add("Pouya Heydari");
//        names.add("Alireza Khojasteh");
//        names.add("Mohammadreza Ebrahimi");
//        names.add("Mohammadreza Shokrani");
//        names.add("Sare Saberi");

        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recycler.setLayoutManager(manager);

        TestAdapter adapter = new TestAdapter(persons);
        recycler.setAdapter(adapter);

//        Intent intent = new Intent(TestRecyclerViewActivity.this, TestService.class);
//        startForegroundService(intent);

        TestBroadcastReceiver receiver = new TestBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(receiver, intentFilter);

        Intent intent = new Intent();
        intent.setAction("com.pouyaheydari.training.sematec.android.basic.mehr00.MY_ACTION");
        intent.putExtra("userName", "Pouya");
        sendBroadcast(intent);
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        Log.d("TAG", "run: " + threadName);
    }
}