package study.thread;

import java.util.concurrent.ArrayBlockingQueue;
/**
 *
 *
 * @author USER
 * @history
 *          2020. 8. 14. initial creation
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = new ThreadPoolExecutor(3, 3, 0L,
		        TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(18));

		normalRun(executor);
	}

	private static void normalRun(ExecutorService executor) {
		Worker tasks[] = new Worker[20];
		for (int i = 0; i < 20; i++) {
			tasks[i] = new Worker(i);
			executor.execute(tasks[i]);
		}

		executor.shutdown();
	}

	private static void exceptionRun(ExecutorService executor) {
		Worker tasks[] = new Worker[10];
		for (int i = 0; i < 10; i++) {
			tasks[i] = new Worker(i);
			executor.execute(tasks[i]);
		}

		executor.shutdown();
		executor.execute(tasks[0]);
	}
}

class Worker implements Runnable {

	private int id;

	public Worker(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		try {
			Thread currentThread = Thread.currentThread();
			System.out.println(currentThread.getName()
			        + " currently execution the task " + id);

			Thread.sleep(3000);
			System.out.println(currentThread.getName()
			        + " just completed the task " + id);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
