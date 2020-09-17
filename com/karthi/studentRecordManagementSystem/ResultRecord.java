package com.karthi.studentRecordManagementSystem;

import java.util.ArrayList;

import com.karthi.dataStores.RecordManager;
import com.karthi.dataStores.Record;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;

public class ResultRecord {
    private String filename = "C:\\Users\\karthigeswaran\\Desktop\\practise\\java\\Student Record management\\com\\karthi\\studentRecordManagementSystem\\lib\\Result";
    RecordManager resultRecord = new RecordManager(filename);

    public boolean addResult(String exId,Result result){
        Record rec = new Record(exId,result.toJson().toString());
        return resultRecord.createNewRecord(rec);
    }

    public boolean deleteResult(String exId){
        return resultRecord.deleteRecord(exId);
    }

    public boolean updateResult(String exId,Result result){
        Record rec = new Record(exId,result.toJson().toString());
        return resultRecord.updateRecord(rec);
    }

    public Result fetchResult(String exId){
        Record rec = resultRecord.fetchRecord(exId);
        String value = rec.getValue();
        Result result = toResult(value);
		return result;
    }

    private  Result toResult(String s){
        JSONObject resultJson = (JSONObject)JSONValue.parse(s);
        ArrayList<Subject> subjectList = new ArrayList<Subject>();
        JSONArray subjectArray = (JSONArray)resultJson.get("subjects");
        String name = (String)resultJson.get("Name");
		for(Object object : subjectArray){
            JSONObject subjectJson = (JSONObject)object;
            String subjectName = (String)subjectJson.get("Name");
            Integer mark = ((Long)subjectJson.get("Mark")).intValue();
            Subject subject = new Subject(subjectName, mark);
            subjectList.add(subject);
        }
        return new Result(name, subjectList);
    }
}
