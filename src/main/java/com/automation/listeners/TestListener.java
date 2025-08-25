package com.automation.listeners;

import com.automation.reports.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().fail("Test Failed: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip("Test Skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports
        ExtentReportManager.initReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush ExtentReports
        ExtentReportManager.flushReports();
    }
}