package com.example.storelocalmemory;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name,pass,phn,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        pass=findViewById(R.id.pass);
        phn=findViewById(R.id.phone);
        age=findViewById(R.id.age);
    }
    public void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("sp", MODE_PRIVATE);
        String s1 = sh.getString("name", " ");
        String s2 = sh.getString("pass", " ");
        int ph = sh.getInt("phone",0);
        int a = sh.getInt("age",0);
        name.setText(s1);
        pass.setText(s2);
        phn.setText(String.valueOf(ph));
        age.setText(String.valueOf(a));
    }
    public void onPause() {
        super.onPause();

        SharedPreferences.Editor sp=getSharedPreferences("sp", MODE_PRIVATE).edit();
        sp.putString("name", name.getText().toString());
        sp.putString("pass", pass.getText().toString());
        sp.putInt("age", Integer.parseInt(age.getText().toString()));
        sp.putInt("phone", Integer.parseInt(phn.getText().toString()));
        sp.commit();
        sp.apply();
    }
}