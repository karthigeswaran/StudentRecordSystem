package com.karthi.studentRecordManagementSystem.appscreens;

import com.karthi.studentRecordManagementSystem.*;
import java.util.ArrayList;

public class AppContext {
    private String studentID;
    private Student student;
    private String resultID;
    private Result result;
    private StudentRecord studentRecord = new StudentRecord();
    private ResultRecord resultRecord = new ResultRecord();
    private ArrayList<Result> resultList = new ArrayList<>();
	
    public void setStudentID(String id){
        studentID = id;
    }

    public String getStudentID(){
        return studentID;
    }
    
    public void setStudent(Student student){
        this.student = student;
    }

    public Student getStudent(){
        return student;
    }
    
    public void setResultID(String id){
        resultID = id;
    }

    public String getResultID(){
        return resultID;
    }
    
    public void setResult(Result result){
        this.result = result;
    }

    public Result getResult(){
        return result;
    }
    
    public StudentRecord getStudentRecord(){
        return studentRecord;
    }

    public ResultRecord getResultRecord(){
        return resultRecord;
    }

    public ArrayList<Result> getResultList(){
        return resultList;
    }

}
