import java.util.Scanner;
import java.util.Arrays;
class ReverseString{
	static String[] revArr(String arr[]){
		String tempArr[] = new String[arr.length];
		for (int i=arr.length-1, k = 0; i >= 0; i--, k++) {
			tempArr[k] = arr[i];
		}
		return tempArr;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int limit = sc.nextInt();
		sc.nextLine(); // consuming the <enter> from input above... just line in C
		String inputArr[] = new String[limit];
		for(int i=0; i<limit; i++){
			inputArr[i] = sc.nextLine();
		}
		System.out.println(Arrays.toString(inputArr));
		for(int i=0; i<limit; i++){
			String strArr[] = revArr(inputArr[i].split("\\."));
			System.out.println(String.join(".", strArr));
		}

		
	}
}