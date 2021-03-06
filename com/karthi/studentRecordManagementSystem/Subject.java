package com.karthi.studentRecordManagementSystem;

import org.json.simple.JSONObject;

public class Subject {
    private String name;
    private Integer mark;
    
    public Subject(String n, int m){
            name = n;
            mark = m;
    }
    
    void setName(String n){
        name = n;
    }
    
    String getName(){
        return name;
    }
    
    void setMarks(int m){
        mark = m;
    }
    
    int getMarks(){
        return mark;
    }
    
    public String toString(){
        return "SubjectName = "+name+"   Marks = "+mark;
    }
     
    public boolean equals(Subject subject){
        if(name.equals(subject.getName())&&mark==subject.getMarks()){
            return true;
        }
        return false;
    }

    public JSONObject toJson(){
        JSONObject subjectJson = new JSONObject();
        subjectJson.put("Name",name);
        subjectJson.put("Mark",mark);
        return subjectJson;
    }
}
