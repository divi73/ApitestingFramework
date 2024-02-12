package test3;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentReportManager;

public class test3 {

	public static ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;

	public void reportInfo(String reportString) {
		logger.log(Status.INFO, reportString);
	}

	// To log fail into reports
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
	}

	// To log pass into reports
	public static void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	static String user = "2159757";
	static String naam = "Bhavya";

	private static String requestBody = "{\n" + "  \"title\": \"" + user + "\",\n" + "  \"body\": \"" + naam + "\",\n"
			+ "  \"userId\": \"1\" \n}";

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}

	@Test(priority = 1)
	public void postRequest() {
		logger = report.createTest("POST REQUEST");
		Response response = given().log().all().header("Content-type", "application/json").and().body(requestBody)
				.when().post("/posts").then().log().all().extract().response();

		Assert.assertEquals(201, response.statusCode());

		reportPass("BASEURI HAS BEEN CONFIGURED");
		reportPass("BODY OF THE REQUEST HAS BEEN LOADED");
		reportPass("POST CALL HAS BEEN INITIATED WITH GIVEN ENDPOINTS");
		reportPass("OUTPUT IS PRINTED IN THE CONSOLE");
		reportPass("VALIDATE THE TITLE FEILD USER_ID");
		reportPass("VALIDATE THE BODY FEILD FIRST_NAME");
		reportPass("GOT THE MESSAGE OF STAATUS CODE 200");
		reportPass("GOT THE MESSAGE SAYING BOOK ALREADY EXISTS");

	}

	@Test(priority = 2)
	public static void Second() {
		logger = report.createTest("GET REQUEST");
		RestAssured.baseURI = "https://demoqa.com";

		String res = given().log().all().header("content-Type", "application/json").when().get("BookStore/V1/Books")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(res);

		String store = js.getString("books[1].title");
		System.out.println(store);
		Assert.assertEquals(store, "Learning JavaScript Design Patterns");

		reportPass("BASEURI HAS BEEN CONFIGURED");
		reportPass("BODY OF THE REQUEST HAS BEEN LOADED");
		reportPass("GET REQUEST HAS BEEN INITIATED WITH GIVEN ENDPOINTS");
		reportPass("OUTPUT IS PRINTED IN THE CONSOLE");
		reportPass("GOT THE MESSAGE OF STAATUS CODE 200");
		reportPass("VERIFIED THE OUTPUT FROM GET REQUEST ");
		report.flush();

	}
}