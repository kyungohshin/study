package study.objectMapper;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 31. initial creation
 */
public class ObjectToJson {

	// Object -> json 직렬화 (파일에 쓰기)
	public void objectToJsonFile() throws JsonGenerationException, JsonMappingException, IOException {
		Car car = new Car("yellow", "renault");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File("C:\\Users\\USER\\Desktop\\coding\\gitHub\\myCoding\\car.json"), car);
		// car.json : {"color":"yellow","type":"renault"}
	}

	// Object -> json String 직렬화 (문자열)
	public void objectToJsonString() throws JsonGenerationException, JsonMappingException, IOException {
		Car car = new Car("yellow", "renault");
		ObjectMapper objectMapper = new ObjectMapper();
		String s = objectMapper.writeValueAsString(car);
		System.out.println(s);
	}

	// Object -> json Byte 직렬화 (문자열)
	public void objectToJsonByte() throws JsonGenerationException, JsonMappingException, IOException {
		Car car = new Car("yellow", "renault");
		ObjectMapper objectMapper = new ObjectMapper();
		byte[] b = objectMapper.writeValueAsBytes(car);
	}

	public static void main(String[] args) throws Exception {
		ObjectToJson m = new ObjectToJson();
		m.objectToJsonFile();
		m.objectToJsonString();
		m.objectToJsonByte();
	}
}
