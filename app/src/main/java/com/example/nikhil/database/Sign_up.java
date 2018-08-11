package com.example.nikhil.database;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {

    Button signupbtn;
    SharedPreferences preferences;
    EditText suName,suEmail,suUname,suPass,suCPass;
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final Intent intent=new Intent(Sign_up.this,HomeActivity.class);
        preferences = getSharedPreferences("Demo",MODE_PRIVATE);
        signupbtn = findViewById(R.id.signupBtn);
        /*Log.d("signupbtn","signupbtn");*/
        suName = findViewById(R.id.signupName);
        suEmail = findViewById(R.id.suEmail);
        suUname = findViewById(R.id.suUname);
        suPass = findViewById(R.id.suPass);
        suCPass = findViewById(R.id.suCPass);
        final String name = suName.getText().toString();
        final String email = suEmail.getText().toString();
        final String userName = suUname.getText().toString();
        final String password = suPass.getText().toString();
        final String cPass = suCPass.getText().toString();
        boolean chk = preferences.getBoolean("isLogin",false);
        /*if(chk){
            startActivity(intent);
        }*/
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(name.isEmpty()){
                        Toast.makeText(Sign_up.this,"Fill a details",Toast.LENGTH_SHORT).show();
                    }
                    else if(email.isEmpty()){
                        Toast.makeText(Sign_up.this,"Fill a details",Toast.LENGTH_SHORT).show();
                    }
                    else if (password.isEmpty()){
                        Toast.makeText(Sign_up.this,"Fill a details",Toast.LENGTH_SHORT).show();
                    }
                    else if(cPass.equals(password)){
                        Toast.makeText(Sign_up.this,"Fill a details",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        DatabaseHelper helper = new DatabaseHelper(Sign_up.this);
                        UserModel model = new UserModel();
                        model.setName(name);
                        model.setEmail(email);
                        model.setUsername(userName);
                        model.setPassword(password);
                        helper.insertUser(model);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("isLogin", true);
                        editor.apply();
                        startActivity(intent);
                    }

                    /*if (name.isEmpty()) {
                        Toast.makeText(Sign_up.this, "Enter a name", Toast.LENGTH_SHORT).show();
                    }

                    if (email.isEmpty()) {
                        Toast.makeText(Sign_up.this, "Enter a Email", Toast.LENGTH_SHORT).show();

                    }
                    if (userName.isEmpty()) {
                        Toast.makeText(Sign_up.this, "Enter a Username", Toast.LENGTH_SHORT).show();

                    }
                    if (password.isEmpty()) {
                        Toast.makeText(Sign_up.this, "Enter a password", Toast.LENGTH_SHORT).show();

                    }
                    if (cPass.isEmpty()) {
                        Toast.makeText(Sign_up.this, "Enter a Confirm Password", Toast.LENGTH_SHORT).show();
                    }
                    if (password.equals(cPass)) {
                        DatabaseHelper helper = new DatabaseHelper(Sign_up.this);
                        UserModel model = new UserModel();
                        model.setName(name);
                        model.setEmail(email);
                        model.setUsername(userName);
                        model.setPassword(password);
                        helper.insertUser(model);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("isLogin", true);
                        editor.apply();
                        startActivity(intent);
                    } else {
                        Toast.makeText(Sign_up.this, "Password not Matched", Toast.LENGTH_SHORT).show();
                    }*/

                }
                /*else{
                    Toast.makeText(Sign_up.this,"sds",Toast.LENGTH_SHORT).show();
                }*/

        });
    }
}
