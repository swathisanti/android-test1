package com.example.macstudent.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by macstudent on 2017-04-22.
 */

public class CustomAdapter extends ArrayAdapter<MyModel> {

    private ArrayList<MyModel> dataSet;
    Context mContext;


    public CustomAdapter(ArrayList<MyModel> data, Context context) {

        super(context, R.layout.row, data);
        this.dataSet = data;
        this.mContext=context;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) { // for the first time, inflate the view
            LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.row, parent, false);
        }

        TextView movieName = (TextView)convertView.findViewById(R.id.textid);
        ImageView movieImg = (ImageView)convertView.findViewById(R.id.imageid);

        MyModel temp = dataSet.get(position);

System.out.println("Value is "+temp.recepiename);
        movieName.setText(temp.recepiename);

        movieImg.setImageResource(temp.imgID);

        return convertView;
    }





}