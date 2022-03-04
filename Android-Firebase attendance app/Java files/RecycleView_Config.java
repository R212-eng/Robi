package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleView_Config {
   // public static String KEY = "RECYCLER VIEW TEST";
    private Context mContext;
    private StudentAdpater mStudentsAdapter;
    private int i;


    //private Context mContext1;
    //private StudentAdpater mStudentsAdapter1;

    public void setConfig(RecyclerView recyclerView, Context context, List<StudentTable> Student, List<String> keys){
           mContext = context;
       // mContext1 = context;
           mStudentsAdapter= new StudentAdpater(Student,keys);
       // mStudentsAdapter1= new StudentAdpater(Student,keys);
           recyclerView.setLayoutManager(new LinearLayoutManager(context));
           recyclerView.setAdapter(mStudentsAdapter);

    }

    class StudentItemView extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mId;
        private TextView mDept;
        private String key;
        private TextView mMealNo;

        public StudentItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.student_list_item, parent, false));
            Log.d(this.key,"now");
            mName = (TextView) itemView.findViewById(R.id.Name_txtV);
            mId = (TextView) itemView.findViewById(R.id.Id_txtV);
            mDept = (TextView) itemView.findViewById(R.id.Dept_txtV);
            mMealNo=(TextView)itemView.findViewById(R.id.meal_txtV2);

            itemView.setOnClickListener(new View.OnClickListener()

            {

                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(mContext, UpdateAndDelete.class);
                    intent.putExtra("key",key);
                    intent.putExtra("Name", mName.getText().toString());
                    intent.putExtra("Id", mId.getText().toString());
                    intent.putExtra("Dep",mDept.getText().toString());
                   intent.putExtra("MealNo",mMealNo.getText().toString());
                    mContext.startActivity(intent);
                }
            });
        }
        public void blind(StudentTable student, String key){
            mName.setText(student.getName());
            mId.setText(student.getId_Number());
            mDept.setText(student.getDepartment());
            mMealNo.setText(String.valueOf(student.getMealNo()));
        this.key= key;

        }
    }
    class StudentAdpater extends RecyclerView.Adapter<StudentItemView>{
        private List<StudentTable> mStudentlList;
        private List<String> keys;

        public StudentAdpater(List<StudentTable> mStudentlList, List<String> keys) {

            this.mStudentlList = mStudentlList;
            this.keys = keys;
        }

        @NonNull
        @Override
        public StudentItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new StudentItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentItemView holder, int position) {
            holder.blind(mStudentlList.get(position), keys.get(position));
        }

        @Override
        public int getItemCount() {
            return mStudentlList.size();
        }
    }

}

