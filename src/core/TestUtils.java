package core;

public class TestUtils {

	private static final Logger log = Loggerfactory.getLogger(TestUtils.class);
	
	public static Response run (String url, HttpMethod httpMethod, MediaType mediaType, String requestFilename, Map<String, Object> header, String jsonRequestString, Map<String, String> duplicateCheck, Map<String, String> basicAuth) throws Exception {
		{
			RequestSpecification request = null;
			if (httpMethod.equals(HttpMethod.GET)) {
				request = given().relaxedHTTPSValidation("TLSv1.2")
						.log().all()
			} else {
				request = given().relaxedHTTPSValidation("TLSv1.2")
						.log().all()
						.contentType(mediaType.toString());
			}
		}
	}
}
