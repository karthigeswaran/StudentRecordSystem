package com.karthi.studentRecordManagementSystem;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class Student {
    private String name;
    private String clss;
    private ArrayList<String> resultIdList;
    
    public Student(String n, String c,ArrayList<String> eno){
        name = n;
        clss = c;
        resultIdList = eno;
    }

    public Student(String n, String c){
        name = n;
        clss = c;
        resultIdList = new ArrayList<>();
    }

    void setName(String n){
        name = n;
    }

    String getName(){
        return name;
    }

    void setClss(String c){
        clss = c;
    }

    String getClss(){
        return clss;
    }

    public boolean addResultId(String exno){
        if(!resultIdList.contains(exno)){
            resultIdList.add(exno);
            return true;
        }
        return false;
    }

    public boolean removeResultId(String exno){
        if(!resultIdList.contains(exno)){
            resultIdList.remove(exno);
            return true;
        }
        return false;
    }

    public void setResultIdList(ArrayList<String> exno){
        resultIdList = exno;
    }

    public ArrayList<String> getResultIds(){
        return resultIdList;
    }

    public String toString(){
        return "Name = "+name+"\n Class = "+clss+"\n Exam resultId = "+resultIdList.toString();
    }

    public boolean equals(Student student){
        if(name.equals(student.getName())&&clss.equals(student.getClss())&&resultIdList.equals(student.getResultIds())){
            return true;
        }
        return false;
    }

    public JSONObject toJson(){
        JSONObject stud = new JSONObject();
        stud.put("Name",name);
        stud.put("Class",clss);
        stud.put("Result ID", new JSONArray(resultIdList));
        return stud;
    }
    
}
