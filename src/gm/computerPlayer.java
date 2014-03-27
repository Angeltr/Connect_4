package gm;

/**
 * 
 * @author Angelos Trigkas
 * 
 * Class computerPlayer implements the Artificial Intelligence
 * used behind the computer player.
 *
 */



public class computerPlayer {
	
	// should return a number
	int getMove(Board cB) {
		int[] moves = new int[7];
		int highest = 0;
		
		for (int i = 0; i < 7; i++) {
			moves[i] = Integer.MIN_VALUE;
			
			if (cB.validMove(i)) {
				cB.makeMove(i);
				moves[i] = minValue(cB,6);
				
				if (moves[i]>=moves[highest]) {
					highest=i;
				}
				cB.undoMove();
			} 
			//System.out.print(moves[i] + " | ");
		}
		//System.out.println();
		return highest;
	}
	
	
	// don't change this unless you understand it
	int minValue(Board cB, int ply) {
		
		int[] moves = new int[7];
		int lowest = 0;
		
		for (int i = 0; i < 7; i++) {
			moves[i] = Integer.MAX_VALUE;
			
			if (cB.validMove(i)) {
				cB.makeMove(i);
				
				if ((cB.winnerIs() == 0) && ply>0) {
					moves[i] = maxValue(cB,ply-1);
				}
				else {
					moves[i] = -cB.getStrength();
				}
				
				if (moves[i]<moves[lowest]) {
					lowest=i;
				}
				cB.undoMove();
			}
			//System.out.print(moves[i] + " ");
		}
		//System.out.println();
		return moves[lowest];
	}
	
	
	//careful with this
	int maxValue(Board cB, int ply) {
		//System.out.print("Max" + ply + ": ");
		int[] moves = new int[7];
		int highest = 0;
		
		for (int i = 0; i < 7; i++) {
			moves[i] = Integer.MAX_VALUE; 
			
			if (cB.validMove(i)) {
				cB.makeMove(i);
				
				if ((cB.winnerIs() == 0) && ply>0) {
					moves[i] = minValue(cB,ply-1);
				}
				else {
					moves[i] =-cB.getStrength();
				}
				
				if (moves[i]<moves[highest]) {
					highest=i;
				}
				cB.undoMove();
			}
			//System.out.print(moves[i] + " ");
		}
		//System.out.println();
		return moves[highest];
	}

}
