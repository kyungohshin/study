package study.lambda;

import java.util.stream.Stream;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 2. 25. initial creation
 */
public class Main {

	public static void repeatMessage(String text, int count) {
		Runnable r = () -> {
			for (int i = 0; i < count; i++) {
				System.out.println(text);
				Thread.yield();
//				count--;  // 캡처한 변수는 변경할수 없다. 쓰레드에 안전하지 않기때문에 막아놓음
			}
		};
		new Thread(r).start();
	}

	public void test() {
		Object o = new Object() {
			int max(int a, int b) {
				return a + b;
			}
		};
		// o.max(2, 3); 오류 Object에는 max함수가 없음

		Func f1 = new Func() {
			@Override
			public int max(int a, int b) {
				return a + b;
			}
		};
		f1.max(2, 3);

		Func f2 = (a, b) -> a + b;

		Runnable run = () -> {
			System.out.println("ab");
			// Thread.sleep(1000); <- try catch하거나 추상메서드에 예외선언이 되어있거나
		};

		Func2 f3 = new Func2() {
			@Override
			public void max(String a, String b) {
				a.compareToIgnoreCase(b);
			}
		};
		Func2 f4 = (a, b) -> a.compareToIgnoreCase(b);
		Func2 f5 = String::compareToIgnoreCase;

		f5.max("3", "6");

		repeatMessage("hi", 100);
		Stream.of();
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.test();
	}

}
