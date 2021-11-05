package com.pouyaheydari.training.sematec.android.basic.mehr00;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TestAlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_alert_dialog);

        AlertDialog.Builder builder = new AlertDialog.Builder(TestAlertDialogActivity.this)
                .setTitle("Are you sure?")
                .setMessage("Are you sure you want to wipe all your data?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(TestAlertDialogActivity.this, "Yes Clicked!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(TestAlertDialogActivity.this, "No Clicked!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("I'm not sure!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(TestAlertDialogActivity.this, "I'm not sure clicked!", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.create().show();
    }
}