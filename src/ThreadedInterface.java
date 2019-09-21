/*
	Implementing multithreading using 'Runnable' which is a functional interface, that
	helps us to extend any super class, if we want.
*/

class ThreadedInterface {
	public static void main(String[] args) throws Exception{

		// The Thread() constructor requires a Runnable object
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hi");
				try { Thread.sleep(1000); } catch(Exception e) { e.printStackTrace(); }
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello");
				try { Thread.sleep(1000); } catch(Exception e) { e.printStackTrace(); }
			}
		});

		t1.start();
		try { Thread.sleep(10); } catch(Exception e) { e.printStackTrace(); }
		t2.start();

		/*
		*	If we don't join the threads then "main" thread will be executed
		* 	while t1 and t2 are in execution
		*/

		// isAlive() is used check if that thread is running state or not
		System.out.println(t1.isAlive());
		t1.join();
		t2.join();

		/*
		*	After t1 and t2 are joined together... The "main" thread will wait
		* until the execution of the threads are done.
		*/
		System.out.println(t1.isAlive());
		System.out.println("Bye");
	}
}
