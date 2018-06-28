package com.example.android.partyplanner;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main5Activity extends AppCompatActivity {

    EditText guest1, guest2, guest3;
    Button email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        guest1 = (EditText) findViewById(R.id.editText2);
        guest2 = (EditText) findViewById(R.id.editText3);
        guest3 = (EditText) findViewById(R.id.editText4);
        email = (Button) findViewById(R.id.button2);

        final String g1, g2, g3;

        g1 = guest1.getText().toString();
        g2 = guest2.getText().toString();
        g3 = guest3.getText().toString();

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL, " " + g1 + " " + g2 + " " + g3 );
                i.putExtra(Intent.EXTRA_SUBJECT, "Invitation for the party.");
                i.putExtra(Intent.EXTRA_TEXT, "You are heartedly invited for the occassion. Please grace the party with your presence. We'll be eagerly waiting for your presence. Please, be there on time. Thank You.");


                if (i.resolveActivity(getPackageManager()) != null){
                    startActivity(i);
                }
            }
        });
    }
}
