package com.karthi.studentRecordManagementSystem.appscreens;

import java.util.ArrayList;
import java.util.Scanner;

import com.karthi.studentRecordManagementSystem.Result;
import com.karthi.studentRecordManagementSystem.ResultRecord;
import com.karthi.studentRecordManagementSystem.Student;
import com.karthi.studentRecordManagementSystem.StudentRecord;

public class CreateStudentScreen extends BaseScreen {
    private static final String DISPLAY_INFO = "Enter Student information below\n";


    public CreateStudentScreen(Scanner scan, AppContext appContext) {
        super(scan, DISPLAY_INFO, appContext);
        
    }

    @Override
    protected void run() {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter class: ");
        String clss = scanner.next();
        Student student = new Student(name, clss);
        appContext.setStudent(student);
        System.out.print("Enter no. of exams attended: ");
        int resultSize = getInteger();
        for(int i=0; i<resultSize; i++){
            CreateResultScreen createResultScreen = new CreateResultScreen(scanner, appContext);
            createResultScreen.runScreen();
        } 
        ArrayList<Result> resultList = appContext.getResultList();
        System.out.print("Save student?(press 'y' to save/anyother key to exit): ");
        if(scanner.next().equals("y")){
            StudentRecord studentRecord = appContext.getStudentRecord();
            ResultRecord resultRecord = appContext.getResultRecord();
            ArrayList<String> resultIDList = student.getResultIds();
            studentRecord.addStudent(appContext.getStudentID(),appContext.getStudent());
            for(int i=0; i<resultIDList.size();i++){
                resultRecord.addResult(resultIDList.get(i),resultList.get(i));
            }
        }else{
            appContext.setStudent(null);
            appContext.setResult(null);
            appContext.setStudentID(null);
            appContext.setResultID(null);
            resultList.clear();
        }
    }

}
