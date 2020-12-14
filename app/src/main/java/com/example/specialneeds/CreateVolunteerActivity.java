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

public class CreateVolunteerActivity extends AppCompatActivity {

    private EditText nameView;
    private EditText fnameView;
    private EditText emailView;
    private EditText passwordView1;
    private EditText passwordView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_volunteer);

        getSupportActionBar().hide();

        EditText name = (EditText) findViewById(R.id.editTextName);
        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        EditText fname = (EditText) findViewById(R.id.editTextFamilyName);
        fname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        EditText email = (EditText) findViewById(R.id.editTextEmailAddress);
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        EditText pass = (EditText) findViewById(R.id.editTextPassword);
        pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        EditText reenteredPass = (EditText) findViewById(R.id.editTextPassword2);
        reenteredPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        Button submit = (Button) findViewById(R.id.button_volunteer_signup);
        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O_MR1)
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;

                String volunteer_name = nameView.getText().toString();
                String volunteer_fname = fnameView.getText().toString();
                String volunteer_email = emailView.getText().toString();
                String volunteer_password1 = passwordView1.getText().toString();
                String volunteer_password2 = passwordView2.getText().toString();
                //Birthday

                volunteer_name = volunteer_name.concat(" ");
                String fullName = volunteer_name.concat(volunteer_fname);

                if (volunteer_password1.compareTo(volunteer_password2) == 0){
                    /*
                    DatabaseAccess dbAccess = DatabaseAccess.getInstance(getApplicationContext());
                    dbAccess.open();
                    */
                    String text = "Volunteer account created successfully!";
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
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}