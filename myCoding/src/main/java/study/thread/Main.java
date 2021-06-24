package study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 4. 5. initial creation
 */
public class Main {

	// 500개 고정
	public void newFixedThreadPool() {
		ExecutorService executorService = Executors.newFixedThreadPool(50);
		for (int i = 0; i < 150; i++) {
			executorService.execute(() -> {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		executorService.shutdown();
	}

	// 제한없음
	public void newCachedThreadPool() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 150; i++) {
			executorService.execute(() -> {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		executorService.shutdown();
	}

	// 위의 2개로 간단히 안된다면 상세설정가능
	// 최초 쓰레드풀 0개 생성 - 최대 50개까지 생성, 각각의 스레드는 10초간 생성
	// LinkedBlockingQueue는 120개의 버퍼공간 존재 결국 최대 -170개씩 한번에 돌릴수있음
	// 한번에 바로 풀사이즈로 가는것이 아니라 일단 버퍼에 담아두고 버퍼가 넘칠경우 사이즈를 올림
	// 아래는 최대 120개를 담아뒀지만 30개는 처리가 안되므로 사이즈를 30으로 늘려서 처리
	public void LinkedBlockingQueue() {
		ExecutorService executorService = new ThreadPoolExecutor(0, 50,
		        10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(120));
		for (int i = 0; i < 150; i++) {
			executorService.execute(() -> {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
	}

	// 최초 쓰레드풀 0개 생성 - 최대 50개까지 생성, 각각의 스레드는 10초간 생성
	// SynchronousQueue는 버퍼공간이 없으므로 50개를 초과하면 에러
	public void SynchronousQueue() {
		ExecutorService executorService = new ThreadPoolExecutor(0, 50,
		        10L, TimeUnit.SECONDS, new SynchronousQueue<>());
		for (int i = 0; i < 150; i++) {
			executorService.execute(() -> {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.newFixedThreadPool();
//		m.newCachedThreadPool();
//		m.LinkedBlockingQueue();
//		m.SynchronousQueue();
	}

}
