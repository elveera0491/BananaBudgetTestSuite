package baseUtil;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import javax.xml.ws.Response;

import core.TestMetadata;
import core.TestUtils;

public class APIGETBaseTest {
	
	private Logger log ;
	private String baseUrl;
	private MediaType baseMediaType = MediaType.APPLICATION_OCTET_STREAM;
	
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public APIBaseTest(Logger log) {
		
	}
	public APIGETBaseTest(Logger log, String baseUrl) {
		this.baseUrl = baseUrl;
		this.log = log;
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		
		//testClass Before Method
		printHeader(method);
		
	}
	
	public void afterMethod(Method method, ITestResult result) {
		printFooter(method);
		executeZephyrTest(result, method);  //enable to update zephyr tests
		
	}
	
	
	private void printHeader(Method method) {
		// TODO Auto-generated method stub
		
		TestMetadata testMetadata = method.getAnnotation(TestMetadata.class);
		String jira = null;
		String title = null;
		if (null != testMetadata) {
			title = method.getName();
		}
		if (null == jira) {
			jira = "JIRA-#: not defined. Use @TestMetadata";
		}
		printHeader(jira, title);
	}
	
	private void printHeader(String jira, String title) {
		// TODO Auto-generated method stub
		
		System.out.println("");
		System.out.println("/*#########################*/");
		System.out.println("Started Test case...");
		System.out.println(" " + jira);
		System.out.println(" " + title);
		System.out.println("/*#########################*/");
		
	}
	
	private void printFooter(Method method) {
		// TODO Auto-generated method stub
		
		TestMetadata testMetadata = method.getAnnotation(TestMetadata.class);
		String jira = null;
		String title = null;
		if (null != testMetadata) {
			title = StringUtils.stripToNull(testMetadata.title());
			if (null == jira) {
				title = method.getName();
			}
			printFooter(title);
		}
	}

	
	private void printFooter(String title) {
		// TODO Auto-generated method stub
		
		System.out.println("");
		System.out.println("/*#########################*/");
		System.out.println("Finished Test case...");
		
		System.out.println(" " + title);
		System.out.println("/*#########################*/");
		
	}
	
	public Response runTests(String url, String jira, String title, HttpMethod httpMethod, 
								MediaType mediaType, String filename, String validationMethod) {
		Response response = null;
		try {
			log.info("");
			if (null != title) {
				printHeader(jira, title);
				
			}
			System.out.println(x);
			System.out.println(" Http Method: " + httpMethod.toString());
			System.out.println(" MediaType: " + mediaType.toString());
			System.out.println(" Filename: " + filename);
			System.out.println();
			
			response = TestUtils.run(url, httpMethod, mediaType, filename);
			if (null != validationMethod) {
				callValidationMethod(response, validationMethod);
			}
		}catch (Exception e) {
			log.error("fail", e);
			if (null != e.getCause()) {
				Assert.fail("Fail " + e.getCause().getMessage(), e);
			}else {
				Assert.fail("Fail " + e.getMessage(), e);
			}
		} finally {
			if(null != title) {
				printFooter(title);
			}
			System.out.println();
			
		}
		return response;
		
	}
	
	public Response GetTheGETEndpointResponseforTotalCosts(String startDate, int numberOfDays) {
		Response response = null;
		String baseUrl = null;
		baseUrl= "https://bananabudget.azurewebsites.net/?startDate=startDate&numberOfDays=numberOfDays"
		try {
			response = run(baseUrl, HttpMethod.GET, null);
			response.then().statusCode(200);
			TestUtils.print(response);
			
			JsonPath jsonPath = new JsonPath(response.asString());
			response.then().statusCode(200);
		}catch(Exception e) {
			log.error("Fail", e);
			Assert.fail("Fail", e);
		}finally {
			System.out.println("GET response" + response);
		}
		return response;
		
	}

	
	
	
	
	
	

}
