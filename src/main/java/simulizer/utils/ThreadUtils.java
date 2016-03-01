package simulizer.utils;

import javafx.application.Platform;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Utility functions for dealing with threads
 */
public class ThreadUtils {

	/**
	 * like Platform.runLater but waits until the thread has finished
	 * based on: http://www.guigarage.com/2013/01/invokeandwait-for-javafx/
	 * @param r the runnable to run in a JavaFX thread
	 */
	public static void platformRunAndWait(final Runnable r) throws InterruptedException, ExecutionException {
		if(Platform.isFxApplicationThread()) {
			try {
				r.run();
			} catch(Exception e) {
				throw new ExecutionException(e);
			}
		} else {
			final Lock lock = new ReentrantLock();
			final Condition condition = lock.newCondition();
			// to get around the requirement for final
			final Throwable[] ex = { null };
			lock.lock();
			try {

				Platform.runLater(() -> {
					lock.lock();
					try {
						r.run();
					} catch(Throwable e) {
						ex[0] = e;
					} finally {
						try {
							condition.signal();
						} finally {
							lock.unlock();
						}
					}
				});

				condition.await();

				if(ex[0] != null) {
					// re-throw exception from the runLater thread
					throw new ExecutionException(ex[0]);
				}
			} finally {
				lock.unlock();
			}
		}
	}
}