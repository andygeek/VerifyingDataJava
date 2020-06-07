package com.andygeek.verifyingdatajava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.Closeable;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Declare elements
    EditText edt_name;
    EditText edt_email;
    Button btn_verify_name;
    Button btn_verify_email;
    Button btn_ok;
    RadioButton rbt_male;
    RadioButton rbt_female;
    CheckBox chk_technology;
    CheckBox chk_videogames;
    CheckBox chk_mathematics;

    // Variables
    String name;
    String email;
    String gender;
    List<String> interests;

    Toast message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize
        edt_name = findViewById(R.id.edt_name);
        edt_email = findViewById(R.id.edt_email);
        btn_verify_name = findViewById(R.id.btn_verify_name);
        btn_verify_email = findViewById(R.id.btn_verify_email);
        btn_ok = findViewById(R.id.btn_ok);
        rbt_male = findViewById(R.id.rbt_male);
        rbt_female = findViewById(R.id.rbt_female);
        chk_technology = findViewById(R.id.chk_technology);
        chk_videogames = findViewById(R.id.chk_videogames);
        chk_mathematics = findViewById(R.id.chk_mathematics);

        interests = new ArrayList<String>();
        rbt_male.setChecked(true);

        // Set on click listener
        btn_verify_email.setOnClickListener(new listener_buttons());
        btn_verify_name.setOnClickListener(new listener_buttons());

        chk_mathematics.setOnClickListener(new listener_checkbox());
        chk_videogames.setOnClickListener(new listener_checkbox());
        chk_technology.setOnClickListener(new listener_checkbox());

        rbt_male.setOnClickListener(new listener_radiobutton());
        rbt_female.setOnClickListener(new listener_radiobutton());



        // This is the first form
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Catch to values
                name = edt_name.getText().toString();
                email = edt_email.getText().toString();

                // Add to list
                if (chk_technology.isChecked()) { interests.add("Technology"); }
                if (chk_mathematics.isChecked()) { interests.add("Mathematics"); }
                if (chk_videogames.isChecked()) { interests.add("Videogames"); }

                // Cathc to gender
                if (rbt_male.isChecked()) {
                    gender = "Male";
                }else{
                    gender = "Female";
                }

                // Show of variables in console
                Log.i("MyApp", name);
                Log.i("MyApp", email);
                Log.i("MyApp", gender);
                Log.i("MyApp", interests.toString());

                Snackbar.make(v, "Ok", Snackbar.LENGTH_SHORT).show();

            }
        });

    }


    // click listener for buttons
    class listener_buttons implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_verify_name:
                    String tempName = edt_name.getText().toString();
                    Log.i("andygeek", "Hoaaa" + tempName + "ppp");
                    if(tempName.equals("")){
                        edt_name.setError("Complete name");
                    }
                    else{
                        message = Toast.makeText(MainActivity.this, "Verify name", Toast.LENGTH_SHORT);
                        message.show();
                    }
                    break;
                case R.id.btn_verify_email:
                    String tempEmail = edt_email.getText().toString();
                    if(tempEmail.equals("")){
                        edt_email.setError("Complete email");
                    }
                    else{
                        message = Toast.makeText(MainActivity.this, "Verify email", Toast.LENGTH_SHORT);
                        message.show();
                    }
                    break;
            }
        }
    }


    // click listener for radiobuttons
    class listener_radiobutton implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            boolean male = true;
            switch (v.getId()){
                case R.id.rbt_male:
                    male = true;
                    break;
                case R.id.rbt_female:
                    male = false;
                    break;
            }
        }
    }

    // click listener for checkbox
    class listener_checkbox implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            CheckBox checkBox = (CheckBox) v;
            Boolean checked = checkBox.isChecked();

            switch (v.getId()){
                case R.id.chk_mathematics:
                    if(checked){
                        message = Toast.makeText(MainActivity.this, "You like mathematics", Toast.LENGTH_SHORT);
                        message.show();
                    }
                    else{
                        message = Toast.makeText(MainActivity.this, "You don't like mathematics", Toast.LENGTH_SHORT);
                        message.show();
                    }
                    break;
                case R.id.chk_technology:
                    if(checked){
                        message = Toast.makeText(MainActivity.this, "You like technology", Toast.LENGTH_SHORT);
                        message.show();
                    }
                    else{
                        message = Toast.makeText(MainActivity.this, "You don't like technology", Toast.LENGTH_SHORT);
                        message.show();
                    }
                    break;
                case R.id.chk_videogames:
                    if(checked){
                        message = Toast.makeText(MainActivity.this, "You like videogames", Toast.LENGTH_SHORT);
                        message.show();
                    }
                    else{
                        message = Toast.makeText(MainActivity.this, "You don't like videogames", Toast.LENGTH_SHORT);
                        message.show();
                    }
                    break;
            }
        }
    }


}


