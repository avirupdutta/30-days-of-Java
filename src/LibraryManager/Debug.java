package LibraryManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Debug {
    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter age, course and name");
//        int age = sc.nextInt();
//        String course = sc.nextLine();
//        String name = sc.nextLine();
//        System.out.println(name + " : " + age + " : "+ course);


//        while(true){
//            System.out.println("press 1 to stop outer loop");
//            int c = sc.nextInt();
//            if (c == 1)
//                break;
//            while(true){
//                System.out.println("press 2 to stop inner loop");
//                c = sc.nextInt();
//                if (c == 2)
//                    break;
//            }
//        }

//        System.out.println("              abc".strip().length());

        ArrayList <String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (String n : list){
                    if (n.equals("2"))
                        list.remove("2");
                }
                System.out.println(Arrays.toString(list.toArray()));

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                list.remove("2");
                System.out.println(Arrays.toString(list.toArray()));
            }
        });
        t1.start();

    }
}
