package thread.executer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class CallableTest {

	@Test
	public void submitCall() throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<String>> list = new ArrayList<Future<String>>();
		for (int i = 0; i < 5; i++) {
			list.add(exec.submit(new TaskWithResult(i)));
		}
		
		for (Future<String> future : list) {
			
			System.out.println(future.get());
		}
	}
	
	public static class TaskWithResult implements Callable<String> {

		private int id;
		
		public TaskWithResult(int id) {
			this.id = id;
		}
		
		@Override
		public String call() throws Exception {

			return "Task id: " + id;
		}
		
	}
}
