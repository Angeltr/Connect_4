/**
*
* @author Angelos Trigkas
*/

package gm;

import java.io.*;
import java.util.*;


public class runGame {

   public static void main(String args[]) throws Exception {
	   int PLAYER_ONE = 1;
	   int PLAYER_TWO = -1;
	   int EMPTY = 0;
	   
       Board b;
       computerPlayer p;
       b = new Board(7, 6);
       p = new computerPlayer();

       BufferedReader move = new BufferedReader(new InputStreamReader(System.in));
       
      System.out.println("\nWelcome to Connect 4 game!\n");
      
      System.out.println("Enter below a number from 1 to 7 to drop a piece in the column you wish.");
      System.out.println("Winner is the one who first connects four pieces in row, column or diagonally.\n");
      
      
      
       while ((b.winnerIs() == 0) && b.validMovesLeft()) {
           if (b.getCP() == PLAYER_ONE) {
        	   int col = 0;
                   boolean bool = false;
        	   /* Prompt the user for input. */
        	   System.out.print("User's turn. Enter column number >> ");
        	   
        	   /* Check user input for correctness. */
                   do {
                        try {
                            col = Integer.parseInt(move.readLine());
                            bool = false;
                        }              
                        catch (NumberFormatException e) {
                            System.out.print("Enter a number between 1 and 7   >> ");
                            bool = true;
                        }
                   }
                   while(bool);
                   
        	   while (col < 1 || col > 7) {
        		   
        		   col = Integer.parseInt(move.readLine());
        	   }
        	   
        	   /* User move. */
               b.makeMove(col-1);
           } else {
        	   /* Computer move. */
               b.makeMove(p.getMove(b));
           }
           /* Print the board to the screen. */
           System.out.println(b);
       }
       
       if (b.winnerIs() == 1) {
    	   System.out.println("You win!!!");
       }
       else {
    	   System.out.println("Computer won.");
       }

   }
}
