import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	private ArrayDeque<Integer> carQueue;
	
	public CarQueue() {
		carQueue = new ArrayDeque<Integer>();
		for (int i = 0; i < 5; i++) {
			carQueue.add(new Random().nextInt(4));
		}
	}
	public void addToQueue() {
		class MyRunnable implements Runnable {

			@Override
			public void run() {
				while (true) {	
					try {
							carQueue.add(new Random().nextInt(4));
							Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		MyRunnable r = new MyRunnable();
	    Thread t = new Thread(r);
	    t.start();
	}
	
	public int deleteQueue() {
		return carQueue.remove();
	}
}