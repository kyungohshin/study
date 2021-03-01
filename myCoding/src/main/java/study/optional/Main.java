package study.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 2. 27. initial creation
 */
public class Main {

	List<String> list = new ArrayList<>();

	public void setup() {
		list.add("affbasbd");
		list.add("bvbasbdasdabasb");
		list.add("acffbasbd1233f4321d");
	}

	public void test() {
		String string = "abc";
		Optional<String> val = list.stream().parallel().filter(s -> s.startsWith("a")).findAny();
		val.ifPresent(a -> list.add(a));
		Optional<Boolean> o1 = val.map(a -> list.add(a));

		val.ifPresent(v -> list.add(v)); // 리스트에 해당값을 추가할때
		val.ifPresent(list::add);

		String s1 = val.orElse(""); // optional 값이 있으면 그값, null이라면 ""값 리턴

		String s2 = val.orElseGet(() -> System.getProperty("user.dir")); // optional 값이 있으면 그값,
		                                                                 // null이라면 디폴트를 계산 후 리턴

		String s3 = val.orElseThrow(NoSuchElementException::new); // 값이없을떄 예외를 던짐

		System.out.println(val.get());
		System.out.println(val.orElse(""));

		Optional<Double> o2 = inverse(5.0).flatMap(Main::sqareRoot);
		Optional<Optional<Double>> o3 = inverse(5.0).map(Main::sqareRoot);

		System.out.println(o2.get());
	}

	public static Optional<Double> inverse(Double x) {
		return x == 0 ? Optional.empty() : Optional.of(1 / x);
	}

	public static Optional<Double> sqareRoot(Double x) {
		return x == 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
	}

	/* 주문을 한 회원이 살고 있는 도시를 반환한다 */
	public String getCityOfMemberFromOrder(Order order) {
//		return order.getMember().getAddress().getCity(); // NPE가 발생하는 매우 위험한 코드

//		if (order != null) { // NPE는 막아주지만 로직이 지저분해짐
//			Member member = order.getMember();
//			if (member != null) {
//				Address address = member.getAddress();
//				if (address != null) {
//					String city = address.getCity();
//					if (city != null) {
//						return city;
//					}
//				}
//			}
//		}
//		return "Seoul"; // default

//		Optional<Member> oa = Optional.of(order).map(Order::getMember);

		return Optional.ofNullable(order)
		        .map(v -> v.getMember()) // Optional<Member>로 바꿔서 리턴
		        .map(s -> s.getAddress()) // Optional<Address>로 바꿔서 리턴
		        .map(Address::getCity) // Optional<City>로 바꿔서 리턴
		        .orElse("Seoul"); // 이 문장으로 인해 리턴타입이 Optional<String>에서 String이 됨
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.setup();
		m.test();
	}

}
