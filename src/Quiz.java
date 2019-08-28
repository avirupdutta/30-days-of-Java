/**
 * Quiz
 */
import java.util.Arrays;
import java.util.Scanner;

 public class Quiz {
    static Scanner input = new Scanner(System.in);
    static Questions quesObj = new Questions();
    static int totalQues = quesObj.totalQues;


    static boolean checkAnswer(int quesNum, int playerChoice){
        boolean result = false;
        String corrAns = quesObj.showAnswer(quesNum);
        String playerAns = quesObj.showOptions(quesNum)[playerChoice];

        if(corrAns == playerAns){
            result = true; 
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print("Enter your Name: ");
        CreatePlayer player1 = new CreatePlayer(input.nextLine());
        int playerChoice, num;

        for (int i = 0; i < totalQues; i++) {
            num = 1;
            // Displays the question
            System.out.println("----------------------------------------------");
            System.out.println("Q"+(i+1)+". "+quesObj.showNewQuestion(i));

            // Displays the options
            for (String option : quesObj.showOptions(i)) {
                System.out.println(num+". "+option);
                num++;
            }
            System.out.print("\n>>> ");
            playerChoice = input.nextInt()-1;

            if(checkAnswer(i, playerChoice)){
                player1.increaseScore();
                System.out.println("Correct Answer! +4 points");
            }else{
                player1.decreaseScore();
                System.out.println("Wrong Answer! -1 points.\nCorrect Answer was "+quesObj.showAnswer(i));
            }
            System.out.println("Your current score is "+player1.getPlayerDetails()[1]);
            System.out.println("----------------------------------------------");
        }
        System.out.println("\n=============== Game Over! =================");
        System.out.println("Your Final Score is "+player1.getPlayerDetails()[1]+" out of "+totalQues*4);
        System.out.println("===================================================");
    }
}
/**
 * CreatePlayer is for the player object to maintain scores
 */
public class CreatePlayer {
    private String name;
    private int score;
    CreatePlayer(String name){
        this.name = name;
        this.score = 0;
    }
    public void increaseScore(){
        score += 4;
    }
    public void decreaseScore(){
        score -= 1;
    }
    public String[] getPlayerDetails(){
        String playerInfo[] = new String[2];
        playerInfo[0] = name;
        playerInfo[1] = Integer.toString(score);
        return playerInfo;
    }
}

public class Questions{
    int totalQues = 5;
    private String ques[] = {
        "From where does Sun rises?",
        "Who is Iron Man?",
        "Who is the Prime Minister of USA?",
        "How much Net weight is a Rs.10/- Dairy Milk?",
        "What is the IQ level of Avirup?"
    };
    private String options[][] = {
        {"North", "South", "East", "West"},
        {"Tony Sterk", "Steve Rogers", "Bruce Banner", "Anthony Edward Stark"},
        {"Barack Obama", "Donald Trump", "Bhuvan Bam", "Mamata Bannerjee"},
        {"10.9 gm", "11.4 gm", "13.2 gm", "15.7 gm"},
        {"1", "10", "100", "1000"}
    };
    private String answer[] = {
        options[0][2],
        options[1][3],
        options[2][1],
        options[3][2],
        options[4][3]
    };
    public String showNewQuestion(int num){
        return ques[num];
    }
    public String[] showOptions(int num){
        return options[num];
    }
    public String showAnswer(int num){
        return answer[num];
    }
}

