package com.example.sqlitelistview;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Display extends AppCompatActivity {
    ListView lstView;
    ControllerDB dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        lstView = findViewById(R.id.lstView);
        dbController = new ControllerDB(this);
        Cursor cursor = dbController.getCompanies();

        String[] from = {"CompanyName"};
        int[] to = {R.id.txtListElement};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_row, cursor, from, to, 0);
        lstView.setAdapter(adapter);
    }
}
