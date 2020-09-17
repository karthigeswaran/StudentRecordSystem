package com.karthi.studentRecordManagementSystem.appscreens;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class BaseScreen {
    private String displayInfo;
    protected Scanner scanner;
    protected AppContext appContext;

    public BaseScreen(Scanner scan, String displayInfo, AppContext appContext) {
        this.scanner = scan;
        this.displayInfo = displayInfo;
        this.appContext = appContext;
    }

    public void displayInformation() {
        if (displayInfo.equals("")) {
            throw new RuntimeException("displayInfo not set");
        }
        System.out.println(displayInfo);
    }
    
    protected void setDisplayInfo(String displayInfo) {
        this.displayInfo = displayInfo;
    }
    
    

    public void runScreen() {
        displayInformation();
        run();
    }

    protected Integer getInteger(){
        try{
            return scanner.nextInt();
        }catch(InputMismatchException e){
            System.out.print("Enter valid number.");
            scanner.nextLine();
            return getInteger();
        }
    }
    protected abstract void run(); 

}
