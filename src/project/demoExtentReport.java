package project;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import common.general;

public class demoExtentReport extends general {
	private static final String CODE1 = "{\n    \"theme\": \"standard\",\n    \"encoding\": \"utf-8\n}";
	private static final String CODE2 = "{\n    \"protocol\": \"HTTPS\",\n    \"timelineEnabled\": false\n}";

	@Test
	public void report() {
		ExtentReports extent = new ExtentReports(); // declare using extend report
		ExtentSparkReporter spark = new ExtentSparkReporter("./report/automation.html"); //point the report to the folder
		extent.attachReporter(spark); // Trinh quan ly report

		extent.createTest("ScreenCapture").addScreenCaptureFromPath("extent.png")
				.pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());

		extent.createTest("LogLevels").info("info").pass("pass").warning("warn").skip("skip").fail("fail");

		extent.createTest("CodeBlock").generateLog(Status.PASS, MarkupHelper.createCodeBlock(CODE1, CODE2));

		extent.createTest("ParentWithChild").createNode("Child")
				.pass("This test is created as a toggle as part of a child test of 'ParentWithChild'");

		extent.createTest("Tags").assignCategory("MyTag")
				.pass("The test 'Tags' was assigned by the tag <span class='badge badge-primary'>MyTag</span>");

		extent.createTest("Authors").assignAuthor("TheAuthor")
				.pass("This test 'Authors' was assigned by a special kind of author tag.");

		extent.createTest("Devices").assignDevice("TheDevice")
				.pass("This test 'Devices' was assigned by a special kind of devices tag.");

		extent.createTest("Exception! <i class='fa fa-frown-o'></i>")
				.fail(new RuntimeException("A runtime exception occurred!"));

		extent.flush(); // save report
	}

}
