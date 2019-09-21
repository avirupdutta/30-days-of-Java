/*
	Implementing multithreading using 'Runnable' which is a functional interface, that
	helps us to extend any super class, if we want.
*/

class ThreadedInterface {
	public static void main(String[] args) throws Exception{

		// The Thread() constructor requires a Runnable object
//		Names of threads can be set in and out of their constructor function
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hi has priority = "+Thread.currentThread().getPriority());
				try { Thread.sleep(1000); } catch(Exception e) { e.printStackTrace(); }
			}
		}, "Hi Thread name set in Constructor");
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello has priority = "+Thread.currentThread().getPriority());
				try { Thread.sleep(1000); } catch(Exception e) { e.printStackTrace(); }
			}
		}, "Hello Thread name set in Constructor");
//		t1.setName("Hi Thread name set outside Constructor");
//		t2.setName("Hello Thread name set outside Constructor");

		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);

		System.out.println(t1.getName());
		System.out.println(t2.getName());

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
