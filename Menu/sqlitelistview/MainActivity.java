package com.example.sqlitelistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnClear, btnShow;
    EditText txtCompanyName;
    ControllerDB dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);
        btnShow = findViewById(R.id.show);
        txtCompanyName = findViewById(R.id.txtCompanyName);
        dbController = new ControllerDB(this);
    }

    public void AddData(View v) {
        try {
            if (TextUtils.isEmpty(txtCompanyName.getText().toString())) {
                Toast.makeText(this, "Please enter Company name", Toast.LENGTH_SHORT).show();
            } else {
                String result = dbController.insertData(txtCompanyName.getText().toString());
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                txtCompanyName.setText("");
            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void ShowData(View v) {
        try {
            Intent intent = new Intent(MainActivity.this, Display.class);
            startActivity(intent);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void ClearData(View v) {
        txtCompanyName.setText("");
    }
}
