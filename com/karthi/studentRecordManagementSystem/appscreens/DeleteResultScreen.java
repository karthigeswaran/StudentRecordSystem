package com.karthi.studentRecordManagementSystem.appscreens;

import java.util.Scanner;

import com.karthi.studentRecordManagementSystem.ResultRecord;
import com.karthi.studentRecordManagementSystem.Student;

public class DeleteResultScreen extends BaseScreen {

    private static final String DISPLAY_INFO = "Enter Result ID";
    public DeleteResultScreen(Scanner scan, AppContext appContext) {
        super(scan, DISPLAY_INFO, appContext);
    }

    @Override
    protected void run() {
        String resultID = scanner.next();
        ResultRecord resultRecord = appContext.getResultRecord();
        boolean isResultDeleted = resultRecord.deleteResult(resultID);
        Student student = appContext.getStudent();
        student.removeResultId(resultID);
        boolean isStudentUpdated = appContext.getStudentRecord().updateStudent(appContext.getStudentID(), student);
        if(isResultDeleted && isStudentUpdated){
            System.out.println("Delete success");
        } else {
            System.out.println("Unable to delete");
        }
    }

}
