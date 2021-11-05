package com.pouyaheydari.training.sematec.android.basic.mehr00;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class TestTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_text_view);

        TextView txtTitle = findViewById(R.id.txtTitle);

        ActivityResultLauncher<Intent> launchSomeActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            boolean isValid = data.getBooleanExtra("isValid", false);
                            Toast.makeText(TestTextViewActivity.this, "Is user valid: " + isValid, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestTextViewActivity.this, MainActivity.class);
                intent.putExtra("name", "Pouya");
                intent.putExtra("family", "Heydari");
                intent.putExtra("id", 150);
                launchSomeActivity.launch(intent);
            }
        });
    }
}