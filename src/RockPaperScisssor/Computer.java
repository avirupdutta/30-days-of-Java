package RockPaperScisssor;

import java.util.Random;

public class Computer extends NewPlayer{
    public String name = "Computer";

    public int getComputerChoice(){
        Random rand = new Random();
        return rand.nextInt(Configs.choices.length);
    }

}
