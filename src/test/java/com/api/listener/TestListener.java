package com.api.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.utils.LogManagerHelper;

public class TestListener implements ITestListener {
	
	
	@Override
    public void onTestStart(ITestResult result) {
        LogManagerHelper.info("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogManagerHelper.info("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogManagerHelper.error("Test Failed: " + result.getName());
        LogManagerHelper.error("Exception: " + result.getThrowable());
    }

	
	

}
