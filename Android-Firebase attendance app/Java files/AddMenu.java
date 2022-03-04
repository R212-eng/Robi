package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.List;

public class AddMenu extends AppCompatActivity implements View.OnClickListener {
    Uri FilePathUri;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    int Image_Request_Code = 7;
    ProgressDialog progressDialog;
    private Button Register;
    public ImageButton Choose;
    private EditText MealN;
    private EditText Name;
    private ImageView imgview;
    private EditText Id;
    private EditText Dep;
    private Button Update;
    private String key;
    private TextView InfoBox;
    public final int ImgReq = 1;
    // private Spinner Spinner;
    private Bitmap bitmap;
    //private Button Back;
    private String Name1;
    private String Id1;
    private String Dep1;
    private Button Upload;
    private EditText txtdata;
    private String ImName;
    private TextView Meal;
    private long j = 0;
    private int MealNo1;
    private long mno = 0;
    StudentTable studentTable;
    AttendanceTable attendanceTable;
    private int m;
    private String mId;
    private String mName;
    private String mDept;
    private String mMealNo;
    private String Textdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);
        storageReference = FirebaseStorage.getInstance().getReference("Images");
        databaseReference = FirebaseDatabase.getInstance().getReference("Images");
        studentTable = new StudentTable();
        attendanceTable=  new AttendanceTable();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    j = (dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        this.setTitle("Add Menu");
        /*Name1 = getIntent().getStringExtra("Name");
        Id1 = getIntent().getStringExtra("Id");
        Dep1 = getIntent().getStringExtra("Dep");
        ImName =getIntent().getStringExtra("ImName");*/
        //key = getIntent().getStringExtra("key");

//        Log.i("key", key);
        // key = "key";
        /*mName = Name.getText().toString();
        mId = Id.getText().toString();
        mDept = Meal.getText().toString();
        mMealNo= Meal.getText().toString();*/
        try {
            Name = (EditText) findViewById(R.id.Name_edit);
            //Name.setText(Name1);
            Id = (EditText) findViewById(R.id.Id_edit);
            //Id.setText(Id1);
            Dep = (EditText) findViewById(R.id.Dept_edit);
            //Dep.setText(Dep1);
            Meal = (EditText) findViewById(R.id.meal_num);

            //Meal.setText(MealNo1);
            InfoBox = (TextView) findViewById(R.id.InfoBox);
            //Spinner = (Spinner)findViewById(R.id.spinner);
            Register = (Button) findViewById(R.id.add);
            Choose = (ImageButton) findViewById(R.id.choose);
            imgview = (ImageView) findViewById(R.id.imageView);
            //Back = (Button) findViewById(R.id.Back);
            //Update = (Button) findViewById(R.id.update);
            Upload = (Button) findViewById(R.id.button2);
            txtdata = (EditText) findViewById(R.id.ImageName);
            txtdata.setText(ImName);
          //  progressDialog = new ProgressDialog(AddMenu.this);// context name as per your project name


            Choose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select Image"), Image_Request_Code);

                }
            });
            Upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    UploadImage();

                }
            });

            Register.setOnClickListener(v -> {

                try {
                    StudentTable student = new StudentTable();
                    AttendanceTable attendance =new AttendanceTable();
                    attendance.setName(Name.getText().toString().trim());
                    attendance.setId_Number(Id.getText().toString().trim());
                    attendance.setDepartment(Dep.getText().toString().trim());
                    attendance.setTxtdata(txtdata.getText().toString().trim());
                    attendance.setMealNo(Meal.getText().toString());
                    student.setName(Name.getText().toString().trim());
                    student.setId_Number(Id.getText().toString().trim());
                    student.setDepartment(Dep.getText().toString().trim());
                    student.setTxtdata(txtdata.getText().toString().trim());
                    student.setMealNo(Meal.getText().toString());
                    m = Integer.parseInt(Meal.getText().toString());

//databaseReference.child(String.valueOf(j+1)).setValue("student");
                    new FirebaseDatabaseHelper().addStudent1(attendance, new FirebaseDatabaseHelper.DataStatus() {
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
                           Toast.makeText(AddMenu.this, "The Student record has " + "been inserted successfully." + "Your Meal Number is:" + m, Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void DataIsUpdated1() {

                        }

                        @Override
                        public void DataIsLoaded1(List<AttendanceTable> students, List<String> keys) {

                        }
                    });
                    new FirebaseDatabaseHelper().addStudent(student, new FirebaseDatabaseHelper.DataStatus() {
                        @Override
                        public void DataIsLoaded(List<StudentTable> students, List<String> keys) {

                        }

                        @Override
                        public void DataIsInserted() {

                            Toast.makeText(AddMenu.this, "The Student record has " + "been inserted successfully." + "Your Meal Number is:" + m, Toast.LENGTH_LONG).show();
/*
}*/
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
                    });

                } catch (NumberFormatException e) {
                    Toast.makeText(AddMenu.this, "Invalid meal number. Meal number should be a positive integer", Toast.LENGTH_SHORT).show();
                }
            });
            /*Back.setOnClickListener(v -> {
                finish();
                return;
            });*/

        } catch (NullPointerException e) {
            Toast.makeText(AddMenu.this, "Dear user, Please fill all the required fields.", Toast.LENGTH_SHORT).show();
        }


   /* @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.choose:
                selectImage();
            break;
            case R.id.upload:
                uploadImage();
                break;


        }
    }*/
    /*private void uploadImage(){
StringRequest stringRequest= new StringRequest(Request.Method.POST, );

}*/
/*private String imageToString(Bitmap bitmap){
    ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
            byte[] imgBytes = byteArrayOutputStream.toByteArray();
            return Base64.encodeToString(imgBytes,Base64.DEFAULT);
}
}*/
 /*   private void selectImage () {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, ImgReq);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImgReq && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                imgView.setImageBitmap(bitmap);
                imgView.setVisibility(View.VISIBLE);
                Name.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }}
*/
    }

        @Override
        public void onClick (View v){

        }
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){

            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == Image_Request_Code && resultCode == RESULT_OK && data != null && data.getData() != null) {

                FilePathUri = data.getData();

                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), FilePathUri);
                    imgview.setImageBitmap(bitmap);
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }


        public String GetFileExtension (Uri uri){

            ContentResolver contentResolver = getContentResolver();
            MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
            return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));

        }


        public void UploadImage () {

            if (FilePathUri != null) {

                //progressDialog.setTitle("Image is Uploading...");
                //progressDialog.show();
                StorageReference storageReference2 = storageReference.child(System.currentTimeMillis() + "." + GetFileExtension(FilePathUri));
                storageReference2.putFile(FilePathUri)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                String TempImageName = txtdata.getText().toString().trim();
//                                progressDialog.dismiss();
                                Toast.makeText(getApplicationContext(), "Image Uploaded Successfully ", Toast.LENGTH_LONG).show();
                                @SuppressWarnings("VisibleForTests")
                                uploadinfo imageUploadInfo = new uploadinfo(TempImageName, taskSnapshot.getUploadSessionUri().toString());
                                String ImageUploadId = databaseReference.push().getKey();
                                databaseReference.child(ImageUploadId).setValue(imageUploadInfo);
                            }
                        });
            } else {

                Toast.makeText(AddMenu.this, "Please Select Image or Add Image Name", Toast.LENGTH_LONG).show();

            }
        }

    }



