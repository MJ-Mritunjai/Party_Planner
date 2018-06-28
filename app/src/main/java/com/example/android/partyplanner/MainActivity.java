package com.example.android.partyplanner;

//import android.app.AlertDialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
//import android.database.Cursor;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editEmail, editUsername, editPassw, editCpassw;
    Button btnSignup, btnlogin;
    //Button btnviewAll;
    //Button btnDelete;

    //Button btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regis_xml);

        myDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.name);
        editEmail = (EditText) findViewById(R.id.email);
        editUsername = (EditText) findViewById(R.id.username);
        editPassw = (EditText) findViewById(R.id.pass);
        editCpassw = (EditText) findViewById(R.id.cpass);

        btnSignup = (Button) findViewById(R.id.button);
        btnlogin = (Button) findViewById(R.id.button3);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });

        InsertData();
        //viewAll();
        //UpdateData();
        //DeleteData();
    }

    /*
    p
    */
    public void InsertData() {
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passn = editPassw.getText().toString();
                String cpassn = editCpassw.getText().toString();
                if (passn.equals(cpassn)){     // Password check
                    boolean isInserted = myDb.insertData(editName.getText().toString(),
                            editEmail.getText().toString(),
                            editUsername.getText().toString(),                                  // if true
                            editPassw.getText().toString(),
                            editCpassw.getText().toString());

                    if (isInserted == true) {
                        Toast.makeText(MainActivity.this, "Signup Successfull", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    }
                    else
                        Toast.makeText(MainActivity.this, "Signup Failed", Toast.LENGTH_LONG).show();
                  }
                  else{                     // otherwise
                    Toast.makeText(MainActivity.this, "Password don't match", Toast.LENGTH_LONG).show();
                }

            }

        }
        );
    }

}
    /*
    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Surname :"+ res.getString(2)+"\n");
                            buffer.append("Marks :"+ res.getString(3)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

/*
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText usern, pass, cpass, name1, email;
    Button signup, login;

    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regis_xml);
        mydb = new DatabaseHelper(this);

        usern = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.pass);
        cpass = (EditText) findViewById(R.id.cpass);
        name1 = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        signup = (Button) findViewById(R.id.button);
        login = (Button) findViewById(R.id.button3);

        add_data();
    }

    public void add_data(){
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = mydb.insertdata(usern.getText().toString(),
                        pass.getText().toString(),
                        cpass.getText().toString(),
                        name1.getText().toString(),
                        email.getText().toString()
                        );

                if (isInserted == true){
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Insertion Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
        /*Intent i = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(i);
        //String username, password;

        /*openHelper = new DatabaseHelper(this);

        usern = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.pass);
        cpass = (EditText) findViewById(R.id.cpass);
        name1 = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        signup = (Button) findViewById(R.id.button);
        login = (Button) findViewById(R.id.button3);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        //username = usern.getText().toString();
        //password = pass.getText().toString();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openHelper.getWritableDatabase();
                String username = usern.getText().toString();
                String password = pass.getText().toString();
                String cpassword = cpass.getText().toString();
                String name = name1.getText().toString();
                String emailid = email.getText().toString();

                insertdata(username, password, cpassword, name, emailid);

                Toast.makeText(getApplicationContext(), "Registration Successfull", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void insertdata(String username, String password, String cpassword, String name, String emailid){
        ContentValues contet = new ContentValues();

        contet.put(DatabaseHelper.col_1, username);
        contet.put(DatabaseHelper.col_2, password);
        contet.put(DatabaseHelper.col_3, cpassword);
        contet.put(DatabaseHelper.col_4, name);
        contet.put(DatabaseHelper.col_5, emailid);

        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contet);
*/


