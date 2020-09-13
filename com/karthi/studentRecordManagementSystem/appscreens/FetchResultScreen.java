package com.karthi.studentRecordManagementSystem.appscreens;

import java.util.Scanner;

import com.karthi.studentRecordManagementSystem.Result;
import com.karthi.studentRecordManagementSystem.ResultRecord;

public class FetchResultScreen extends BaseScreen {

    private static final String DISPLAY_INFO = "Enter Result ID";

    public FetchResultScreen(Scanner scan, AppContext appContext) {
        super(scan, DISPLAY_INFO, appContext);
    }

    @Override
    protected void run() {
        String resultID = scanner.next();
        ResultRecord resultRecord = appContext.getResultRecord();
        Result result = resultRecord.fetchResult(resultID);
        if(result == null) {
            System.out.println("Invalid Result ID");
            return;
        }
        System.out.println(result);
        System.out.print("Update Result record?(y/n): ");
        if(scanner.next().equals("y")){
            appContext.setResult(result);
            appContext.setResultID(resultID);
            UpdateResultScreen updateResult = new UpdateResultScreen(scanner, appContext);
            updateResult.runScreen();
        }
        appContext.setResult(null);
        appContext.setResultID(null);
    }

}
