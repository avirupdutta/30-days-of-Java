package RockPaperScisssor;

//import RockPaperScisssor.Input;
//import RockPaperScisssor.User;
//import RockPaperScisssor.Computer;
//import RockPaperScisssor.Configs;

public class Game {
    public static void displayScoreBoard(User player, Computer comp){
        System.out.println("========== SCORE BOARD ==========");
        System.out.println(player.name +": "+ player.score);
        System.out.println(comp.name + ": " + comp.score);
        System.out.println("===================================");
    }

    public static void startNewGame(){

//        Create the player, computer
        User player = new User();
        Computer computer = new Computer();

        int playerHand = -1, computerHand = -1;
        while (true){
//            Display rock-paper-scisssor choice to the player then
//            get the player and computer's choice
            playerHand = Input.chooseHand();
            computerHand = computer.getComputerChoice();

//            display what the player choose and what the computer choose
            System.out.println(player.name + ": " + Configs.choices[playerHand]);
            System.out.println(computer.name + ": " + Configs.choices[computerHand]);

//            checking all the winning possibilities for the player and updating the scores accordingly
            if((playerHand == 0 && computerHand == 2) || (playerHand == 1 && computerHand == 0) || (playerHand == 2 && computerHand == 1)){
                player.increaseScore();
                computer.decreaseScore();
            }
//            checking all the winning possibilities for the computer and updating the scores accordingly
            else if ((computerHand == 0 && playerHand == 2) || (computerHand == 1 && playerHand == 0) || (computerHand == 2 && playerHand == 1)){
                computer.increaseScore();
                player.decreaseScore();
            }
//            display the score board
            displayScoreBoard(player, computer);


            if (player.reachedMaxScore()){
                System.out.println(player.name + " has Won!\n=======================================");
                break;
            }
            else if (computer.reachedMaxScore()){
                System.out.println(computer.name + " has Won!\n=======================================");
                break;
            }
        }
    }

    public static boolean replayGame(){
        System.out.println("Want to Replay the Game ???");
        return Input.chooseReplay();
    }

//    This method is not yet implemented
    public static void exit(){
        System.exit(0);
    }

    public static void displayTimeOut(int secs) {
        System.out.print("\nGame is starting in... ");
        for (; secs >= 1; secs--){
            try{ Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.print(secs+" ");
        }
        System.out.print("\n");
    }

    public static void main ( String[] args ) {
        boolean play = true;
        int menuChoice;
        while (play){
            menuChoice = Input.chooseMainMenu();
//            main game controller
            if (menuChoice == 1){
//               set the winning score to reach
                Input.chooseWinningScore();
                displayTimeOut(5);
                startNewGame();
            }
            else if (menuChoice == 2)
                break;
//            prompts the player for a replay game
            if (replayGame()){
                System.out.println("\n=========== INITIALIZING REMATCH ===========\n");
                continue;
            }
            play = false;
        }
        System.out.println("==========    GAME OVER   =============");
        System.out.println("  ======= Thanks for playing ========");
    }
}
