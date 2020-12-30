package com.testnegdemo.automation.realtimereport;

import java.io.File;
import java.util.Random;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testngdemo.automation.functional.TestSuitesBases;

public class TimeReport implements ITestListener {

	String file;
	File fileScreenshot;

	public void onFinish(ITestContext arg0) {
		System.out.println("END Of Execution(TEST)->" + arg0.getName());
	}

	public void onStart(ITestContext arg0) {

		System.out.println("Start Of Execution(TEST)->" + arg0.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult arg0) {

		file = System.getProperty("user.dir") + "//" + "Screenshoot" + (new Random().nextInt()) + ".png";

		try {
			fileScreenshot = TestSuitesBases.takeSnapShot(TestSuitesBases.getDriver(), file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test Failed->" + arg0.getName());

		Report_table report_table = new Report_table();
		report_table.Add_Report_voice(file);
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test Skipped->" + arg0.getName());
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("Test Started->" + arg0.getName());

	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Test Pass->" + arg0.getName());

	}

}
