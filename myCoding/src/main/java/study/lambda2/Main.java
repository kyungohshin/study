package study.lambda2;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 2. 25. initial creation
 */
public class Main {

	public static void do1(Runnable first, Runnable second) {
		first.run(); // <- 여기서 에러가 발생하면 do메서드는 종료되며 이 메서드를 호출한 곳으로 예외를 전달
		second.run(); // 실행x
	}

	public static void do2(Runnable first, Runnable second) {
		Thread t = new Thread() {
			@Override
			public void run() {
				first.run(); // <- 여기서 에러가 발생하면 do메서드는 종료되지만, 예외를 전달하지않고 종료됨
				second.run(); // 실행x
			}
		};
		t.start();
	}

	public static void do3(Runnable first, Runnable second, Consumer<Throwable> handler) {
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					first.run(); // <- 여기서 에러가 발생하면 do메서드는 종료되지만, 예외를 전달하지않고 종료됨
					second.run(); // 실행x
				} catch (Throwable t) {
					handler.accept(t);
				}
			}
		};
		t.start();
	}

	public static <T> void do3(Supplier<T> first, Consumer<T> second, Consumer<Throwable> handler) {
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					T result = first.get();
					second.accept(result);
				} catch (Throwable t) {
					handler.accept(t);
				}
			}
		};
		t.start();
	}

	public static <T> void do4(Callable<T> first, Consumer<T> second, Consumer<Throwable> handler) {
		Runnable r = () -> {
			try {
				T result = first.call(); // first 자체를 구현할때는 예외처리를 안해도되지만, Callable의 call을 쓸때는 예외처리가
				                         // 필수임
				second.accept(result);
			} catch (Throwable t) {
				handler.accept(t);
			}
		};
	}

	public static <T> void do5(Supplier<? extends T> first, Consumer<? super T> second,
	        Consumer<? super Throwable> handler) { // 이런식으로 변환
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					T result = first.get();
					second.accept(result);
				} catch (Throwable t) {
					handler.accept(t);
				}
			}
		};
		t.start();
	}

	public static void main(String[] args) {
		Main m = new Main();
	}

}
