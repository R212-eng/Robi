package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //DatabaseHelper myDb;
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private TextView Warn;
    private Button Login;
    private int counter=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Cafe Attendance");

      //  myDb = new DatabaseHelper(this);//
        Name = (EditText) findViewById(R.id.editText);
        Password = (EditText) findViewById(R.id.editText2);
        Info = (TextView) findViewById(R.id.textView);
        Warn = (TextView) findViewById(R.id.textView1);
        Login = (Button) findViewById(R.id.button);
        Info.setText("No of attempts reamaining: 4");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

            private void validate(String User, String Pas) {
                if ((User.equals("me")) && (Pas.equals("no"))) {
                    Intent intent = new Intent(MainActivity.this,MainMenu.class);
                    startActivity(intent);
                } else {
                    counter--;
                    Info.setText( "No of attempts reamaining: " + String.valueOf(counter));
                    Warn.setText( "Please enter a valid username and password");
                    if (counter == 0) {
                        Login.setEnabled(false);
                    }
                }
            }
        }
