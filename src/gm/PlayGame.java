/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class PlayGame {

    final static int PLAYER_ONE = 1;     // User player
    final static int PLAYER_TWO = -1;    // Computer Player
    final static int EMPTY = 0;
    
    private Board board;
    private computerPlayer compPlayer;

    public PlayGame() {
        board = new Board(7, 6);
        compPlayer = new computerPlayer();

        int input = 0;


        while (true) {

            System.out.println("\nWelcome to Connect 4 game!");
            System.out.println("\n  1. New Game\n  2. Exit\n");
            System.out.print("Press 1 for new game or 2 for exit   >> ");

            /*
             * Read user input
             */
            try {
                input = readAndCheckInput(1, 2);
            } catch (IOException ex) {
                Logger.getLogger(PlayGame.class.getName()).log(Level.SEVERE, null, ex);
            }


            if (input == 2) {
                System.out.println("\nGoodbye!");
                System.exit(0);
            } else {
                System.out.println("\nEnter below a number from 1 to 7 to drop a piece in the column you wish.");
                System.out.println("Winner is the one who first connects four pieces in row, column or diagonally.\n");


                while ((board.winnerIs() == 0) && board.validMovesLeft()) {

                    if (board.getCP() == PLAYER_ONE) {   // User player
                        int col = 0;
                        boolean bool = false;

                        /*
                         * Prompt the user for input.
                         */
                        System.out.print("User's turn. Enter column number or press 0 to exit this game >> ");

                        try {
                            col = readAndCheckInput(0, 7);
                        } catch (IOException ex) {
                            Logger.getLogger(PlayGame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        if (col == 0) {
                            break;
                        }
                        
                        /*
                         * User move.
                         */
                        board.makeMove(col - 1);
                    } else {                 // Computer player
                        /*
                         * Computer move.
                         */
                        board.makeMove(compPlayer.getMove(board));
                    }

                    /*
                     * Print the board to the screen.
                     */
                    System.out.println(board);

                }  //while closes

                if (board.winnerIs() == 1) {
                    System.out.println("Game ended. You win!!!");
                } else {
                    System.out.println("Game ended. Computer won.");
                }

            }




        }

    }

    private int readAndCheckInput(int low, int high) throws IOException {

        BufferedReader move = new BufferedReader(new InputStreamReader(System.in));

        boolean bool;
        int in = 0;

        do {
            try {
                in = Integer.parseInt(move.readLine());
                bool = false;
            } catch (NumberFormatException e) {
                System.out.print("Enter a number between " + low + " and " + high + " >> ");
                bool = true;
            }
        } while (bool);

        while (in < low || in > high) {
            in = Integer.parseInt(move.readLine());
        }

        return in;
    }
}
