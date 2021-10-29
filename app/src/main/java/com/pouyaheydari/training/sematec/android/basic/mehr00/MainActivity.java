package com.pouyaheydari.training.sematec.android.basic.mehr00;

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

        TextView txtTitle = findViewById(R.id.txtTitle);
        Button btnSave = findViewById(R.id.btnSave);


        txtTitle.setText(HtmlCompat.fromHtml("<h2>Title</h2><br><p>Description here</p>",HtmlCompat.FROM_HTML_MODE_COMPACT));

        // anonymous class - object
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Your data is saved!",Toast.LENGTH_LONG).show();
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