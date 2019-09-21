package Algorithms;

import java.util.Arrays;
import java.util.Scanner;
class QuicksortDemo{
	public static int  partition(int arr[], int low, int high){
		int i = low - 1;
		int pivot = arr[high];
		for(int j = low; j < high; j++){
			// If the current elemment is smaller than the pivot then "swap!"
			if (arr[j] < pivot) {
				// start swaping...
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// Finally place the partition value after the last value of "i"
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return (i+1);
	}
	public static void quicksort(int arr[], int low, int high){
		if(low < high){
			// get the partition index (the index upto where the partition occurred) 
			int pi = partition(arr, low, high);

			// sort the array from start to before partition index
			quicksort(arr, low, pi-1);
			// sort the array from after partition index to end
			quicksort(arr, pi+1, high);
		}
	}
	public static void main(String[] args) {
		int arr[] = {50, 90, 10, 40, 60, 30, 20, 80, 70, 100};
		quicksort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}