package smoke_regression;

import java.util.logging.Logger;

import org.testng.annotations.BeforeTest;

import baseUtil.APIGETBaseTest;
import io.restassured.path.json.JsonPath;

public class APIGetTest extends APIGETBaseTest {
	
	private static String GET_URL_PATH = null;
	private static final Logger log = LoggerFactory.getLogger(APIGetTest.class);
	private HttpUtil httputil = new HttpUtil();
	private JSONParser parser = new JsonPath();
	private long totalCost = 0;
	

	public APIGetTest(Logger log, String baseUrl) {
		super(log, baseUrl);
		
	}
	
	@BeforeTest
	public void setup() {
		getBaseUrl();
	}
	
	//Valid startDate, Valid numberOfDays
	
	public void testPositive_ValidateTotalCostforValidstartDateAndValidnumberOfDays() {
		GetTheGETEndpointResponseforTotalCosts("02-10-2019", 12);
		
	}
	
	//numberOfDays = 1
	public void testPositive_ValidateTotalCostforMinnumberOfDays() {
		GetTheGETEndpointResponseforTotalCosts("02-10-2019", 1);
		
	}
	
	//numberOfDays = 365
	public void testPositive_ValidateTotalCostforMaxnumberOfDays() {
		GetTheGETEndpointResponseforTotalCosts("02-10-2019", 365);
		
	}	
	
	//Invalid date format
	public void testNegative_ValidateTotalCostResponseForInvalidDateFormat() {
		GetTheGETEndpointResponseforTotalCosts("2019-09-12", 365);
	}
	
	//Boundary value for numberOfDays
	public void testNegative_ValidateTotalCostResponseFornumberOfDaysgreaterThan365() {
		GetTheGETEndpointResponseforTotalCosts("02-10-2019", 366);
				
	}
	//Boundary value for numberOfDays
	public void testNegative_ValidateTotalCostResponseFornumberOfDayslessThan1() {
		GetTheGETEndpointResponseforTotalCosts("02-10-2019", 0);
				
	}
	
	//Invalid date format
	public void testNegative_ValidateTotalCostResponseForInvalidDate() {
		GetTheGETEndpointResponseforTotalCosts("21-11-2019", 15);

	}
}
