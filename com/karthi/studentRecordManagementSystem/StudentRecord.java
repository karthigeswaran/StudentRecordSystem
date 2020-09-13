package com.karthi.studentRecordManagementSystem;

import java.util.ArrayList;

import com.karthi.dataStores.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

public class StudentRecord {
    private String filename = "C:\\Users\\karthigeswaran\\Desktop\\practise\\java\\Student Record management\\com\\karthi\\studentRecordManagementSystem\\lib\\Student";
    RecordManager studentRecord = new RecordManager(filename);
    

    public boolean addStudent(String sId,Student student){
        Record rec = new Record(sId,student.toJson().toString());
        return studentRecord.createNewRecord(rec);
    }

    public boolean deleteStudent(String sId){
        return studentRecord.deleteRecord(sId);
    }

    public boolean updateStudent(String sId,Student student){
        Record rec = new Record(sId,student.toJson().toString());
        return studentRecord.updateRecord(rec);
    }

    public Student fetchStudent(String sId){
        Record rec = studentRecord.fetchRecord(sId);
        if(rec != null) {
          return toStudent(rec.getValue());
        }
        return null;
    }

    private Student toStudent(String jsonString){
        JSONObject studJson = (JSONObject)JSONValue.parse(jsonString);
        String name = (String)studJson.get("Name");
        String clss = (String)studJson.get("Class");
        JSONArray resultIdJson = (JSONArray)studJson.get("Result ID");
        ArrayList<String> resultId = new ArrayList<>();
        resultId.addAll(resultIdJson);
        return new Student(name,clss,resultId);
    }
}
