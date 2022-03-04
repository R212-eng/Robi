package com.example.myapplication;

public class StudentTable {
    private String Name;
    private String Id_Number;
    private String Department;
    private String Txtdata;
    private String MealNo;

    public StudentTable(String name, String id_Number, String department, String imName, String mealNo) {
        Name = name;
        Id_Number = id_Number;
        Department = department;
        Txtdata = imName;
        MealNo= mealNo;

    }

    public StudentTable() {
    }

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
