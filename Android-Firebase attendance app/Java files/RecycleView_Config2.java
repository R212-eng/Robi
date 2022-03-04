package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleView_Config2  {


    private Context mContext;

    private AttendanceAdapter mAttendanceAdapter;
    public void setConfig(RecyclerView recyclerView1, Context context1, List<AttendanceTable> attendance, List<String> key) {
        mContext = context1;
        // mContext1 = context;
        mAttendanceAdapter = new AttendanceAdapter(attendance, key);
        // mStudentsAdapter1= new StudentAdpater(Student,keys);
        recyclerView1.setLayoutManager(new LinearLayoutManager(context1));
        recyclerView1.setAdapter(mAttendanceAdapter);
    }

    class AttendanceItemView extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mId;
        private TextView mDept;
        private ImageView imageView;
        private TextView mBfast;
        private TextView mDinner;
        private TextView mLunch;
        private CheckBox CheckBox1;
        private CheckBox CheckBox2;
        private CheckBox CheckBox3;
        private String key;
        private TextView mDate;
        private TextView mMealNo;
        public ArrayList<String> selection= new ArrayList<String>();
        public AttendanceItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.student_attendace_list, parent, false));
            Log.d(this.key,"now");
            mName = (TextView) itemView.findViewById(R.id.name_txtV2);
            mId = (TextView) itemView.findViewById(R.id.id_txtV2);
            mDept = (TextView) itemView.findViewById(R.id.Dept_txtV2);
            mMealNo=(TextView)itemView.findViewById(R.id.meal_txtV3);
            mBfast = (TextView) itemView.findViewById(R.id.MealB2);
            mLunch = (TextView) itemView.findViewById(R.id.MealL2);
            mDinner=(TextView)itemView.findViewById(R.id.MealD2);
            CheckBox1=(CheckBox)itemView.findViewById(R.id.breakfast);
            CheckBox2=(CheckBox)itemView.findViewById(R.id.lunch);
            CheckBox3=(CheckBox)itemView.findViewById(R.id.dinner);
            // imageView=(ImageView)itemView.findViewById(R.id.imageView4);

            //mDate= (TextView)itemView.findViewById(R.id.Date);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, UpdateAndDelete.class);
                    intent.putExtra("key", key);
                    intent.putExtra("Name", mName.getText().toString());
                    intent.putExtra("Id", mId.getText().toString());
                    intent.putExtra("Dep", mDept.getText().toString());
                   intent.putExtra("MealNo",mMealNo.getText().toString());
                 //   intent.putExtra("Date",mDate.getText().toString());
//intent.putExtra("ImgView",imageView

                    mContext.startActivity(intent);
                }
            });
        }


        public void blind(AttendanceTable attendance, String key) {
            mName.setText(attendance.getName());
            mId.setText(attendance.getId_Number());
            mDept.setText(attendance.getDepartment());
//            mDate.setText(attendance.getDate());
            mMealNo.setText(String.valueOf(attendance.getMealNo()));
           /* mBfast.setText("Breakfast");
            mLunch.setText("Lunch");
            mDinner.setText("Dinner");
            spinner1.getSelectedItem().toString();
            spinner2.getSelectedItem().toString();
            spinner3.getSelectedItem().toString();
*/
            this.key = key;

        }
    }

    class AttendanceAdapter extends RecyclerView.Adapter<AttendanceItemView> {
        private List<AttendanceTable> mAttendanceList;
        private List<String> mkeys;
        //private List<Integer> MealN;
        public AttendanceAdapter(List<AttendanceTable> mAttendanceList, List<String> mkeys) {
            this.mAttendanceList = mAttendanceList;
            this.mkeys = mkeys;

        }

        @NonNull
        @Override
        public AttendanceItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AttendanceItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull AttendanceItemView holder, int position) {
            holder.blind(mAttendanceList.get(position), mkeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mAttendanceList.size();
        }
    }
}

