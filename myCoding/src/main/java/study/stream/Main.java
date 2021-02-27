package study.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 2. 27. initial creation
 */
public class Main {

	public void generate() {
		List<String> list = new ArrayList<>();
		Stream<String> s0 = list.stream(); // 컬렉션을 스트림으로 만드는방법
		Stream<String> s1 = list.parallelStream(); // 컬렉션을 스트림으로 만드는방법(병렬)

		String[] array = { "a", "b", "c" };
		Stream<String> s2 = Stream.of(array); // 배열을 스트림으로 만드는방법
		Stream<String> s3 = Arrays.stream(array); // 배열을 스트림으로 만드는방법

		Stream<String> s4 = Stream.empty(); // 비어있는 스트림 생성

		Stream<Integer> s5 = Stream.generate(() -> 12); // 상수를 스트림으로 만드는방법
	};

	public void test() {
		List<String> list = new ArrayList<>();
		list.add("asdfqwfewcesdf");
		list.add("2f2f23d");
		list.add("23csdvasg24gfsdcv");
		long count =
		        list.stream().map(String::toLowerCase).filter(w -> w.length() > 12).count();

		System.out.println(count);
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.test();
	}

}
