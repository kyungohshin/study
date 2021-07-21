package study.shutdown;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 7. 21. initial creation
 */
public class ShutdownHookTest {

	static class HookThread extends Thread {
		@Override
		public void run() { // 이 메소드 안에 있는 작업 수행
			System.out.println("Hook Run");
		}
	}

	static class HookThread2 extends Thread {
		@Override
		public void run() {
			System.out.println("Hook Run2");
		}
	}

	static class HookThread3 extends Thread {
		@Override
		public void run() {
			System.out.println("Hook Run3");
		}
	}

	// addShutdownHook()는 프로그램이 정상 or 비정상 종료전에 특정작업을 수행할 수 있도록 해준다.
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new HookThread());
		Runtime.getRuntime().addShutdownHook(new HookThread2());
		Runtime.getRuntime().addShutdownHook(new HookThread3()); // 실행순서는 정할수없음

//		int errorNum = 1 / 0; // 에러가 나도 end는 출력 안되지만 hook run은 출력됨
//		System.out.println("End");

		try {
			System.out.println("sleep 3s");
			Thread.sleep(3000); // 진행중에 ctrl+c로 인터럽트를 줘도 end는 출력안되지만 hook run은 출력됨
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("End");
//		Runtime.getRuntime().halt(0); halt()를 사용하면 hook메서드가 돌지않음
	}

}