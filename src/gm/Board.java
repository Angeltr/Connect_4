package gm;


/**
 * 
 * @author Angelos Trigkas
 * 
 * Class Board implements the board that the game is played on.
 */
public class Board {

	private final static int PLAYER_ONE = 1;
	private final static int PLAYER_TWO = -1;
	private final static int EMPTY = 0;

	private Point[][] grid;		// The game grid
	private int[] heights;		// Number of pieces added to each column as the game progresses

	private int cols;	// Number of columns of the game grid
	private int rows;	// Number of rows of the game grid

	private int[] moves;	// moves history, stores the moves made by each player as the game progresses
	private int lm;         // moves counter

	private int cp;		// Current player
	private Point[][] cl;


        /**
         * Constructor. Creates a Board object.
         * 
         * @param columns  number of columns of the board
         * @param inrows   number of rows of the board
         */
        public Board(int columns, int inrows) {
		
		cols = columns;
		rows = inrows;
		grid = new Point[cols][rows];
		heights = new int[cols];
		moves = new int[cols*rows];
		lm = -1;
		
		/* Set heights to zero and initialise all points to EMPTY. */
		for(int x=0; x<cols;x++)
		{
			heights[x]=0;
			for(int y=0;y<rows;y++)
				grid[x][y]=new Point(x,y,EMPTY); 

		}
		generateCL();
		cp=PLAYER_ONE;
	}

        
        public void generateCL()
	{
		cl=new Point[69][4];
		int count=0;
		// horz segs
		for(int y=0;y<rows;y++)
		{
			for(int x=0;x<cols-3;x++)
			{
				Point[] temp = new Point[4];
				for(int i=x;i<x+4;i++)
					temp[i-x]=grid[i][y];
				cl[count]=temp;
				count++;
			}

		}

		// vert segs
		for(int x=0;x<cols;x++)
		{
			for(int y=0;y<rows-3;y++)
			{
				Point[] temp = new Point[4];
				for(int i=y;i<y+4;i++)
					temp[i-y]=grid[x][i];
				cl[count]=temp;
				count++;
			}

		}

		// diag segs
		for(int x=0;x<cols-3;x++)
		{
			for(int y=0;y<rows-3;y++)
			{
				Point[] temp = new Point[4];
				for(int t=x,i=y;t<x+4 && i<y+4;t++,i++)
					temp[i-y]=grid[t][i];
				cl[count]=temp;
				count++;
			}

		}
		for(int x=0;x<cols-3;x++)
		{
			for(int y=rows-1;y>rows-4;y--)
			{
				Point[] temp = new Point[4];
				for(int t=x,i=y;t<x+4 && i>-1;t++,i--)
					temp[t-x]=grid[t][i];
				cl[count]=temp;
				count++;
			}
		}


	}
	
        /**
         * A move is valid if there are less than 6 pieces 
         * in the particular column.
         * 
         * @param column  the column attempted to be inserted a piece
         * @return  TRUE if the move is valid, FALSE otherwise
         */
        public boolean validMove(int column) {
		return heights[column]<rows;
	}

        /**
         * Executes a move:
         *  - Sets the state of the point the piece is placed in, 
         *    depending on the player making the move
         *  - Adjusts the height of the column that the piece is 
         *    dropped in
         *  - Increments the number of moves
         *  - Stores the column in which the piece is added
         *  - changes the current player
         * 
         * @param column  the column in which the piece will be dropped
         */
        public void makeMove(int column) {
		grid[column][heights[column]].setState(cp);
		heights[column]++;
		lm++;
		moves[lm]=column;
		cp=-cp;
	}

        /**
         * Executes the opposite actions from makeMove() method.
         * Used by the computer player to decide the best move.
         */
        public void undoMove() {

		grid[moves[lm]][heights[moves[lm]]-1].setState(EMPTY);
		heights[moves[lm]]--;
		lm--;
		cp=-cp;
	}


        /**
         * 
         * @return TRUE if there are valid moves left, FALSE otherwise
         */
        public boolean validMovesLeft() {
		return lm<moves.length-1;
	}


        /**
         * 
         * @return  1 if the user is the winner
         *          2 if the computer is the winner
         *          0 if there is no winner yet
         */
        public int winnerIs() {
		for (int i = 0; i < cl.length; i++) {
			
			if (getScore(cl[i])==4) {
				return PLAYER_ONE;
			}
			else if(getScore(cl[i])==-4)
				return PLAYER_TWO;
		}
		
		return 0;
	}

	private int getScore(Point[] points) {
		
		int playerone = 0;
		int playertwo = 0;
		
		for (int i = 0; i < points.length; i++) {
			
			if (points[i].getState() == Board.PLAYER_ONE) {
				playerone++;
			}
			else if (points[i].getState() == Board.PLAYER_TWO) {
				playertwo++;
			}
		}
		
		if ( (playerone+playertwo > 0) && (!(playerone > 0 && playertwo > 0)) ) {
			return (playerone != 0) ? playerone : playertwo;
		}
		else {
			return 0;
		}
	}


        public int getStrength() {
		int sum = 0;
		int[] weights = {0,1,10,50,600};
		
		for (int i = 0; i < cl.length; i++) {
			sum += (getScore(cl[i]) > 0) ? weights[Math.abs(getScore(cl[i]))] : -weights[Math.abs(getScore(cl[i]))];
		}
		return sum + (cp == PLAYER_ONE ? 16 : -16);
	}

        /**
         * Prints the Board to the screen.
         * @return 
         */
	public String toString() {
		String temp = "";
		
		for (int y = rows-1; y > -1; y--) {
			
			for (int x = 0; x < cols; x++) {
				if (grid[x][y].getState() == EMPTY) {
					temp = temp + "-";
				}
				else if (grid[x][y].getState() == PLAYER_ONE) {
					temp = temp + "O";
				}
				else {
					temp = temp + "X";
				}
			}
			temp += "\n";
		}
		return temp;
	}
	
        
        /**
         * Sets current player.
         * @param cp player to be set
         */
	void setCP(int cp) {
		this.cp = cp;
	}
	
        /**
         * Returns the current player.
         * @return  1 for the user
         *         -1 for the computer
         */
	int getCP() {
		return cp;
	}
	
	
        /**
         * Returns the height of a column.
         * 
         * @param col the requested columns height
         * @return  height of column col
         */
        public int getHeight(int col) {
		return this.heights[col];
	}

        /**
         * Return a move from history.
         * @param lm  move to be returned
         * @return  the corresponding column
         */
        public int getMove(int lm) {
		return this.moves[lm];
	}
	
        /**
         * 
         * @return lm
         */
        public int getLm() {
		return this.lm;
	}
}
