import java.util.Arrays;

class IntegerQueue{
    private int size = 0;
    int[] arr;
    private int lastEntry = -1;
    IntegerQueue(int size){
        this.size = size;
        arr = new int[size];
//        For simplicity let us assume that if
//        we have -1 in our Queue then the space is empty
        for (int i = 0; i < size; i++){
            arr[i] = -1;
        }
    }

    public boolean isFull(){
        return size == (lastEntry + 1);
    }
    public void insert(int data){
        if (isFull()){
            System.out.println("Error: Queue is Full... Data insertion failed!");
            return;
        }
        arr[++lastEntry] = data;
    }
    public int pop(){
//        System.out.println(lastEntry);
        int poppedElem = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (i == arr.length-1){
                arr[i] = -1;
                continue;
            }
            arr[i] = arr[i+1];
        }
        lastEntry--;
        return poppedElem;
    }
}

public class QueueDemo {
    public static void main ( String[] args ) {
        IntegerQueue intQueue = new IntegerQueue(5);
        System.out.println("Is queue full ? " + intQueue.isFull());

        for (int i = 10; i <= 50; i+=10){
            intQueue.insert(i);
        }
        System.out.println(intQueue.pop());
        System.out.println(intQueue.pop());
        System.out.println(intQueue.pop());
        System.out.println(intQueue.pop());
        System.out.println(intQueue.pop());
        intQueue.insert(60);
        intQueue.insert(70);
        intQueue.insert(80);
        intQueue.insert(90);
        intQueue.insert(100);
//        System.out.println(intQueue.pop());
        System.out.println(intQueue.pop());
        

        System.out.println(Arrays.toString(intQueue.arr));
        System.out.println("Is queue full ? " + intQueue.isFull());
    }
}
