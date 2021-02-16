package study.serialization;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

/**
 * This program demonstrates how to get size of a particular file on a
 * FTP server, using Apache Commons Net API.
 *
 * @author www.codejava.net
 *
 */
public class Main {

//	public static void main(String[] args) throws IOException {
//		Member member = new Member("김배민", "deliverykim@baemin.com", 25);
//		byte[] serializedMember;
//		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
//			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
//				oos.writeObject(member);
//				// serializedMember -> 직렬화된 member 객체
//				serializedMember = baos.toByteArray();
//			}
//		}
//		// 바이트 배열로 생성된 직렬화 데이터를 base64로 변환
//		System.out.println(Base64.getEncoder().encodeToString(serializedMember));
//	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 직렬화 예제에서 생성된 base64 데이터
		String base64Member =
		        "rO0ABXNyAAp0LmEuTWVtYmVyAAAAAAAAAAECAARJAANhZ2VMAAVlbWFpbHQAEkxqYXZhL2xhbmcvU3RyaW5nO0wABG5hbWVxAH4AAUwABXBob25lcQB+AAF4cAAAABl0ABZkZWxpdmVyeWtpbUBiYWVtaW4uY29tdAAJ6rmA67Cw66+8cA==";
		byte[] serializedMember = Base64.getDecoder().decode(base64Member);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				// 역직렬화된 Member 객체를 읽어온다.
				Object objectMember = ois.readObject();
				Member member = (Member) objectMember;
				System.out.println(member);
			}
		}
	}
}
