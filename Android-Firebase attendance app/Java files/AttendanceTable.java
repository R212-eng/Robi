package com.example.myapplication;

public class AttendanceTable {
    private String Name;
    private String Id_Number;
    private String Department;
    private String Txtdata;
    private String MealNo;
    private String breakfast;
    private String lunch;
    private String dinner;
    private String Date;
    public AttendanceTable(String name, String id_Number, String department, String imName, String mealNo, String date) {
        Name = name;
        Id_Number = id_Number;
        Department = department;
        Txtdata = imName;
       MealNo= mealNo;
       Date=date;

    }

    public AttendanceTable() {
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    /* public String getDate() {
            return Date;
        }

        public void setDate(String date) {
            Date = date;
        }
    */
    public String getMealNo() {
        return MealNo;
    }

    public void setMealNo(String mealNo) {
        MealNo = mealNo;
    }

    public String getTxtdata() {
        return Txtdata;
    }

    public void setTxtdata(String txtdata) {
        Txtdata = txtdata;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId_Number() {
        return Id_Number;
    }

    public void setId_Number(String id_Number) {
        Id_Number = id_Number;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
