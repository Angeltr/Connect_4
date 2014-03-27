package gm;

import java.io.*;
import java.util.*;


public class runGame {

   public static void main(String args[]) throws Exception {
	   int PLAYER_ONE = 1;
	   int PLAYER_TWO = -1;
	   int EMPTY = 0;
	   
       Board b;
       playerSearch p, k;
       b = new Board(7, 6);
       p = new playerSearch();
       k = new playerSearch();

       BufferedReader move = new BufferedReader(new InputStreamReader(System.in));
       
      System.out.println("\nWelcome to Connect 4 game!\n");
      
      System.out.println("Enter below a number from 0 to 6 to drop a piece in the column you wish.");
      System.out.println("Winner is the one who first connects four pieces in row, column or diagonally.\n");
      
      
      
       while ((b.winnerIs() == 0) && b.validMovesLeft()) {
           if (b.getCP() == PLAYER_ONE) {
        	   int col;
        	   System.out.print("User's turn. Enter column number >> ");
        	   col = Integer.parseInt(move.readLine());
        	   while (col < 0 || col > 6) {
        		   System.out.print("Enter a number between 0 and 6   >> ");
        		   col = Integer.parseInt(move.readLine());
        	   }
               b.makeMove(col);// Make it so!
           } else {
               b.makeMove(p.getMove(b));// Make it so!
           }
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
