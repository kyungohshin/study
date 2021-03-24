package bxi.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 24. initial creation
 *          get요청보내기 자동닫기
 */
public class HttpclientGetAutoClose {

	private static final String USER_AGENT = "Mozila/5.0";
//	private static final String USER_AGENT = "PostmanRuntime/7.26.10";
	private static final String GET_URL = "http://google.com";

	public static void sendGet() throws ClientProtocolException, IOException {
		// get 메서드와 URL 설정
		HttpGet httpGet = new HttpGet(GET_URL);

		// agent 정보 설정
		httpGet.addHeader("User-Agent", USER_AGENT);
		httpGet.addHeader("Content-type", "application/json");

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
		        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);) {
			System.out.println("::GET Response Status::");

			// response의 status 코드 출력
			System.out.println(httpResponse.getProtocolVersion()); // HTTP/1.1
			System.out.println(httpResponse.getStatusLine().getStatusCode()); // 200
			System.out.println(httpResponse.getStatusLine().getReasonPhrase()); // OK
			System.out.println(httpResponse.getStatusLine().toString()); // HTTP/1.1 200 OK

			String json = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
			System.out.println(json);
		}

	}

	public static void main(String args[]) throws ClientProtocolException, IOException {
		HttpclientGetAutoClose.sendGet();
	}
}
