import java.util.Arrays;
import java.util.Scanner;

// This is the Non-Preemptive version of SJF
public class ShortestJobFirst {
    static Process[] bubbleSort(Process arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j].burstTime > arr[j+1].burstTime){
                    Process temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main ( String[] args ) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the no. of processes you want to create: ");
        int totalProcesses = input.nextInt();
        Process processArr[] = new Process[totalProcesses];
        Process readyQueue[];
        Process finishedQueue[] = new Process[totalProcesses];

//        Create all the processes obj and keep them in processArr[]
        for (int i = 0; i < totalProcesses; i++) {
            System.out.print("Enter Arrival Time for p:"+(i+1)+" ");
            int arrivalTime = input.nextInt();
            System.out.print("Enter Burst Time for p:"+(i+1)+" ");
            int burstTime = input.nextInt();
            processArr[i] = new Process(arrivalTime, burstTime);
        }
        /*
        finishedQueue[0] = processArr[0];   // As the first process will always be executed first
        int lastProcessIndex = 0;
//        fill up the ready queue

        for (int i = lastProcessIndex; i <=  processArr[lastProcessIndex].burstTime; i++) {
//            1) count how many process has entered
            int counter = 0;
            for (int j = 0; j < i; j++) {
                if(processArr[j].arrivalTime <= processArr[i].burstTime ){
                    counter++;
                }
            }
            readyQueue = new Process[counter];
            for (int j = 0; j < totalProcesses; j++) {
//                readyQueue[0]
            }
        }
        */
        processArr = bubbleSort(processArr);
        displayArr(processArr);
    }
    static void displayArr(Process arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("p:"+arr[i].id+"\n --Arrival Time: "+arr[i].arrivalTime+"\n --Burst Time: "+arr[i].burstTime);
//            System.out.println("Process ID\tArrival Time\tBurst Time");
//            System.out.println(arr[i].id+"\t"+arr[i].arrivalTime+"\t"+arr[i].burstTime);
        }
        System.out.println(Arrays.toString(arr));
    }
}
class Process{
    int id, arrivalTime, burstTime;
    static int totalProcesses = 1;
    Process(int arrivalTime, int burstTime){
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.id =  totalProcesses++;
    }
}