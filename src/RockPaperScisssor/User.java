package RockPaperScisssor;

import java.util.Scanner;

public class User extends NewPlayer {
    private Scanner input = new Scanner(System.in);

    User () {
        System.out.print("Enter Your Name: ");
        name = input.nextLine();
        if (name.length() < 1 )
            name = "Guest";
    }
}
