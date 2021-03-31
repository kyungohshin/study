package study.objectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 31. initial creation
 */
public class JsonToObject {
	// json String -> Object 역직렬화
	public void jsonStringToObject() throws JsonGenerationException, JsonMappingException, IOException {
		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		ObjectMapper objectMapper = new ObjectMapper();
		Car car = objectMapper.readValue(json, Car.class);
	}

	// json file -> Object 역직렬화
	public void jsonFileToObject() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Car car = objectMapper.readValue(new File("src/test/resources/json_car.json"), Car.class);
	}

	// json url -> Object 역직렬화
	public void jsonUrlFileToObject() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Car car = objectMapper.readValue(new URL("file:src/test/resources/json_car.json"), Car.class);
	}

	// json String -> jackson 역직렬화
	public void jsonStringToJackson() throws JsonGenerationException, JsonMappingException, IOException {
		String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(json);
		String color = jsonNode.get("color").asText();
		System.out.println(color);
	}

	// json String -> LIST 역직렬화
	public void jsonStringToList() throws JsonGenerationException, JsonMappingException, IOException {
		String jsonCarArray =
		        "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
		ObjectMapper objectMapper = new ObjectMapper();
		List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>() {});
		System.out.println(listCar);
	}

	// json String -> LIST 역직렬화
	public void jsonStringToMap() throws JsonGenerationException, JsonMappingException, IOException {
		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
		System.out.println(map);
	}

	public static void main(String[] args) throws Exception {
		JsonToObject m = new JsonToObject();
		m.jsonStringToObject();
//		m.jsonFileToObject();
//		m.jsonUrlFileToObject();
		m.jsonStringToJackson();
		m.jsonStringToList();
	}
}
