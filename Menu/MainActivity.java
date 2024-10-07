package com.example.menu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
//            case R.id.i1:
//                Toast.makeText(this,"Clicked File Menu", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.i2:
                Intent i = new Intent(MainActivity.this, second.class);
                startActivity(i);
                break;
            case R.id.i3:
                Toast.makeText(this,"I am save file",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

}
