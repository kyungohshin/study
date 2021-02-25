package study.lambda;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 2. 25. initial creation
 */
public class Main {

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

	}

	public static void main(String[] args) {
		Main m = new Main();
		m.test();
	}
}
