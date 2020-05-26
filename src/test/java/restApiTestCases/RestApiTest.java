package restApiTestCases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import restApiBase.TestBase;
import restApiClient.RestClient;

public class RestApiTest extends TestBase {
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;

	@BeforeMethod
	public void initialize() {
		testBase = new TestBase();
		serviceUrl = prop.getProperty("url");
		apiUrl = prop.getProperty("uri");
		url = serviceUrl + apiUrl;

	}

	@Test
	public void getCallTest() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		CloseableHttpResponse response = restClient.getUrl(url);
		// status code
		int status = response.getStatusLine().getStatusCode();
		System.out.println("Status code -->" + status);
		// json response
		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response Json -->" + responseJson);

		// to get all header value
		Header[] headersArray = response.getAllHeaders();
		HashMap<String, String> headerValues = new HashMap<String, String>();
		for (Header h : headersArray) {
			headerValues.put(h.getName(), h.getValue());
		}
		System.out.println("HeaderValues" + headerValues);
	}
}
