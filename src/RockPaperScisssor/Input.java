package RockPaperScisssor;


import java.util.Scanner;

public class Input {
    private static Scanner in = new Scanner(System.in);

    //    Displays the Main menu at the beginning of the game
    public static void displayMainMenu(){
        System.out.println("Press 1 to Start Playing");
        System.out.println("Press 2 to Exit");
    }
    //    Displays the options such as ROCK, PAPER or SCISSORS
    public static void displayChoices(){
        System.out.println("\nChoose Your Option\n");
        for(int i = 0; i < Configs.choices.length; i++){
            System.out.println((i+1)+". "+Configs.choices[i]);
        }
    }


//    Returns 1 for "keep playing" and 2 for "exit"
    public static int chooseMainMenu(){
        String mainMenuErrorMsg = "Invalid Input! Choose either 1 or 2";
        int choice = 0;
        while (choice != 1 && choice != 2){

//            Exception handling to prevent the user from entering alphabets
            try{
                displayMainMenu();
                choice = in.nextInt();
            }
            catch (NumberFormatException e){
                System.out.println(mainMenuErrorMsg);
            }

//            Displaying error msg if the user enters any no other than 1 or 2
            if (choice != 1 && choice != 2){
                System.out.println(mainMenuErrorMsg);
            }
        }
        return choice;
    }

//    Returns 0 for "Rock", 1 for "Paper" and 2 for "Scissor"
    public static int chooseHand(){
        String chooseHandErrorMsg = "Invalid Input! Choose either 1 or 2 or 3";
        int choice = 0;

        while (choice != 1 && choice != 2 && choice != 3){
            displayChoices();

//            Exception handling to prevent the user from entering alphabets
            try{
                choice = in.nextInt();
            }
            catch (NumberFormatException e){
                System.out.println(e+": "+chooseHandErrorMsg);
            }
            catch (Exception e){
                System.out.println(e+": "+chooseHandErrorMsg);
                in.next();
            }

//            Displaying error msg if the user enters any no other than 1 or 2
            if (choice != 1 && choice != 2 && choice != 3){
                System.out.println(chooseHandErrorMsg);
            }
        }
        return choice-1;
    }

//    Prompt the user for setting the high maximum score
    public static void chooseWinningScore(){
        int score;
        try{
            System.out.print("Choose the Winning Score: ");
            score = in.nextInt();
        } catch (Exception e){
            System.out.println("Error Occurred: Invalid Input!");
            score = 50;
            System.out.println("\nWarning: Default Winning Score of "+score+" is set due to invalid input.\n");
        }
        Configs.setWinningScore(score);
    }

//    Prompt the user for Game Replay
    public static boolean chooseReplay() {
        char choice;

        System.out.println("'Y' or 'Yes' to Continue");
        System.out.println("Press any other to Exit");
        choice = in.next().toLowerCase().charAt(0);

        return choice == 'y';
    }
}
