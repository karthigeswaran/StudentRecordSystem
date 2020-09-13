package com.karthi.studentRecordManagementSystem.appscreens;

import java.util.Scanner;

import com.karthi.studentRecordManagementSystem.Result;
import com.karthi.studentRecordManagementSystem.Student;
import com.karthi.studentRecordManagementSystem.StudentRecord;

public class StudentScreen extends BaseScreen {
    private final static String DISPLAY_INFO = "Your information";

    public StudentScreen(Scanner scan,  AppContext appContext) {
        super(scan, DISPLAY_INFO, appContext);
    }

    @Override
    protected void run() {
        StudentRecord studentRecord = appContext.getStudentRecord();
        Student student  = studentRecord.fetchStudent(appContext.getStudentID());
        System.out.println(student);
        while(true){
            System.out.println("Enter exam result id from your info: /'exit' to close: ");
            String input = scanner.next();
            if(input.equals("exit")){
                return;
            }
            Result result = appContext.getResultRecord().fetchResult(input);
            if(result==null){
                System.out.println("No exam results found.");
            }else{
                System.out.println(result);
            }
        }
    }

}
