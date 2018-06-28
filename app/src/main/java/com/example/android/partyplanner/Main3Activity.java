package com.example.android.partyplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Main3Activity extends AppCompatActivity {

    RadioButton birthday, anniv, farewell;
    EditText budget;
    Button bt_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        birthday = (RadioButton) findViewById(R.id.radioButton1);
        anniv = (RadioButton) findViewById(R.id.radioButton2);
        farewell = (RadioButton) findViewById(R.id.radioButton3);
        budget = (EditText) findViewById(R.id.editText1);
        bt_submit = (Button) findViewById(R.id.button4);

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main3Activity.this, Main4Activity.class);
                startActivity(i);
            }
        });
    }
}
