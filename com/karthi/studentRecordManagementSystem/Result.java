package com.karthi.studentRecordManagementSystem;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class Result {
    private String name;
    private ArrayList<Subject> subjectList;
    private int total=0;
    private float avg;
    
    public Result(String name,ArrayList<Subject> sub){
        this.name = name;
        subjectList = sub;
        setTotal();
        setAvg();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    private void setTotal(){
        for(Subject subject : subjectList){
            total += subject.getMarks();
        }
    }

    private void setAvg(){
        avg = (float)(total/subjectList.size());
    }

    public boolean search(String name){
        for(Subject sub : subjectList){
            if(sub.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public boolean addSubject(Subject subject){
        if(!search(subject.getName())){
            subjectList.add(subject);
            total+=subject.getMarks();
            setAvg();
            return true;
        }
        return false;
    }

    public boolean removeSubject(String name){
        for(Subject sub : subjectList){
            if(sub.getName().equals(name)){
                subjectList.remove(sub);
                return true;
            }
        }
        return false;
    }

    public boolean updateSubject(Subject subject){
        if(removeSubject(subject.getName())){
            subjectList.add(subject);
            return true;
        }
        return false;
    }

    public boolean hasSubject(Subject subject){
        for(Subject sub : subjectList){
            if(sub.equals(subject)){
                return true;
            }
        }
        return false;
    }


    void setSubjects(ArrayList<Subject> sub){
        subjectList = sub;
        setTotal();
        setAvg();
    }

    public ArrayList<Subject> getSubjects(){
        return subjectList;
    }

    public int getTotal(){
        return total;
    }
    
    public float getAvg(){
        return avg;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("");
        sb.append("Exam Name: ");
        sb.append(name);
        sb.append("\n");
        for(Subject s: subjectList){
            sb.append(s.toString());
        }
        sb.append("Total: ");
        sb.append(total);
        sb.append("\n");
        sb.append("Average: ");
        sb.append(avg);
        return sb.toString();
    }

    public boolean equals(Result result){
        if(name.equals(result.getName())&&subjectList.equals(result.getSubjects())){
            return true;
        }
        return false;
    }

    public JSONObject toJson(){
        JSONObject resultJson = new JSONObject();
        JSONArray subjectJson = new JSONArray();
        resultJson.put("Name",name);
        for(Subject subject : subjectList){
            subjectJson.add(subject.toJson());
        }
        resultJson.put("subjects",subjectJson);
        return resultJson;
    }

}
