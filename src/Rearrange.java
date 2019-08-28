// Follow this url https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately/0/

import java.util.Arrays;
import java.util.Scanner;
class Rearrange{
	static Scanner input = new Scanner(System.in);
	static int findMaxElemPos(int arr[], int startPos){
		int maxVal = arr[startPos];
		int maxElemPos = startPos;
		for (int i=startPos; i<arr.length; i++) {
			if (arr[i] > maxVal) {
				maxVal = arr[i];
				maxElemPos = i;
			}
		}
		return maxElemPos;
	}
	static int findMinElemPos(int arr[], int startPos){
		int minVal = arr[startPos];
		int minElemPos = startPos;
		for (int i=startPos; i<arr.length; i++) {
			if (arr[i] < minVal) {
				minVal = arr[i];
				minElemPos = i;
			}
		}
		return minElemPos;
	}
	static int[] rearrangeAlternatively(int arr[]){
		for(int i=0; i<arr.length; i++){
			int maxElemPos = findMaxElemPos(arr, i);
			int minElemPos = findMinElemPos(arr, i);

			System.out.println(maxElemPos+" "+minElemPos);
			// now rearrange by swaping
			int maxTemp = arr[i];
			int minTemp = arr[i+1];

			arr[i] = arr[maxElemPos];
			arr[maxElemPos] = maxTemp;
			
			arr[minElemPos] = minTemp;
			arr[i+1] = arr[minElemPos];
		}
		return arr;
	}
	static int[] setArray(int arr[]){
		System.out.println("Enter Array elements:-");
		for (int i=0; i<arr.length; i++) {
			arr[i] = input.nextInt();
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.print("Enter total test cases: ");
		int totalTestCases = input.nextInt();

		for (int i=0; i<totalTestCases; i++) {
			System.out.print("Enter Array size: ");
			int arrSize = input.nextInt();
			int arr[] = new int[arrSize];
			arr = setArray(arr);
			System.out.println("Initial Array: "+Arrays.toString(arr));
			arr = rearrangeAlternatively(arr);
			System.out.println("Final Array: "+Arrays.toString(arr));
		}
	}
}









