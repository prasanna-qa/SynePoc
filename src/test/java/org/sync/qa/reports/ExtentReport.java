package org.sync.qa.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {
	public static ExtentReports extent;
	static ThreadLocal<ExtentReports> extentreport=new ThreadLocal<ExtentReports>();
	public static File pathOfReports;
	
	public static ExtentReports getInstance()
	{
		return extent;
	}

	public static void initReports() {
		
		pathOfReports = new File(System.getProperty("user.dir") + "\\reports\\"+System.currentTimeMillis()+"\\index.html");
		ExtentSparkReporter reporter = new ExtentSparkReporter(pathOfReports);
		try {
			reporter.loadXMLConfig(new File("extent.xml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		try {
			extent.setSystemInfo("Tester", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
			}
		}
		
	

	public static void flush() {
		if(Objects.nonNull(extent)) {
		extent.flush();}
		try {
			Desktop.getDesktop().browse(pathOfReports.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static void createTest(String testcaseName)
	{
		ExtentReport.extentreport.set(getInstance());
		extent=extentreport.get();
		 ExtentTest test=extent.createTest(testcaseName);
		 ExtentManager.setExtentTest(test);
	}

}
