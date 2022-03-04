package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DailyAttendance extends AppCompatActivity {
    //ArrayList<String> selection = new ArrayList<String>();
    private FirebaseDatabase Database;
    private DatabaseReference Reference_Attendance;
    private RecyclerView mRecyclerView1;
    private Button  Save;
    private Button Back;
private CheckBox breakfast;
private CheckBox lunch;
private CheckBox dinner;
private String status;
private EditText date;
TextView meal_Status;
    private ArrayList<String> choice= new ArrayList<String>();
    // private ImageAdapter imageAdapter;
   // private DatabaseReference mDatabaseRef;
    //    private List<AddMenu> muploads;
    private RecycleView_Config.StudentAdpater mAttendanceAdapter;
    /*public int getIndex_Spinner_Item(android.widget.Spinner spinner, String item){
        int index=0;
        for(int i=0;i<spinner.getCount();i++){
            if(spinner.getItemAtPosition(i).equals(item)){
                index=i;
                break;
            }
        }
        return index;
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
status=getIntent().getStringExtra("Status");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_attendance);
      meal_Status =(TextView)findViewById(R.id.mealStatus);
        this.setTitle("Daily Attendance");
        date = (EditText)findViewById(R.id.Date);
        breakfast = (CheckBox) findViewById(R.id.breakfast);
        lunch = (CheckBox) findViewById(R.id.lunch);
        dinner= (CheckBox) findViewById(R.id.dinner);
        //final_text=(TextView)findViewById(R.id.final_result);
        mRecyclerView1 = (RecyclerView) findViewById(R.id.recycler1);
        //mRecyclerView.setAdapter(mAttendanceAdapter);
        mRecyclerView1.setHasFixedSize(true);
        mRecyclerView1.setLayoutManager(new LinearLayoutManager(this));
        Save = (Button) findViewById(R.id.save);
        Back = (Button) findViewById(R.id.goback);
        /*private int getIndex_Spinner_Item(android.widget.Spinner spinner, String item){
        int index=0;
        for(int i=0;i<spinner.getCount();i++){
            if(spinner.getItemAtPosition(i).equals(item)){
                index=i;
                break;
            }
        }
        return index;
    }*/

        /*new FirebaseDatabaseHelper().updateStudent1();*/
Save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
if(breakfast.isChecked()){


}
        AttendanceTable attendance = new AttendanceTable();
//        attendance.setBreakfast(spinner.getItemAtPosition(1).toString().trim());
  //      attendance.setLunch(spinner2.getItemAtPosition(1).toString().trim());
    //    attendance.setDinner(spinner3.getItemAtPosition(1).toString().trim());
        attendance.setDate(date.getText().toString().trim());

        new FirebaseDatabaseHelper().updateStudent1(attendance, new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<StudentTable> students, List<String> keys) {

            }

            @Override
            public void DataIsInserted() {
                //Toast.makeText(DailyAttendance.this, "The Students daily Attendance has " + "been inserted successfully.", Toast.LENGTH_LONG).show();
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
           //     Toast.makeText(DailyAttendance.this, "The Students daily Attendance has " + "been inserted successfully.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void DataIsLoaded1(List<AttendanceTable> students, List<String> keys) {

            //Toast.makeText(DailyAttendance.this, "The Students daily Attendance has " + "been inserted successfully.", Toast.LENGTH_LONG).show();
            }
        });
    }
});
        //      muploads = new ArrayList<AddMenu>();
        //  mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");

//        mDatabaseRef.addValueEventListener(new ValueEventListener() {
        //          @Override
        //        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        //          for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
        //            AddMenu upload = postSnapshot.getValue(AddMenu.class);
//muploads.add(upload);


/*mAdapter = new ImageAdapter(DailyAttendance.this, muploads);
mRecyclerView.setAdapter(mAdapter);
  */
        //  }
//
        //          @Override
        //        public void onCancelled(@NonNull DatabaseError databaseError) {
        //          Toast.makeText(DailyAttendance.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
        //    }
        //});

        new FirebaseDatabaseHelper().readAttendances(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<StudentTable> students, List<String> keys) {

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
            public void DataIsLoaded1(List<AttendanceTable> attendances, List<String> keys) {
                findViewById(R.id.loading_students2).setVisibility(RecyclerView.GONE);
                new RecycleView_Config2().setConfig(mRecyclerView1, DailyAttendance.this, attendances, keys);
            }
        });
       // String Key = getIntent().getStringExtra("key");
        // mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Users").child(Key);

       /* Save.setOnClickListener(new View.OnClickListener() {
            AttendanceTable Attendance=  new AttendanceTable();

                                    @Override
                                    public void onClick(View v) {
                                        new FirebaseDatabaseHelper().updateStudent1(Key, Attendance, new FirebaseDatabaseHelper.DataStatus() {


                                            @Override
                                            public void DataIsLoaded(List<StudentTable> students, List<String> keys) {

                                            }

                                            @Override
                                            public void DataIsInserted() {
                                                Toast.makeText(DailyAttendance.this, "The Students Attendance record has " + "been inserted successfully.", Toast.LENGTH_LONG).show();
                                            }

                                            @Override
                                            public void DataIsUpdated() {

                                            }

                                            @Override
                                            public void DataIsDeleted() {

                                            }

                                            @Override
                                            public void DataIsLoaded1(List<AttendanceTable> students, List<String> keys) {
                                                findViewById(R.id.loading_students2).setVisibility(RecyclerView.GONE);
                                                new RecycleView_Config2().setConfig(mRecyclerView, DailyAttendance.this, students, keys);
                                            }
                                        });
                                    }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); return;
            }
        });
            }

   public void selectItem(View view){
boolean checked = ((CheckBox) view).isChecked();

        if(checked){
            selection.add("Yes");
        }
        else{
            selection.remove("Yes");
            selection.add("no");
        }


        if(checked){
            selection.add("Yes");
        }
        else{
            selection.remove("Yes");
            selection.add("no");
        }

        if(checked){
            selection.add("Yes");
        }
        else{
            selection.remove("Yes");
            selection.add("no");
        }

    }

      public boolean OnCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.daily_attendance_menu, menu);
                return super.onCreateOptionsMenu(menu);
            }

            public boolean onOptionsItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.new_attendance:
                        startActivity(new Intent(this, DailyAttendance.class));
                        return true;
                }
                return super.onOptionsItemSelected(item);
            }
*/
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); return;
            }
        });
    }

    public void final_seletion(View view) {
    }
}




