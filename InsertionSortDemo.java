import java.util.Arrays;
class InsertionSortDemo{
	public static int[] insertionSort(int arr[]){
		int i, j, k, temp;
		for(i=1; i<arr.length; i++){
			k = arr[i];
			j = i-1;
			while(j >= 0 && k < arr[j]){
				// Swap
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				j--;
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		int arr[] = {50, 90, 10, 40, 60, 20, 30, 80, 70, 0};
		arr = insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}