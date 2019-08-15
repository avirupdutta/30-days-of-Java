import java.util.Scanner;
import java.util.Arrays;
class SelectionSortDemo{
	static int findMaxPos(int arr[], int limit){
		int maxValue = arr[0];
		int maxPos = 0;
		for (int i=0; i < limit; i++) {
			if(arr[i] > maxValue){
				maxValue = arr[i];
				maxPos = i;
			}
		}
		return maxPos;
	}
	static int[] maxSelectionSort(int arr[]){
		for(int i=arr.length; i > 0; i--){
			int maxValPos = findMaxPos(arr, i);
			int temp = arr[i-1];
			// swap
			arr[i-1] = arr[maxValPos];
			arr[maxValPos] = temp;
		}
		return arr;
	}

	static int findMinPos(int arr[], int start){
		int minValue = arr[arr.length-1];
		int minPos = arr.length-1;
		for (int i=start; i < arr.length; i++) {
			if(arr[i] < minValue){
				minValue = arr[i];
				minPos = i;
			}
		}
		return minPos;
	}
	static int[] minSelectionSort(int arr[]){
		for(int i=0; i < arr.length; i++){
			int minValPos = findMinPos(arr, i);
			int temp = arr[i];
			// swap
			arr[i] = arr[minValPos];
			arr[minValPos] = temp;
		}
		return arr;
	} 

	public static void main(String args[]){
		int arr[] = {50, -90, 10, 40, 60, -20, 30, 80, 70, -100};
		// arr = maxSelectionSort(arr);
		arr = minSelectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}

