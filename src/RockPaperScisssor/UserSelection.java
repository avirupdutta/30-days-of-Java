//package RockPaperScisssor;
//
//import java.util.Scanner;
//
//public class UserSelection {
//    Configs gameConfigs = new Configs();
//    private Scanner input = new Scanner(System.in);
//
////    Selects whether CONTINUE to play game / EXIT
//    public int selectOption(int num){
//        int choice = -1;
//        switch (num){
//            case 1:
//                String errorMsg = "Invalid Input! Choose either 1 or 2 or 3";
//                while (choice != 0 && choice != 1 && choice != 2){
//                    gameConfigs.displayChoices();
//                    try{
//                        choice = input.nextInt()-1;
//                    }
//                    catch (NumberFormatException e){
//                        System.out.println(e+" "+errorMsg);
//                    }
//                    if (choice != 0 && choice != 1 && choice != 2){
//                        System.out.println(choice+" "+errorMsg);
//                    }
//                }
//                break;
//            case 2:
//                System.exit(0);
//                break;
//            default:
//                System.out.println("Please Choose correct option\n");
//        }
//        return choice;
//    }
//}
