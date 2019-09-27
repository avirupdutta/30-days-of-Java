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
    public boolean isEmpty() {
        for (int elem: arr) {
            if (elem != -1)
                return false;
        }
        return true;
    }
    public int peek(){
        return arr[0] != -1 ? arr[0]: null;
    }
}

public class QueueDemo {
    public static void main ( String[] args ) {
        IntegerQueue intQueue = new IntegerQueue(5);

//        prints false
        System.out.println("Is queue full ? " + intQueue.isFull());

//        prints true
        System.out.println(intQueue.isEmpty());

//        iteratively filling up the queue
        for (int i = 10; i <= 50; i+=10){
            intQueue.insert(i);
        }

//       Popping out all the data that were just inserted
        System.out.println(intQueue.pop());
        System.out.println(intQueue.pop());
        System.out.println(intQueue.pop());
        System.out.println(intQueue.pop());
        System.out.println(intQueue.pop());

//        Inserting new data in the queue
        intQueue.insert(60);
        intQueue.insert(70);
        intQueue.insert(80);
        intQueue.insert(90);
        intQueue.insert(100);

//        emptying the queue
        System.out.println(intQueue.pop());
        System.out.println(intQueue.pop());
        System.out.println(intQueue.pop());
        System.out.println(intQueue.pop());
        System.out.println(intQueue.pop());


//        produces -> java.lang.NullPointerException
        try {
            System.out.println("Peeked data: " + intQueue.peek());
        } catch (Exception err){
            System.out.println(err);
        }

//        displays the array
        System.out.println(Arrays.toString(intQueue.arr));

//        prints false
        System.out.println("Is queue full ? " + intQueue.isFull());
    }
}
