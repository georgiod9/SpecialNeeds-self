package com.example.specialneeds;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        Button create_usr_btn = (Button)findViewById(R.id.button_user_signup);
        create_usr_btn.setOnClickListener(this);

        Button create_vol_btn = (Button)findViewById(R.id.button_volunteer_signup);
        create_vol_btn.setOnClickListener(this);

        Button sign_in_btn = (Button)findViewById(R.id.button_signin);
        sign_in_btn.setOnClickListener(this);

        Button openDB = (Button) findViewById(R.id.button_openDB);
        openDB.setOnClickListener(this);

        TextView toast = (TextView) findViewById(R.id.textView2);
        toast.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_user_signup:
                Intent createUser = new Intent(v.getContext(), CreateUserActivity.class);
                startActivity(createUser);
                break;

            case R.id.button_volunteer_signup:
                Intent createVolunteer = new Intent(v.getContext(), CreateVolunteerActivity.class);
                startActivity(createVolunteer);
                break;

            case R.id.button_signin:
                Intent signIn = new Intent(v.getContext(), SignInActivity.class);
                startActivity(signIn);
                break;

            case R.id.textView2:
                Context context = getApplicationContext();
                CharSequence text = "اضغط على الزر أعلاه!";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.BOTTOM, 0, 25);
                toast.show();
                break;

            case R.id.button_openDB:
                Intent displayDB_Content = new Intent(v.getContext(), displayDB.class);
                startActivity(displayDB_Content);
                break;

            default:
                break;
        }
    }
}