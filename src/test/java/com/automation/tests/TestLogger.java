package com.automation.tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestLogger implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Optional: do something at test start
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        // Optional: before any test runs
    }

    @Override
    public void onFinish(ITestContext context) {
        // Optional: after all tests complete
    }
}
