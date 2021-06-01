package study.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 5. 30. initial creation
 */
public class ConcurrentHashMap2 {
	Map<String, AtomicLong> atomicLongMap = new ConcurrentHashMap<>();
	Map<String, Long> longMap = new ConcurrentHashMap<>();

	public void atomicLongMapTest() { // atomic 일때는 이런식으로 원자성을 지키면서 숫자증가
		// map.get("ab")가 비어있으면 실행됨. 해당값을 넣고 map.get("ab")값이 리턴됨 (결국 넣은값).
		AtomicLong d = atomicLongMap.computeIfAbsent("ab", x -> new AtomicLong(1));
		Long l = d.incrementAndGet();
	}

	public void longMapTest() { // 기본 Long이나 Integer는 compute를 쓰면 원자성을 간편히 지킬수있음.
		// compute 자체가 내부소스를 보면 cas알고리즘으로 원자성을 지키도록 구현되어있음. 결국 값을 AtomicLong으로 굳이 안바꿔도됨.
		Long d = longMap.compute("ab", (key, val) -> val == null ? 1 : val + 1);
	}

	public void longMapAbsentTest() {
		// compute 인데 map.get("")한값이 없을때만 실행됨
		longMap.computeIfAbsent("ab", x -> 1L);
	}

	public void longMapPresentTest() {
		// compute 인데 map.get("")한값이 있을때만 실행됨
		longMap.computeIfPresent("ab", (key, val) -> val + 1);
	}

	public void longMapMergeTest() {
		// 키가 처음 추가될때도 뭔가 특별한작업을 해줘야할때 사용 = computeIfAbsent + computeIfPresent
		longMap.merge("ab", 1L, (x, y) -> x + y);
	}

	public void print() {
		System.out.println(atomicLongMap.get("ab"));
	}

	public static void main(String[] args) {
		ConcurrentHashMap2 map = new ConcurrentHashMap2();
		map.atomicLongMapTest();
		map.print();
	}

}
