package com.example.android.partyplanner;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    DatabaseHelper mydb;
    Button bt_signup, bt_login;
    EditText username, passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DatabaseHelper(this);

        bt_signup = (Button) findViewById(R.id.signup_button);
        bt_login = (Button) findViewById(R.id.login_button);
        username = (EditText) findViewById(R.id.username);
        passw = (EditText) findViewById(R.id.password);



        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(i);
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usern = username.getText().toString();
                String pass = passw.getText().toString();

                String ret_pass = mydb.login(usern);
                /*
                if (cur.getCount() == 0 ){
                    Toast.makeText(Main2Activity.this, "Please Signup first", Toast.LENGTH_LONG).show();
                    return;
                }

                String pass = passw.getText().toString();
                String retrieved_pass = null;

                //StringBuffer buff = new StringBuffer();
                while(cur.moveToNext()){
                    retrieved_pass = cur.getString(0);
                }

                if (pass == retrieved_pass){
                    Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(Main2Activity.this, "Login Failed", Toast.LENGTH_LONG).show();
                    return;
                }
                */
                if (pass.equals(ret_pass)){
                    Toast.makeText(Main2Activity.this, "Login Successfull", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(Main2Activity.this, "Login Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
