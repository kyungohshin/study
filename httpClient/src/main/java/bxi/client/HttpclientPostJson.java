package bxi.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 24. initial creation
 *          일반 post 요청
 */
public class HttpclientPostJson {

	public static void sendPost(String url, Object header, Object body) throws ClientProtocolException, IOException {

		// post 메서드와 URL 설정
		HttpPost httpPost = new HttpPost(url);

		// 해더 정보 설정
//		httpPost.addHeader("User-Agent", USER_AGENT);
		httpPost.addHeader("Content-type", "application/json");

		StringBuilder json = new StringBuilder();
		json.append("{");
		json.append("\"EduSystemHeader\":");
		json.append("{");
		json.append("\"stdMsgLen\":126,");
		json.append("\"stdMsgVer\":1,");
		json.append("\"guid\":\"3d321690fbb145f993780bc51d9f2c59\",");
		json.append("\"guidSeq\":1,");
		json.append("\"fstGuid\":\"3d321690fbb145f993780bc51d9f2c59\",");
		json.append("\"trtInstCd\":\"020\",");
		json.append("\"msgClssCd\":\"S\",");
		json.append("\"itfcId\":\"AP_TO_DB_INTERFACE03\"");
		json.append("},");
		json.append("\"APtoDBreq\":");
//		json.append("{");
//		json.append("\"id\":\"9999\",");
//		json.append("\"name\":\"abc\",");
//		json.append("\"password\":\"123\"");
//		json.append("}");
//		json.append("}");

		ObjectMapper mapper = new ObjectMapper();
		String bodyJson = mapper.writeValueAsString(body);
		json.append(bodyJson);
		json.append("}");

		// 바디 정보 설정
		httpPost.setEntity(new StringEntity(json.toString()));

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
//		final String user_agent = "Mozila/5.0";
		final String url = "http://www.google.com";
		final Object header = "";
		HashMap<String, Object> map = new HashMap<>();
		map.put("id", "9999");
		map.put("name", "abc");
		map.put("password", "123");
		final Object body = map;
		HttpclientPostJson.sendPost(url, header, body);
	}
}
