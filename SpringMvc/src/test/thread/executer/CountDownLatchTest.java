package thread.executer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Ignore;
import org.junit.Test;

public class CountDownLatchTest {

	static final int SIZE = 10;

	public static void main(String[] args) throws Exception {
		new CountDownLatchTest().test();
	}

	@Test
	@Ignore
	public void test() throws InterruptedException {
		System.out.println("当前线程执行: " + Thread.currentThread().getName());
		CountDownLatch latch = new CountDownLatch(10);
		ExecutorService pool = Executors.newCachedThreadPool();
		WaitingTask2 task = new WaitingTask2(latch);
		for (int i = 0; i < 2; i++) {
			Thread t = new Thread(task, "WaitingTask" + i);
			pool.execute(t);
		}
		TaskPortion2 task2 = new TaskPortion2(latch);
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(task2, "TaskPortion" + i);
			pool.execute(t);
		}
		pool.shutdown();
		latch.await();
		System.out.println("线程结束: " + Thread.currentThread().getName());
	}
}

class TaskPortion2 implements Runnable {

	private CountDownLatch latch;

	public TaskPortion2(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			System.out.println("TaskPortion2 - 当前线程执行: " + Thread.currentThread().getName());
			Thread.sleep(2 * 1000);
			latch.countDown();
			System.out.println("TaskPortion2 - 线程结束: " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class WaitingTask2 implements Runnable {

	private CountDownLatch latch;

	public WaitingTask2(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			System.out.println("WaitingTask2 - 当前线程执行: " + Thread.currentThread().getName());
			latch.await();
			System.out.println("WaitingTask2 - 线程结束: " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
