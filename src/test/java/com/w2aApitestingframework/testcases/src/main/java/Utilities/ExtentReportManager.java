package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportManager {

	public static ExtentReports report;

	// To initialize the htmlReporter and attach an object of extent report class
	// with it and return the object
	public static ExtentReports getReportInstance() {

		if (report == null) {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "//test_out//" + UniqueNameHelper.getTimeStamp() + ".html");
			report = new ExtentReports();
			report.attachReporter(htmlReporter);

			report.setSystemInfo("Operating System", "Windows 11");
			report.setSystemInfo("Environment", "UAT");
			report.setSystemInfo("OS Build", "22621.1105");
			report.setSystemInfo("Browser", "Chrome");

			htmlReporter.config().setDocumentTitle("UAT UI Automation Results - Finding Hospitals (Practo.com)");
			htmlReporter.config().setReportName("");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		}
		return report;
	}

}
