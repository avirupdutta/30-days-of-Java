/*
	Implementing multithreading using 'Runnable' interface
	helps us to extend any super class, if we want.
*/

class ThreadedInterface {
	public static void main(String[] args) {
		Hi obj1 = new Hi(); // Runnable obj1 = new Hi();
		Hello obj2 = new Hello(); // Runnable obj2 = new Hello();

		// The Thread() constructor requires a Runnable object
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);

		t1.start();
		try { Thread.sleep(10); } catch(Exception e) { e.printStackTrace(); }
		t2.start();
	}
}

class Hi implements Runnable {
	public void run(){
		for (int i = 0; i < 5; i++) {
			System.out.println("Hi");
			try { Thread.sleep(1000); } catch(Exception e) { e.printStackTrace(); }
		}
	}
}

class Hello implements Runnable {
	public void run(){
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello");
			try { Thread.sleep(1000); } catch(Exception e) { e.printStackTrace(); }
		}
	}
}