/*
	Implementing multithreading using 'Runnable' functional interface, which
	helps us to extend any super class, if we want.
*/

class ThreadedInterface {
	public static void main(String[] args) {

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
	}
}
