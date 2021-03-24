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
public class HttpclientGet {

	private static final String USER_AGENT = "Mozila/5.0";
//	private static final String USER_AGENT = "PostmanRuntime/7.26.10";
	private static final String GET_URL = "http://www.google.com";

	public static void sendGet() throws ClientProtocolException, IOException {

		// http client 생성
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// get 메서드와 URL 설정
		HttpGet httpGet = new HttpGet(GET_URL);

		// agent 정보 설정
		httpGet.addHeader("User-Agent", USER_AGENT);
		httpGet.addHeader("Content-type", "application/json");

		// get 요청
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

		System.out.println("::GET Response Status::");

		// response의 status 코드 출력
		System.out.println(httpResponse.getStatusLine().getStatusCode());

		String json = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

//		BufferedReader reader = new BufferedReader(new InputStreamReader(
//		        httpResponse.getEntity().getContent()));
//
//		String inputLine;
//		StringBuffer response = new StringBuffer();
//
//		while ((inputLine = reader.readLine()) != null) {
//			response.append(inputLine);
//		}
//		reader.close();

		// Print result
//		System.out.println(response.toString());

		System.out.println(json);
		httpClient.close();

	}

	public static void main(String args[]) throws ClientProtocolException, IOException {
		HttpclientGet.sendGet();
	}
}
