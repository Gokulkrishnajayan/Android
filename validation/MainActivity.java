package com.example.validation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Pattern USERNAME_PATTERN=Pattern.compile("^[A-Za-z]\\w{4,30}$");
    Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$");
    Pattern AGE_PATTERN = Pattern.compile("^(?:[0-9]|[1-9][0-9]|1[01][0-9]|120)$");
    Pattern PHONE_PATTERN = Pattern.compile("^\\(?([2-9][0-9]{2})\\)?[-.\\s]?([2-9][0-9]{2})[-.\\s]?([0-9]{4})$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText username=findViewById(R.id.name);
        EditText age=findViewById(R.id.age);
        EditText phone=findViewById(R.id.phone);
        EditText pass=findViewById(R.id.pass);
        Button b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inpname=username.getText().toString();
                String inpage=age.getText().toString();
                String inph=phone.getText().toString();
                String inpass=pass.getText().toString();
                if (inpname.isEmpty()){
                    Toast.makeText(MainActivity.this, "Name field is empty", Toast.LENGTH_SHORT).show();
                }
                if (inpage.isEmpty()){
                    Toast.makeText(MainActivity.this, "Age field is Empty", Toast.LENGTH_SHORT).show();
                }
                if (inph.isEmpty()){
                    Toast.makeText(MainActivity.this, "Phone field is empty", Toast.LENGTH_SHORT).show();
                }
                if (!USERNAME_PATTERN.matcher(inpname).matches()){
                    username.setError("Enter alphabets[5-30]characters");
                }
                if (!AGE_PATTERN.matcher(inpage).matches()){
                    age.setError("Enter alphabets[5-30]characters");

                }
                if (!PASSWORD_PATTERN.matcher(inpass).matches()){
                    pass.setError("password too weak");
                }
                else{
                    Toast.makeText(MainActivity.this, "SUCCESS..", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}