package com.example.macstudent.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by macstudent on 2017-04-22.
 */

public class tab1 extends Fragment {

    ListView myListView;
    ArrayList<MyModel> myList = new ArrayList<MyModel>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tabone, container, false);
        myListView = (ListView) view.findViewById(R.id.myListViewID);

        MyModel ob1 = new MyModel();
        ob1.recepiename = "aalu";
        ob1.imgID = R.drawable.aalu;
        ob1.desc = "Potato curry or aloo curry recipe with step by step photos. ... This aloo curry goes very well with chapathi, rice, pulao or dosa. ... The same recipe can be used to make a dry potato curry or a potato gravy curry";
        myList.add(ob1);

        MyModel ob2 = new MyModel();

        ob2.recepiename = "ben";
        ob2.imgID = R.drawable.ben;
        ob2.desc = "This curry is exceptional firstly as it is nearly not spicy at all and secondly, okra is a slimy vegetable";
        myList.add(ob2);


        MyModel ob3 = new MyModel();

        ob3.recepiename = "egg";
        ob3.imgID = R.drawable.egg;
        ob3.desc = "Punjabi egg curry recipe with step by step photos. Made in dhaba style, it is exceptionally good when you are not in a mood to cook something elaborate";
        myList.add(ob3);


        MyModel ob4 = new MyModel();

        ob4.recepiename = "fish";
        ob4.imgID = R.drawable.fish;
        ob4.desc = "This is not an authentic andhra fish pulusu recipe, but is a quick and easy version of making a yummy south Indian style or andhra fish curry using tamarind. ... This fish curry recipe is the followed at my mum’s home for years.";
        myList.add(ob4);

        MyModel ob5 = new MyModel();
        ob5.recepiename = "mutton";
        ob5.imgID = R.drawable.mutton;
        ob5.desc ="Mutton curry recipe or mutton masala gravy recipe – Delicious, soft tender chunks of lamb meat in Indian style spiced onion tomato gravy";
        myList.add(ob5);

        MyModel ob6 = new MyModel();
        ob6.recepiename = "spinach";
        ob6.imgID = R.drawable.spinach;
        ob6.desc = "Put the onion, garlic, ginger and tomatoes in a food processor or blender and whizz to a purée.\n" +
                "Heat oil in a large pan. Add the spices, fry for a few secs and add purée and yeast extract. Bubble together for 2 mins, then add lentils and coconut cream.";
        myList.add(ob6);

        MyModel ob7 = new MyModel();
        ob7.recepiename = "sweetcorn";
        ob7.imgID = R.drawable.sweetcorn;
        ob7.desc = "Next heat Oil in a pan, add Cumin Seeds and the ground masala along with Sweet Corn. To this add the Red Chilli Powder, Coriander Powder, Garam Masala, Salt, Tomato Puree and mix well. Bring it to boil for 2 minutes.";
        myList.add(ob7);

        MyModel ob8 = new MyModel();
        ob8.recepiename = "tomato";
        ob8.imgID = R.drawable.tomato;
        ob8.desc = "Tomatoes, onions, and green chile peppers are the base of this quick and simple ... \"My mother used to make this curry ";
        myList.add(ob8);


        CustomAdapter myAdapter = new CustomAdapter(myList, getContext());

        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getActivity(), details_Activity.class);

                //MyModel myModelInfo = (MyModel) parent.getItemAtPosition(position);

                MyModel myModelInfo = myList.get(position);
                String movieName = myModelInfo.recepiename;
                String desc = myModelInfo.desc;
                intent.putExtra("movieNameKey", movieName);
                intent.putExtra("movieNameKey", desc);


                startActivity(intent);
            }
        });

        return view;
    }
        }

