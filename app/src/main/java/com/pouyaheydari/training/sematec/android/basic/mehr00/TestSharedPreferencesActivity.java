package com.pouyaheydari.training.sematec.android.basic.mehr00;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TestSharedPreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_shared_preferences);

        Button btnSave = findViewById(R.id.btnSave);
        EditText edtPersonName = findViewById(R.id.edtPersonName);

        String name = getSharedPreferences("mysharedpref", MODE_PRIVATE)
                .getString("name", "Unknown User!");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtPersonName.getText().toString();
                getSharedPreferences("mysharedpref", MODE_PRIVATE)
                        .edit()
                        .putString("name", name)
                        .apply();
            }
        });

    }
}