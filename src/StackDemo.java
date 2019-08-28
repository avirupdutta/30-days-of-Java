import java.util.*;

class StackDemo{
	public static void main(String[] args) {
		Stack myStack = new Stack(5);
		myStack.displayStack();
		myStack.push("10");
		myStack.push("20");
		myStack.push("30");
		myStack.push("40");
		myStack.push("50");
		// myStack.pop();
		// myStack.pop();
		// myStack.pop();
		// myStack.pop();
		// myStack.pop();
		myStack.pop();
		myStack.push("90");
		System.out.println(myStack.peek());

		myStack.displayStack();
	}
	
}
class Stack{
	private String arr[];
	int index = -1;
	Stack(int size){ 
		arr = new String[size]; 
	}
	boolean isEmpty(){ return index == -1; }
	String peek(){ 
		if(isEmpty()){
			System.out.println("Error: Stack is Empty!");
			return "";
		}
		return arr[index]; 
	}
	void push(String data){
		if (index == arr.length-1){
			System.out.println("Error: Stack is full!");
			return;
		}
		arr[++index] = data;
	}
	String pop(){
		if(isEmpty()){
			System.out.println("Error: Stack is Empty.. Nothing to pop");
			return "";
		}
		arr[index] = "";
		return arr[index--];
	}
	void displayStack(){
		if(isEmpty()){
			System.out.println("Error: Stack is Empty.. Nothing to Show");
			return;
		}
		System.out.println(Arrays.toString(arr));
	}
}

