package com.demoweb.shop.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Defines the file path where the HTML report will be saved
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentSparkReport.html";
            
            // Initialize the Spark Reporter
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            
            // Configure report appearance and metadata
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Demo Web Shop Automation Report");
            sparkReporter.config().setReportName("Regression & Functional Test Execution Results");
            sparkReporter.config().setEncoding("UTF-8");

            // Attach reporter and set system environment details for recruiters/reviewers
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Application", "Demo Web Shop");
            extent.setSystemInfo("Operating System", "Windows 11");
            extent.setSystemInfo("User Name", "Raj Kori");
            extent.setSystemInfo("Framework", "Selenium + TestNG + POM");
        }
        return extent;
    }
}