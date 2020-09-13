package com.karthi.studentRecordManagementSystem.appscreens;

import java.util.Scanner;

import com.karthi.studentRecordManagementSystem.Result;
import com.karthi.studentRecordManagementSystem.Subject;

import java.awt.Toolkit;

public class UpdateResultScreen extends BaseScreen {
    private static final String DISPLAY_INFO = "1)Change name\n2)Add subject\n3)Update subject\n4)Delete subject\n5)Save and Exit\n6)Exit\nOption: ";

    public UpdateResultScreen(Scanner scan, AppContext appContext) {
        super(scan, DISPLAY_INFO, appContext);
    }

    @Override
    protected void run() {
        Result result = appContext.getResult();
        boolean fg = true;
        while(fg){
            System.out.println("Enter options:");
            switch(scanner.nextInt()){
                case 1:
                    changeName(result);
                    break;
                case 2:
                    addSubject(result);
                    break;
                case 3:
                    updateSubject(result);
                    break;
                case 4:
                    deleteSubject(result);
                    break;
                case 5:
                    appContext.getResultRecord()
                    .updateResult(appContext.getResultID(),result);
                    fg = false;
                    break;
                case 6:
                    fg =false;
                    break;
                default:
                    Toolkit.getDefaultToolkit().beep();
            }
        }
    }

    private void addSubject(Result result) {
        System.out.print("Subject name: ");
        String subjectName = scanner.next();
        System.out.print("Marks: ");
        Integer marks = scanner.nextInt();
        Subject subject = new Subject(subjectName,marks);
        result.addSubject(subject);
    }

    private void changeName(Result result) {
        System.out.print("Name: ");
        String name = scanner.next();
        result.setName(name);
    }

    private void updateSubject(Result result) {
        System.out.print("Subject name: ");
        String subjectName = scanner.next();
        System.out.print("Marks: ");
        Integer marks = scanner.nextInt();
        Subject subject = new Subject(subjectName,marks);
        if(result.hasSubject(subject)){
            result.updateSubject(subject);
            System.out.println("Update sucessfull");
        }
    }

    private void deleteSubject(Result result) {
        System.out.print("Subject Name: ");
        String subjectName = scanner.next();
        if(result.removeSubject(subjectName)){
            System.out.println("Successfully deleted");
        }else{
            System.out.println("Unable to delete");
        }
    }
    
}
