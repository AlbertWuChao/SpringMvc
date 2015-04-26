package thread.executer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;

public class ExecuterTest {

	@Test
	public void testpriority() throws InterruptedException {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("T1: " + i);
					Thread.yield();
				}
			}
		};
		t1.setPriority(Thread.MIN_PRIORITY);
		
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("T2: " + i);
					Thread.yield();
				}
			}
		};
		t2.setPriority(Thread.NORM_PRIORITY);
		
		Thread t3 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("T3: " + i);
					Thread.yield();
				}
			}
		};
		t3.setDaemon(false);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	@Test
	@Ignore
	public void testCachedThreadPool() throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		ExecutorService exec2 = Executors.newFixedThreadPool(5);
		ExecutorService exec3 = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			exec2.execute(new LiftOff());
		}
		Thread.sleep(2000);
		exec.shutdown();
	}
	
	public static class LiftOff implements Runnable {

		protected int countDown = 10;
		private static int taskCount = 0;
		private final int id = taskCount ++;
		
		public LiftOff(int countDown) {
			this.countDown = countDown;
		}
		
		public LiftOff() {}
		
		public String status() {
			return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff") + ")";
		}
		
		@Override
		public void run() {
			while (countDown-- > 0) {
				System.out.println(status());
				Thread.yield();
			}
		}
		
	}
}
