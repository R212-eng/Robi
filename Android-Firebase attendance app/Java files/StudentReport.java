package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class StudentReport extends AppCompatActivity {

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_report);
        this.setTitle("Student Report");
        /*    TextView myLink = (TextView)findViewById(R.id.link);
            myLink.setMovementMethod(LinkMovementMethod.getInstance());*/

        }

    }
