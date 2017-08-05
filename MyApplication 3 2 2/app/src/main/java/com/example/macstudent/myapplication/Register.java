package com.example.macstudent.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;
import io.realm.RealmResults;

public class Register extends AppCompatActivity {
    Button submit;
    EditText name;
    EditText email;
    EditText age;
    EditText password;

    Realm realmobj;
    helper objA = new helper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText)findViewById(R.id.nametxt);
        email = (EditText)findViewById(R.id.emailtxt);
        age = (EditText)findViewById(R.id.agetxt);
        password = (EditText)findViewById(R.id.passtxt);

        Realm.init(this);

        realmobj = Realm.getDefaultInstance();

        submit = (Button) findViewById(R.id.submitBtn);


        submit.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                String nametxtField = name.getText().toString();
                String emailtxtField = email.getText().toString();
                String agetxtField = age.getText().toString();
                String passwordtxtField = password.getText().toString();

                objA.name = nametxtField;
                objA.email = emailtxtField;
                objA.age = agetxtField;
                objA.password = passwordtxtField;

                realmobj.beginTransaction();
                realmobj.copyToRealm(objA);
                realmobj.commitTransaction();



                Intent newScreen = new Intent(getApplication(), login.class);
                startActivity(newScreen);

                RealmResults<helper> test = realmobj.where(helper.class).findAll();

                for(int i=0; i<test.size(); i++){

                    System.out.println(test.get(i).name);
                    System.out.println(test.get(i).email);
                    System.out.println(test.get(i).age);
                    System.out.println(test.get(i).password);

                }


            }
        });
    }
}



