package com.karthi.studentRecordManagementSystem.appscreens;

import java.util.Scanner;
import java.util.ArrayList;

import com.karthi.studentRecordManagementSystem.Result;
import com.karthi.studentRecordManagementSystem.Student;
import com.karthi.studentRecordManagementSystem.Subject;

public class CreateResultScreen extends BaseScreen {
    private static final String DISPLAY_INFO = "Enter Exam result information\n";
    
    public CreateResultScreen(Scanner scan, AppContext appContext) {
        super(scan, DISPLAY_INFO, appContext);
    }

    @Override
    protected void run() {
        String id = appContext.getStudentID();
        Student student = appContext.getStudent();
        int size = student.getResultIds().size();
        id += size;
        student.addResultId(id);
        System.out.print("Enter exam name: ");
        String examName = scanner.next();
        System.out.print("Enter no. of subjects: ");
        Integer subjectSize = getInteger();
        ArrayList<Subject> subjectList = new ArrayList<>();
        for(int i=0; i<subjectSize; i++){
            System.out.print("Subject Name: ");
            String subjectName = scanner.next();
            System.out.print("Marks: ");
            Integer marks = getInteger();
            Subject subject = new Subject(subjectName,marks);
            subjectList.add(subject);
        }
        Result result = new Result(examName,subjectList);
        ArrayList<Result> resultList = appContext.getResultList();
        resultList.add(result); 
    }

}
