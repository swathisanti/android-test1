package com.example.macstudent.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class login extends AppCompatActivity {
    EditText userName;
    EditText password;

    Button login;
    Button register;
    TextView msg;

    Realm realmObj2;
    helper objB = new helper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.loginBtn);
        register =(Button)findViewById(R.id.registerbtn);
        userName = (EditText)findViewById(R.id.nametxt);
        password = (EditText)findViewById(R.id.typeTxt);


        Realm.init(this);
        realmObj2 = Realm.getDefaultInstance();


    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent newScreen = new Intent(getApplication(),MainActivity.class);
            startActivity(newScreen);
            String userTxtField = userName.getText().toString();
            String passwordTxtField = password.getText().toString();

            RealmResults<helper> test2 = realmObj2.where(helper.class).findAll();

            for(int i=0; i<test2.size(); i++){

                if(userTxtField.equals(test2.get(i).email) && passwordTxtField.equals(test2.get(i).password)){


                }
                else if(userTxtField.isEmpty() || passwordTxtField.isEmpty()){

                    msg.setVisibility(View.VISIBLE);
                    msg.setText("You Have to Enter User name and Password...");
                }

            }

        }
    });






        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent newScreen = new Intent(getApplication(),Register.class);
                startActivity(newScreen);

            }
        });

    }

}
