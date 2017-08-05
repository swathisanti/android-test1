package com.example.macstudent.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class details_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);
        TextView name = (TextView)findViewById(R.id.detailid);
        Intent iobj = getIntent();
        String name1 = iobj.getStringExtra("movieNameKey");
        name.setText(name1);

    }
}
