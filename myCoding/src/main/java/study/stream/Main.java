package study.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
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
	List<Person> list2 = new ArrayList<>();

	public void setup() {
		list.add("affbasbd");
		list.add("bvbasbdasdabasb");
		list.add("acffbasbd1233f4321d");
		list.add("msiens");
		list.add("msiena");
		list.add("msienb");

		Person p1 = Person.builder().id(1).name("shin").age(30).build();
		Person p2 = Person.builder().id(2).name("kim").age(21).build();
		Person p3 = Person.builder().id(3).name("kwon").age(53).build();
		Person p4 = Person.builder().id(4).name("shin").age(8).build();
		list2.add(p1);
		list2.add(p2);
		list2.add(p3);
		list2.add(p4);
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

	public void result1() { // 단순 리덕션
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
	}

	public void result2() {
//		list.stream().collect(HashSet::new, HastSet::add, HashSet:addAll);
		Iterator<String> i = list.stream().iterator();
		Object[] o1 = list.stream().toArray();
		String[] o2 = list.stream().toArray(String[]::new);

		List<String> l1 = list.stream().collect(Collectors.toList()); // 스트림을 리스트로 모으고 싶을때 사용
		ArrayList<String> l2 = list.stream().collect(Collectors.toCollection(ArrayList::new)); // 이런식으로도
		                                                                                       // 가능
		Set<String> l3 = list.stream().collect(Collectors.toSet());
		TreeSet<String> l4 = list.stream().collect(Collectors.toCollection(TreeSet::new));

		String result1 = list.stream().collect(Collectors.joining()); // 스트림에 있는 모든 문자열 연결
		String result2 = list.stream().collect(Collectors.joining(", ")); // 요소간에 구분자를 넣어서 연결

		// 스트림이 문자열 외의 객체를 포함하는 경우, 다음처럼 해당객체를 먼저 문자열로 바꿔줘야함
		String result3 = list.stream().map(Object::toString).collect(Collectors.joining(", "));

		IntSummaryStatistics summary =
		        list.stream().peek(System.out::println).collect(Collectors.summarizingInt(String::length));
		double avg = summary.getAverage();
		double max = summary.getMax();
		double sum = summary.getSum();
		System.out.println(summary.getSum());
		System.out.println(avg);
		System.out.println(max);

		///////////

		Map<Integer, String> m1 = list2.stream().collect(Collectors.toMap(Person::getId, Person::getName));
		Map<Integer, String> m2 =
		        list2.stream().collect(Collectors.toMap(Person::getId, Person::getName, (old, newVal) -> old));
		Map<Integer, Set<String>> m3 =
		        list2.stream().collect(
		                Collectors.toMap(Person::getId, l -> Collections.singleton(l.getName()), (old, newVal) -> {
			                Set<String> s = new HashSet<>(old);
			                s.addAll(newVal);
			                return s;
		                }));

		// mapping으로 처리. 어차피 groupingBy하면 map형태로 리턴됨. 거기서 mapping을써서 다운스트림을 toSet로 한것
		Map<Integer, Set<String>> m3_1 =
		        list2.stream().collect(
		                Collectors.groupingBy(Person::getId, Collectors.mapping(Person::getName, Collectors.toSet())));

		//////

		List<Locale> list3 = new ArrayList<>();

		// 나라들 기준으로 분류 CH KO JP US
		Map<String, List<Locale>> m4 = list3.stream().collect(Collectors.groupingBy(Locale::getCountry));

		Map<String, Set<Locale>> m5 = // groupingBy는 기본적으로 list를 값으로 사용하는 맵을 리턴, 다른 컬렉션을 원하면
		                              // 넣어주면됨
		        list3.stream().collect(Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));

		Map<Boolean, List<Locale>> m6 = // true / false기준으로 분류할때는 파티셔닝
		        list3.stream().collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));

		Map<String, Long> m7 = // 모인 요소들의 개수를 센다. 동명이인을 기준으로 그룹
		        list2.stream().collect(Collectors.groupingBy(Person::getName, Collectors.counting()));

		Map<String, Integer> m8 = // 모인 요소들의 합계를 구한다.
		        list2.stream().collect(Collectors.groupingBy(Person::getName, Collectors.summingInt(Person::getAge)));

		Map<String, Optional<Person>> m9 = // 모인 요소들의 최댓값을 구한다.
		        list2.stream().collect(
		                Collectors.groupingBy(Person::getName, Collectors.maxBy(Comparator.comparing(Person::getAge))));

		// getName해서 나온값에서 Person::getName을 찾을수있어야함. 모인요소들의 이름중 가장짧은 이름을 구함
		Map<String, Optional<String>> m10 =
		        list2.stream().collect(
		                Collectors.groupingBy(Person::getName, Collectors.mapping(Person::getName,
		                        Collectors.minBy(Comparator.comparing(String::length)))));

		// 이런식으로 mapping을 거치지않으면 String이 뭔지모름
//		list2.stream().collect(
//		        Collectors.groupingBy(Person::getName, Collectors.minBy(Comparator.comparing(String::length))));

		// 그룹핑이나 맵핑함수가 in, long, double을 리턴한다면 요소들의 요약통계 객체(SummaryStatistics)안으로 모을수있다.
		Map<String, IntSummaryStatistics> m11 =
		        list2.stream().collect(
		                Collectors.groupingBy(Person::getName, Collectors.summarizingInt(Person::getAge)));
		m11.get("shin").getMax();

		// 이름 기준으로 그룹핑한 요소들의 ..를 ,로 합침
		Map<String, String> m12 =
		        list2.stream().collect(
		                Collectors.groupingBy(Person::getName,
		                        Collectors.mapping(Person::getName, Collectors.joining(", "))));

	}

	public void result3() {
		Optional<String> s1 = list.stream().reduce((x, y) -> x + y);
//		System.out.println(s1.get());

		int[] array = { 1, 2, 3, 4, 5, 6 };

		// Stream<int> 스트림 생성
		IntStream stream1 = IntStream.of(1, 2, 3, 4, 5, 6);

		// 배열로도 Stream<int> 스트림생성가능
		IntStream stream2 = Arrays.stream(array);

		IntStream stream3 = IntStream.range(0, 10); // 10제외
		IntStream stream4 = IntStream.rangeClosed(0, 10); // 10포함
		stream4.forEach(System.out::println);

		// 객체스트림 -> 기본타입스트림
		IntStream stream5 = list.stream().mapToInt(String::length);
		stream5.forEach(System.out::println);

		// 기본타입스트림 -> 객체스트림
		Stream<Integer> integers1 = stream5.boxed();

		// 객체스트림
		Stream<Double> double1 = Stream.generate(Math::random).limit(100);
		// 기본타입스트림
		DoubleStream double2 = new Random().doubles();
	}

	public void result4() {
		int[] words = new int[20];
		list.stream().parallel().forEach(s -> {
			if (s.length() > 5) {
				words[s.length()]++; // 다수의 쓰레드가 하나의 배열을 접근하고있다. 경쟁조건오류
			}
		});
		System.out.println(Arrays.toString(words));

		Stream<String> s = list.stream().parallel().unordered().limit(100);

		Map<String, List<Person>> result =
		        list2.parallelStream().collect(Collectors.groupingByConcurrent(Person::getName));
	}

	
	/**
	 * 	함수형 인터페이스			인자		리턴타입	설명
	 * -------------------------------------------
	  	Supplier<T>			없음		T		T 타입 값을 공급
		Consumer<T>			T		void	T 타입 값을 소비
		BiConsumer<T, U>	T,U		void	T와 U타입 값을 소비
		Predicate<T>		T		boolean	boolean 값을 리턴
		ToIntFunction<T> 	T		int		T 타입을 인자로 받고 int값을 리턴
		ToLongFunction<T>	T		long	T 타입을 인자로 받고 log값을 리턴
		ToDoubleFunction<T>	T		double	T 타입을 인자로 받고 double값을 리턴
		IntFunction<T>		double	R		각각 int을 인자로 받고 R 타입을 리턴
		LongFunction<T>     int     R       각각 long을 인자로 받고 R 타입을 리턴     
		DoubleFunction<T>	long	R		각각 double을 인자로 받고 R 타입을 리턴
		Function<T, R>		T		R		T타입을 인자로 받고 R타입을 리턴
		BiFunction<T, U, R>	T,U		R		T와 U 타입을 인자로 받고 R타입을 리턴
		UnaryOperator<T>	T		T		T타입에 적용되는 단항 연산자
		BinaryOperator<T>	T T		T		T타입에 적용되는 이항 연산자
	 * 
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Main m = new Main();
		m.setup();
//		m.transform();
//		m.result1();
//		m.result2();
//		m.result3();
		m.result4();
	}

}
