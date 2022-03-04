package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    private Button AddStudent;
    //private Button StudentReport;
    private Button DailyAttendance;
    private Button StudentProfile;
    private Button StudentReport;
    private Button Back;
    private android.view.Menu Menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        this.setTitle("Main Menu");
        AddStudent = (Button) findViewById(R.id.button4);
        StudentReport = (Button) findViewById(R.id.button5);
        DailyAttendance= (Button) findViewById(R.id.button6);
        StudentProfile= (Button) findViewById(R.id.button7);
        Back =(Button) findViewById(R.id.button3);

        /*public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.class, i);
            return true;
        }*/
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);


            }
        });
        AddStudent.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainMenu.this,AddMenu.class);
        startActivity(intent);
    }
});
        DailyAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this,DailyAttendance.class);
                //intent.putExtra("key", "Attendance");
                startActivity(intent);
            }
        });
        StudentProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this,StudentProfile.class);
                startActivity(intent);
            }
        });
        StudentReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, StudentReport.class);
                startActivity(intent);
            }
        });
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

