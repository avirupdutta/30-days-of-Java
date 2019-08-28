import java.util.*;
class Test{
	public static void main(String[] args){
		String str = "Hello.world.how.are.u?";
		String[] strArr = str.split("\\.");
		System.out.println(Arrays.toString(strArr));
	}
}