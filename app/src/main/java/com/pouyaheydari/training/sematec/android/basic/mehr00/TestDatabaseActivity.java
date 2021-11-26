package com.pouyaheydari.training.sematec.android.basic.mehr00;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class TestDatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_database);
        Button btnInsert = findViewById(R.id.btnInsert);
        Button btnRead = findViewById(R.id.btnRead);

        TestSQLiteHelper helper = new TestSQLiteHelper(this, "Sematec", null, 1);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.insertStudent("Pouya", 18);
                helper.insertStudent("Alireza", 18);
                helper.insertStudent("MohammadReza E", 18);
                helper.insertStudent("MohammadReza S", 18);
                helper.insertStudent("Sare", 18);
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> names = helper.getAllStudentsNames();
                for (int i = 0; i < names.size(); i++) {
                    String name = names.get(i);
                    Toast.makeText(TestDatabaseActivity.this, name, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}