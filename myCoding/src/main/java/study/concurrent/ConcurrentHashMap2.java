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
	Map<String, AtomicLong> map = new ConcurrentHashMap<>();

	public void mapTest() {
		// map.get("ab")가 비어있으면 실행됨. 해당값을 넣고 map.get("ab")값이 리턴됨 (결국 넣은값).
		AtomicLong d = map.computeIfAbsent("ab", x -> new AtomicLong(1));
		Long l = d.incrementAndGet();
		map.compute("ab", (x, y) -> y);
	}

	public void print() {
		System.out.println(map.get("ab"));
	}

	public static void main(String[] args) {
		ConcurrentHashMap2 map = new ConcurrentHashMap2();
		map.mapTest();
		map.print();
	}

}
