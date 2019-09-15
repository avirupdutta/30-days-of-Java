package RockPaperScisssor;

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
                System.out.println(player.name + " has Won!");
                break;
            }
            else if (computer.reachedMaxScore()){
                System.out.println(computer.name + " has Won!");
                break;
            }
        }
    }

    public static boolean replayGame(){
        return false;
    }

//    This method is not yet implemented
    public static void exit(){
        System.exit(0);
    }

    public static void main ( String[] args ) {
        boolean play = true;
        while (play){

//            main game controller
            if (Input.chooseMainMenu()==1){
//               set the winning score to reach
                Input.chooseWinningScore();
                startNewGame();
            }
//            prompts the player for a replay game
            else if (replayGame()){
                continue;
            }
            play = false;
        }
        System.out.println("==========    GAME OVER   =============");
        System.out.println("  ======= Thanks for playing ========");
    }
}
