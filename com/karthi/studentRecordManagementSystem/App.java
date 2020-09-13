package com.karthi.studentRecordManagementSystem;

import java.util.Scanner;

import com.karthi.studentRecordManagementSystem.appscreens.AppContext;
import com.karthi.studentRecordManagementSystem.appscreens.MainScreen;

public class App{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AppContext appContext = new AppContext();
		MainScreen mainScreen = new MainScreen(scanner,appContext);
		mainScreen.runScreen();
		scanner.close();
	}

}