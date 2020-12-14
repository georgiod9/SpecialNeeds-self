package com.example.specialneeds;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class CreateUserActivity extends AppCompatActivity {

    private EditText nameView;
    private EditText fnameView;
    private EditText emailView;
    private EditText passwordView1;
    private EditText passwordView2;
    private EditText birthdayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        getSupportActionBar().hide();

        Button submit = (Button) findViewById(R.id.submit_button_user);
        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O_MR1)
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;

                String user_name = nameView.getText().toString();
                String user_fname = fnameView.getText().toString();
                String user_email = emailView.getText().toString();
                String user_password1 = passwordView1.getText().toString();
                String user_password2 = passwordView2.getText().toString();
                //Birthday

                user_name = user_name.concat(" ");
                String fullName = user_name.concat(user_fname);

                if (user_password1.compareTo(user_password2) == 0){
                    DatabaseAccess dbAccess = DatabaseAccess.getInstance(getApplicationContext());
                    dbAccess.open();

                    dbAccess.addAccount(fullName, user_email, user_password1, "u");
                    dbAccess.close();

                    String text = "User account created successfully!";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.BOTTOM, 0, 25);
                    toast.show();
                }
                else {
                    String text = "Passwords do not match, try again.";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.BOTTOM, 0, 25);
                    toast.show();
                }
            }
        });


        nameView = (EditText) findViewById(R.id.editTextUserName);
        nameView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        fnameView = (EditText) findViewById(R.id.editTextPersonName3);
        fnameView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        emailView = (EditText) findViewById(R.id.editTextEmailAddress);
        emailView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        passwordView1 = (EditText) findViewById(R.id.editTextPassword1);
        passwordView1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        passwordView2 = (EditText) findViewById(R.id.editTextPassword2);
        passwordView2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

/*
    @Override
    public void onClick(View v) {
        Toast toast = new Toast(getApplicationContext());
        String msg = "User Created Successfully!";
        toast.setText(msg);

        String user_name = "GEO";
        String user_email = "GEo@gmail.com";
        String user_password1 = "123";
        String user_password2 = "123";

        String user_name = nameView.getText().toString();
        String user_fname = fnameView.getText().toString();
        String user_email = emailView.getText().toString();
        String user_password1 = passwordView1.getText().toString();
        String user_password2 = passwordView2.getText().toString();
        //Birthday
        user_name = user_name.concat(" ");
        String fullName = user_name.concat(user_fname);

        if (user_password1.compareTo(user_password2) == 0){
            TestAdapter dbAdapter = new TestAdapter(getApplicationContext());
            dbAdapter.createDatabase();
            dbAdapter.open();

            dbAdapter.addUser(user_name, user_email, user_password1);
            dbAdapter.close();
        }


    }*/
}