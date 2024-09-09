package com.example.logtoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button log=findViewById(R.id.login);
        EditText username=findViewById(R.id.user);
        EditText password=findViewById(R.id.pass);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if(user.equals("admin")&&pass.equals("admin")) {
                    message("Login....");
                }else{
                    message("failed...");
                }
            }
        });
    }
    public void message(String msge) {
        Toast.makeText(this, msge, Toast.LENGTH_LONG).show();
    }
}
