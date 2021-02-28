package study.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

	public void generate() {
		Stream<String> s0 = list.stream(); // 컬렉션을 스트림으로 만드는방법
		Stream<String> s1 = list.parallelStream(); // 컬렉션을 스트림으로 만드는방법(병렬)

		String[] array = { "a", "b", "c" };
		Stream<String> s2 = Stream.of(array); // 배열을 스트림으로 만드는방법
		Stream<String> s3 = Arrays.stream(array); // 배열을 스트림으로 만드는방법

		Stream<String> s4 = Stream.empty(); // 비어있는 스트림 생성

		Stream<Integer> s5 = Stream.generate(() -> 12); // 상수를 스트림으로 만드는방법
	};

	public void transform() {
		long count =
		        list.stream().map(String::toLowerCase).filter(w -> w.length() > 12).count();
		System.out.println(count);

		Stream<String> s1 = list.stream().map(String::toLowerCase);

		Stream<String> s2 = list.stream().filter(w -> w.length() > 12);

		Object[] s3 = Stream.iterate(1, p -> p * 2)
//		        .peek(System.out::println)
		        .limit(20).toArray();

		Stream<String> s4 = list.stream().limit(2); // 개수를 2개로 제한하여 스트림 리턴

		Stream<String> s5 = list.stream().skip(2); // 제일처음 2개를 빼고 스트림 리턴

		// 스트링 길이로 정렬
		Stream<String> longestFirst = list.stream().sorted(Comparator.comparing(String::length).reversed());
	}

	public void result() {
		Optional<String> s1 = list.stream().max(String::compareToIgnoreCase); // 최댓값 리턴

		Optional<String> s2 = list.stream().min(String::compareToIgnoreCase); // 최솟값 리턴

		// a로 시작하는 요소들중 첫번재로 일치하는 요소 리턴
		Optional<String> s3 = list.stream().filter(s -> s.startsWith("a")).findFirst();

		Optional<String> s4 = list.stream().parallel().filter(s -> s.startsWith("a")).findAny();

		boolean s5 = list.stream().parallel().anyMatch(s -> s.startsWith("a")); // 하나라도 predicate와
		                                                                        // 일치하는 요소가 있으면 true

		boolean s6 = list.stream().parallel().allMatch(s -> s.startsWith("a")); // 모든 요소가 predicate와
		                                                                        // 일치하면 true

		boolean s7 = list.stream().parallel().noneMatch(s -> s.startsWith("a")); // 모든 요소가
		                                                                         // predicate와
		                                                                         // 일치하지않으면 true
		System.out.println(s1.get());
		System.out.println(s5);
		System.out.println(s7);
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.setup();
		m.transform();
		m.result();
	}

}
