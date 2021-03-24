package bxi.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 24. initial creation
 *          일반 post 요청
 */
public class HttpclientPost {

	private static final String USER_AGENT = "Mozila/5.0";
//	private static final String USER_AGENT = "PostmanRuntime/7.26.10";
	private static final String GET_URL = "https://httpbin.org/post";

	public static void sendPost() throws ClientProtocolException, IOException {

		// post 메서드와 URL 설정
		HttpPost httpPost = new HttpPost(GET_URL);

		// agent 정보 설정
		httpPost.addHeader("User-Agent", USER_AGENT);
		httpPost.addHeader("Content-type", "application/json");

		// add request parameters or form parameters
		List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("username", "abc"));
		urlParameters.add(new BasicNameValuePair("password", "123"));
		urlParameters.add(new BasicNameValuePair("custom", "secret"));

		httpPost.setEntity(new UrlEncodedFormEntity(urlParameters));

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
		        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);) {
			System.out.println("::POST Response Status::");
			System.out.println(httpResponse.getStatusLine().getStatusCode()); // 200
			System.out.println(httpResponse.getStatusLine().getReasonPhrase()); // OK
			String result = EntityUtils.toString(httpResponse.getEntity());
			System.out.println(result);
		}

	}

	public static void main(String args[]) throws ClientProtocolException, IOException {
		HttpclientPost.sendPost();
	}
}
