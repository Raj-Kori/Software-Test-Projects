package com.demoweb.shop.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestListener implements ITestListener {
    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // Getter so other classes can access the current test if needed
    public static ExtentTest getTest() {
        return test.get();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);

        // Automatically captures and logs test data parameters if your test uses them
        Object[] parameters = result.getParameters();
        if (parameters != null && parameters.length > 0) {
            StringBuilder dataLog = new StringBuilder("Test Data Used: ");
            for (Object param : parameters) {
                dataLog.append("[").append(param).append("] ");
            }
            extentTest.info(dataLog.toString().trim());
        }
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed Successfully");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
    }
}