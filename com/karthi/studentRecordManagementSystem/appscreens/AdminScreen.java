package com.karthi.studentRecordManagementSystem.appscreens;

import java.util.Scanner;
import java.awt.Toolkit;

public class AdminScreen extends BaseScreen {
    private static final String DISPLAY_INFO = "1. Access student record\n2. Create new student record\n3.Exit";
    
    public AdminScreen(Scanner scanner,AppContext appContext) {
        super(scanner, DISPLAY_INFO, appContext);
    }

    @Override
    protected void run() {
        boolean runFlag = true;
		while(runFlag){
			System.out.print("Enter Option: ");
			switch(scanner.nextInt()){
                case 1:
                    System.out.print("Enter student ID: ");
                    appContext.setStudentID(scanner.next());
                    AccessStudentScreen accessStudentScreen = new AccessStudentScreen(scanner, appContext);
                    accessStudentScreen.runScreen();
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    appContext.setStudentID(scanner.next());
                    CreateStudentScreen createStudentScreen = new CreateStudentScreen(scanner, appContext);
                    createStudentScreen.runScreen();
                    break;
				case 3:
					runFlag = false;
					break;
				default:
					Toolkit.getDefaultToolkit().beep();
			}
		}
    }
    
}
