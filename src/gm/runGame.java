/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gm;

import java.io.*;
import java.util.*;

/**
 *
 * @author Angel
 */
public class runGame {
    public static void main(String args[]) throws Exception
{
 Board b; playerSearch p,k;
 b=new Board(7,6);
 p=new playerSearch();
 k=new playerSearch();
 
 BufferedReader move = new BufferedReader(new 
 InputStreamReader(System.in));
 
while((b.winnerIs()==0) && b.validMovesLeft())
 {
if(b.cp == b.PLAYER_ONE)
	
  b.makeMove(Integer.parseInt(move.readLine()));// Make it so!
 else
 b.makeMove(p.getMove(b));// Make it so!
 System.out.println(b);
  
 }
 
}
}
