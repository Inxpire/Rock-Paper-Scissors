package games;

/*import pre-defined classes from Java utilities:
-Random class is a constructor to create an instance of a random number,
-Scanner class is a constructor to create an instance of a user input,
 */

import java.util.Random;
import java.util.Scanner;

/*create a public class constructor, to create objects with key /value pairs, initialising different variables and their type */

public class rockPaperScissors {

    String playerName;
    String playerMove;
    String computerMove;
    int score;
    Scanner myScanner = new Scanner(System.in);

    //named variable to store new instance of class and then calling that function on the new rps object
    public static void main(String[] args){
        rockPaperScissors rps = new rockPaperScissors();
        rps.initialiseGame();
    }

    // create a function to start game and ask for user input to store in playerName, and then calling the playgame function
    private void initialiseGame(){
        System.out.println("Enter your name: ");
        playerName = myScanner.nextLine();
        playGame();
    }
    //creating the function playGame that collects from player the input for playerMove, computerMove, which calls the generate random move  function
    //
    private void playGame(){
        System.out.println("Enter your move: ");
        playerMove = myScanner.nextLine();
        System.out.println(playerName + " has selected " + playerMove + " as their move");
        computerMove = generateComputerMove();
        //creating a function getWinne that takes two arguments and then comes with a result based on conditional statements
        String result = getWinner(playerMove, computerMove);
        if(result.equalsIgnoreCase("Win")){
            System.out.println("Congratulations, you won this round!");
            score++;
        }
        else if(result.equalsIgnoreCase("Lose")){
            System.out.println("You lost this round!");
            score--;
        }
        else {
            System.out.println("This round was a draw!");
        }

        if(score < 3 && score > -3){
            playGame();
        }
        else if(score == 3){
            System.out.println("Winner Winner!!");
        }
        else if(score == -3){
            System.out.println("You Looooooosssseeeee!");
        }

    }


    //creating the function that generates a random move  and uses a switch case, for the computer and returns the value
    private String generateComputerMove() {
        Random r = new Random();
        String move = "";
        int i = r.nextInt(3);
        switch(i){
            case 0:
                move = "Rock";
                break;

            case 1:
                move = "Paper";
                break;

            case 2:
                move = "Scissors";
                break;
        }
        return move;
    }

    //creating a function with two arguments, with conditional statements to capture every possible outcome of the game
    private String getWinner(String playerMove, String computerMove){
        String outcome = "";
        if(playerMove.equalsIgnoreCase("rock")){
            if(computerMove.equalsIgnoreCase("rock")){
                outcome = "Draw";
            }
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Lose";
            }
            else{
                outcome = "Win";
            }
        }
        if(playerMove.equalsIgnoreCase("paper")){
            if(computerMove.equalsIgnoreCase("rock")){
                outcome = "Win";
            }
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Draw";
            }
            else{
                outcome = "Lose";
            }
        }
        if(playerMove.equalsIgnoreCase("scissors")){
            if(computerMove.equalsIgnoreCase("rock")){
                outcome = "Lose";
            }
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Win";
            }
            else{
                outcome = "Draw";
            }
        }//returns the string value for outcome to the variable
        return outcome;
    }
}
