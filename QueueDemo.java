import java.util.*;

class QueueDemo{
	public static void main(String[] args) {
		Queue myQueue = new Queue(5);
		myQueue.displayQueue();
		myQueue.push("10");
		myQueue.push("20");
		myQueue.push("30");
		myQueue.push("40");
		myQueue.push("50");
		// myQueue.pop();
		// myQueue.pop();
		// myQueue.pop();
		// myQueue.pop();
		// myQueue.pop();
		myQueue.pop();
		myQueue.push("90");
		System.out.println(myQueue.peek());

		myQueue.displayQueue();
	}
	
}
class Queue{
	private String arr[];
	int index = -1;
	int head = 0;
	Queue(int size){ 
		arr = new String[size]; 
	}
	boolean isEmpty(){ return index == -1; }
	String peek(){ 
		if(isEmpty()){
			System.out.println("Error: Queue is Empty!");
			return "";
		}
		return arr[head]; 
	}
	void push(String data){
		if (index == arr.length-1){
			System.out.println("Error: Queue is full!");
			return;
		}
		arr[++index] = data;
	}
	String pop(){
		if(isEmpty()){
			System.out.println("Error: Queue is Empty.. Nothing to pop");
			return "";
		}
		String temp = arr[0];
		arr[0] = "";
		head++;
		String newArr[] = new String[arr.length];
		for(int i=0; i<arr.length-1; i++)
			newArr[i]


		return temp;
	}
	void displayQueue(){
		if(isEmpty()){
			System.out.println("Error: Queue is Empty.. Nothing to Show");
			return;
		}
		System.out.println(Arrays.toString(arr));
	}
}

