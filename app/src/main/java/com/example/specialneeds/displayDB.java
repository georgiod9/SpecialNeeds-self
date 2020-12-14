package com.example.specialneeds;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class displayDB extends AppCompatActivity {

    private GridView gridV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_db);

        getSupportActionBar().hide();

        gridV = (GridView) findViewById(R.id.GridView);

        DatabaseAccess dbAccess = DatabaseAccess.getInstance(this);
        dbAccess.open();

        List<String> list = dbAccess.getData();
        dbAccess.close();

        GridViewAdapter gridAdapter = new GridViewAdapter(getApplicationContext(), list);
        gridV.setAdapter(gridAdapter);

    }
}