package study.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 5. 30. initial creation
 */
public class AtomicExample {

	public AtomicBoolean atomicBoolean = new AtomicBoolean(false);

	public AtomicInteger atomicInteger = new AtomicInteger(20);

	public static void main(String[] args) {
		AtomicExample atomicExample = new AtomicExample();
		System.out.println(atomicExample.atomicBoolean);

		// expect값과 현재 값이 같으면 값을 update로 변경하고 true 리턴
		System.out.println(atomicExample.atomicBoolean.compareAndSet(false, true));
		System.out.println(atomicExample.atomicBoolean);
		System.out.println(atomicExample.atomicBoolean.getAndSet(false)); // 현재 값을 리턴하고 들어온값으로 값 변경
		System.out.println(atomicExample.atomicBoolean);
		// ======================
		System.out.println(atomicExample.atomicInteger);

		// expect값과 현재 값이 같으면 값을 update로 변경하고 true 리턴
		System.out.println(atomicExample.atomicInteger.compareAndSet(20, 21));
		System.out.println(atomicExample.atomicInteger);
		System.out.println(atomicExample.atomicInteger.getAndSet(22));
		System.out.println(atomicExample.atomicInteger);
		System.out.println(atomicExample.atomicInteger.incrementAndGet()); // 1증가하고 그값 return
		System.out.println(atomicExample.atomicInteger);
		System.out.println(atomicExample.atomicInteger.getAndIncrement()); // 현재값 return하고 그다음 1증가
		System.out.println(atomicExample.atomicInteger);
		System.out.println(atomicExample.atomicInteger.accumulateAndGet(2, (x, y) -> x + y)); // x만큼증가
		System.out.println(atomicExample.atomicInteger);
		System.out.println(atomicExample.atomicInteger.updateAndGet(x -> x + 2)); // x만큼증가
		System.out.println(atomicExample.atomicInteger);
	}

}
