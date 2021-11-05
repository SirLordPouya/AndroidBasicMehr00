package com.pouyaheydari.training.sematec.android.basic.mehr00;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String family = intent.getStringExtra("family");
        int id = intent.getIntExtra("id", -1);


        Toast.makeText(this, name + family + id, Toast.LENGTH_SHORT).show();


        // Check the database

        TextView txtTitle = findViewById(R.id.txtTitle);
        Button btnSave = findViewById(R.id.btnSave);


        txtTitle.setText(HtmlCompat.fromHtml("<h2>Title</h2><br><p>Description here</p>", HtmlCompat.FROM_HTML_MODE_COMPACT));

        // anonymous class - object
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.putExtra("isValid", true);
                setResult(Activity.RESULT_OK, intent1);
                finish();
            }
        });

        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Sematec", "onClick: txtTitle");
            }
        });
    }

}