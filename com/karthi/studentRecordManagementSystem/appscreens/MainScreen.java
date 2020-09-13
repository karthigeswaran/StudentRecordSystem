package com.karthi.studentRecordManagementSystem.appscreens;

import java.util.Scanner;
import java.awt.Toolkit;

public class MainScreen extends BaseScreen {
    private static final String DISPLAY_INFO = "Student Record Management Software.\nMAIN MENU.\n"
    +"1.Admin Credentials(to Edit files)\n2.Student login\n3.Exit";
    private final String PASSWORD = "ADMIN";
    
    public MainScreen(Scanner scan,AppContext appContext) {
        super(scan, DISPLAY_INFO, appContext); 
    }
 
    @Override
    protected void run() {
        boolean runFlag = true;
        while(runFlag){
            System.out.print("Enter your option: ");
            int option = scanner.nextInt();
            switch(option){
                case 1:
                    System.out.print("Enter password: ");
                    String pwd = scanner.next();
                    if(pwd.equals(PASSWORD)){
                        AdminScreen adminScreen = new AdminScreen(scanner,appContext);
                        adminScreen.runScreen();
                    }else{
                        System.out.println("Password Incorrect");
                    }    
                    break;
                case 2:
                    System.out.print("Enter Register number: ");
                    appContext.setStudentID(scanner.next());
                    StudentScreen studentScreen = new StudentScreen(scanner, appContext);
                    studentScreen.runScreen();
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
