package com.karthi.studentRecordManagementSystem.appscreens;

import java.util.ArrayList;
import java.util.Scanner;

import com.karthi.studentRecordManagementSystem.Result;
import com.karthi.studentRecordManagementSystem.ResultRecord;
import com.karthi.studentRecordManagementSystem.Student;
import com.karthi.studentRecordManagementSystem.StudentRecord;

import java.awt.Toolkit;

public class AccessStudentScreen extends BaseScreen {
    private static final String DISPLAY_INFO = "Student Information";

    public AccessStudentScreen(Scanner scanner, AppContext appContext) {
        super(scanner, DISPLAY_INFO, appContext);
    }

    @Override
    protected void run() {
        StudentRecord studentRecord = appContext.getStudentRecord();
        Student student = studentRecord.fetchStudent(appContext.getStudentID());
        appContext.setStudent(student);
        System.out.println(student);
        boolean runFlag = true;
		while(runFlag){
            System.out.print("1) Add new Exam Result\n2) Fetch Exam Result\n3) Delete Exam Result\n4) Save and exit\n5) Exit\n");
            System.out.print("Enter Option: ");
			switch(scanner.nextInt()){
				case 1:
                    CreateResultScreen createResultScreen = new CreateResultScreen(scanner, appContext);
                    createResultScreen.runScreen();
                    break;
                case 2:
                    FetchResultScreen fetchResultScreen = new FetchResultScreen(scanner, appContext);
                    fetchResultScreen.runScreen();
                    break;
				case 3:
                    DeleteResultScreen deleteResultScreen = new DeleteResultScreen(scanner, appContext);
                    deleteResultScreen.runScreen();
                    break;
                case 4:
                    ArrayList<Result> resultList = appContext.getResultList();
                    ArrayList<String> resultIDList = student.getResultIds();
                    ResultRecord resultRecord = appContext.getResultRecord();
                    for(int i=0; i<resultList.size(); i++){
                        resultRecord.updateResult(resultIDList.get(i), resultList.get(i));
                    }
                    studentRecord.updateStudent(appContext.getStudentID(), student);
                    clearAppContext();
                    runFlag = false;
                    break;
                case 5:
                    runFlag = false;
                    clearAppContext();
                    break;
				default:
					Toolkit.getDefaultToolkit().beep();
			}
		}
    }

    private void clearAppContext(){
        appContext.setStudent(null);
        appContext.setResult(null);
        appContext.setStudentID(null);
        appContext.getResultList().clear();
    }
    
}
