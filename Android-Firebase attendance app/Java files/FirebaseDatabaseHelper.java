package com.example.myapplication;


import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceStudents;
    private DatabaseReference mReferenceAttendance;
    private List<StudentTable> students= new ArrayList< >();
    private List<AttendanceTable> attendances= new ArrayList< >();

    public void updateStudent1(AttendanceTable attendance, DataStatus dataStatus) {
    }

    public interface DataStatus{
         void DataIsLoaded(List<StudentTable> students, List<String> keys);
        void DataIsInserted();
    void DataIsUpdated ();
    void DataIsDeleted ();
        void DataIsInserted1();
        void DataIsUpdated1 ();
        void DataIsLoaded1(List<AttendanceTable> students, List<String> keys);
    }


    public FirebaseDatabaseHelper(){
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceStudents =mDatabase.getReference("Student");
        mReferenceAttendance =mDatabase.getReference("Attendance");
    }
    public void readAttendances(final DataStatus dataStatus1){
        mReferenceAttendance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
                attendances.clear();
                List<String> key= new ArrayList<>();
                for(DataSnapshot KeyNode: dataSnapshot1.getChildren()){
                    key.add(KeyNode.getKey());
                    AttendanceTable attendance =(AttendanceTable) KeyNode.getValue(AttendanceTable.class);
                    attendances.add(attendance);
                }
                dataStatus1.DataIsLoaded1(attendances,key);
               // Log.d("key","print");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void readStudents(final DataStatus dataStatus){
       mReferenceStudents.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               students.clear();
               List<String> keys = new ArrayList();
               for (DataSnapshot keyNode : dataSnapshot.getChildren()) {
                   keys.add(keyNode.getKey());
                  StudentTable student = (StudentTable) keyNode.getValue(StudentTable.class);
              students.add(student);
               }
            dataStatus.DataIsLoaded(students,keys);
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });
    }
    public void addStudent (StudentTable student, final DataStatus dataStatus){
        String key = mReferenceStudents.push().getKey();
        mReferenceStudents.child(key).setValue(student).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsInserted();

            }
        });

    }
public void updateStudent(String key,StudentTable student, final DataStatus dataStatus) {
    mReferenceStudents.child(key).setValue(student).addOnSuccessListener(new OnSuccessListener<Void>() {
        @Override
        public void onSuccess(Void aVoid) {
            dataStatus.DataIsUpdated();
        }
    });
}
  public void deleteStudent(String key,final DataStatus dataStatus){
      mReferenceStudents.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
          @Override
          public void onSuccess(Void aVoid) {
              dataStatus.DataIsDeleted();
          }
      });

}
    public void addStudent1 (AttendanceTable attendance, final DataStatus dataStatus1){
        String key = mReferenceAttendance.push().getKey();
        mReferenceAttendance.child(key).setValue(attendance).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus1.DataIsInserted1();

            }
        });

    }
    public void updateStudent1(String key,AttendanceTable attendance, final DataStatus dataStatus1) {

        mReferenceAttendance.child(key).setValue(attendance).addOnSuccessListener(new OnSuccessListener<Void>() {

            @Override
            public void onSuccess(Void aVoid) {
                dataStatus1.DataIsUpdated1();
            }
        });
    }
    public void deleteStudent1(String key,final DataStatus dataStatus1){

        mReferenceAttendance.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus1.DataIsDeleted();
            }
        });

    }
}
