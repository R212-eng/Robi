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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.List;

public class UpdateAndDelete extends AppCompatActivity {
    private Button Delete;
    private Button Update;
    public ImageButton Choose;
    private EditText mName;
    private ImageView imgView;
    private EditText mId;
    private EditText mDep;
 private String mealN;
    private TextView InfoBox;
    private String ImName;
    public final int ImgReq=1;
    private android.widget.Spinner Spinner;
    private Bitmap bitmap;
    private Button Back;
    private String key;
    private String Name;
    private String Id;
    private String Dep;
    private EditText mMeal;
    ProgressDialog progressDialog ;
    Uri FilePathUri;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    private EditText txtdata;
    private Button Upload;
    int Image_Request_Code = 7;
   // private String Gender;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_student);
        storageReference = FirebaseStorage.getInstance().getReference("Images");
        databaseReference = FirebaseDatabase.getInstance().getReference("Images");
        key= getIntent().getStringExtra("key");
        Name = getIntent().getStringExtra("Name");
        Id= getIntent().getStringExtra("Id");
        Dep= getIntent().getStringExtra("Dep");
        ImName =getIntent().getStringExtra("ImName");
        mealN= getIntent().getStringExtra("MealNo");
        //Gender=getIntent().getStringExtra("Gender");
        mName = (EditText)findViewById(R.id.Name_edit);
        mName.setText(Name);
        mName = (EditText)findViewById(R.id.Name_edit);
        mName.setText(Name);
        mId = (EditText)findViewById(R.id.Id_edit);
        mId.setText(Id);
        mDep = (EditText)findViewById(R.id.Dept_edit);
        mDep.setText(Dep);
        mMeal=(EditText)findViewById(R.id.meal_num);
        mMeal.setText(mealN);
        InfoBox = (TextView)findViewById(R.id.InfoBox);
        txtdata=(EditText)findViewById(R.id.ImageName);
        txtdata.setText(ImName);
        Upload =(Button) findViewById(R.id.button2);
        //Spinner = (android.widget.Spinner)findViewById(R.id.spinner);
        //Spinner.setSelection(getIndex_Spinner_Item(Spinner,Gender));

        Update = (Button)findViewById(R.id.update);
        Choose = (ImageButton)findViewById(R.id.choose);
        imgView = (ImageView)findViewById(R.id.imageView);
        Back = (Button)findViewById(R.id.Back);
        Delete = (Button)findViewById(R.id.delete);
        progressDialog = new ProgressDialog(UpdateAndDelete.this);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentTable student= new StudentTable();
                AttendanceTable attendance= new AttendanceTable();
                attendance.setName(mName.getText().toString());
                attendance.setId_Number(mId.getText().toString());
                attendance.setDepartment(mDep.getText().toString());
                attendance.setMealNo(mMeal.getText().toString());
                student.setName(mName.getText().toString());
                student.setId_Number(mId.getText().toString());
                student.setDepartment(mDep.getText().toString());
                student.setMealNo(mMeal.getText().toString());
                new FirebaseDatabaseHelper().updateStudent1(key, attendance, new FirebaseDatabaseHelper.DataStatus() {
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
                        Toast.makeText(UpdateAndDelete.this,"Student record has been " +
                                "updated successfully",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsLoaded1(List<AttendanceTable> students, List<String> keys) {

                    }
                });
                new FirebaseDatabaseHelper().updateStudent(key, student, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<StudentTable> students, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(UpdateAndDelete.this,"Student record has been " +
                                "updated successfully",Toast.LENGTH_LONG).show();
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
            }
        });
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

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseHelper().deleteStudent1(key, new FirebaseDatabaseHelper.DataStatus() {
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
                        Toast.makeText(UpdateAndDelete.this,"Student record has been " +
                                "deleted successfully",Toast.LENGTH_LONG).show();
                        finish();return;

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
                new FirebaseDatabaseHelper().deleteStudent(key, new FirebaseDatabaseHelper.DataStatus() {
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
                        Toast.makeText(UpdateAndDelete.this,"Student record has been " +
                                "deleted successfully",Toast.LENGTH_LONG).show();
                        finish();return;
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
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();return;
            }
        });
    }
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
    public void onClick(View v) {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Image_Request_Code && resultCode == RESULT_OK && data != null && data.getData() != null) {

            FilePathUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), FilePathUri);
                imgView.setImageBitmap(bitmap);
            }
            catch (IOException e) {

                e.printStackTrace();
            }
        }
    }


    public String GetFileExtension(Uri uri) {

        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri)) ;

    }


    public void UploadImage() {

        if (FilePathUri != null) {

            progressDialog.setTitle("Image is Uploading...");
            progressDialog.show();
            StorageReference storageReference2 = storageReference.child(System.currentTimeMillis() + "." + GetFileExtension(FilePathUri));
            storageReference2.putFile(FilePathUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            String TempImageName = txtdata.getText().toString().trim();
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Image Uploaded Successfully ", Toast.LENGTH_LONG).show();
                            @SuppressWarnings("VisibleForTests")
                            uploadinfo imageUploadInfo = new uploadinfo(TempImageName, taskSnapshot.getUploadSessionUri().toString());
                            String ImageUploadId = databaseReference.push().getKey();
                            databaseReference.child(ImageUploadId).setValue(imageUploadInfo);
                        }
                    });
        }
        else {

            Toast.makeText(UpdateAndDelete.this, "Please Select Image or Add Image Name", Toast.LENGTH_LONG).show();

        }
    }



}
