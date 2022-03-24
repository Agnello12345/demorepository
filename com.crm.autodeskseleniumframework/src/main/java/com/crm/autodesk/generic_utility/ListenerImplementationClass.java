package com.crm.autodesk.generic_utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;


public class ListenerImplementationClass implements ITestListener
{
	public void onTestStart(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"========>starts");
	}

	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"========>execution succesfull");
	}

	public void onTestFailure(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"========>execution failed");
		System.out.println(result.getThrowable());
	try {
	String path = new WebDriver_Utility().takeScreenshot(BaseClass.sDriver, methodName);
	System.out.println(path);

	} 
	catch (Throwable e) 
	{
		e.printStackTrace();
	}
	}
    public void onTestSkipped(ITestResult result) 
	{
    	String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"========>execution skipped");
		System.out.println(result.getThrowable());
		}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		}

	public void onTestFailedWithTimeout(ITestResult result) {
		}

	public void onStart(ITestContext context) 
	{
		System.out.println("suite execution started");
		}
	public void onFinish(ITestContext context) 
	{
		System.out.println("execution finished");
	}
}
