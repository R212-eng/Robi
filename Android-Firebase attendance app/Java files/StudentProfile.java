package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentProfile extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        this.setTitle("Student profile");
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        new FirebaseDatabaseHelper().readStudents(new FirebaseDatabaseHelper.DataStatus() {
                                                      @Override
                                                      public void DataIsLoaded(List<StudentTable> students, List<String> keys) {
                                                          findViewById(R.id.loading_students).setVisibility(RecyclerView.GONE);
                                                          new RecycleView_Config().setConfig(mRecyclerView, StudentProfile.this, students, keys);
                                                      }

                                                      @Override
                                                      public void DataIsInserted() {

                                                      }

                                                      @Override
                                                      public void DataIsUpdated() {

                                                      }

                                                      @Override
                                                      public void DataIsDeleted() {

                                                      }

            @Override
            public void DataIsInserted1() {

            }

            @Override
            public void DataIsUpdated1() {

            }

            @Override
                                                      public void DataIsLoaded1(List<AttendanceTable> students, List<String> keys) {

                                                      }
                                                  }
        );
    }





}

