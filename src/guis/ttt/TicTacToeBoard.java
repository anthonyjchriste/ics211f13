package guis.ttt;

import java.util.ArrayList;
import java.util.Random;

public class TicTacToeBoard {
	public static final int EMPTY 	= 0;
	public static final int X 		= 1;
	public static final int Y 		= 2;
	
	private int[][] board;
	private int playerScore = 0;
	private int AIScore		= 0;
	private int drawScore	= 0;
	private int size		= 0;
	
	public TicTacToeBoard() {
		board = new int[3][3];
	}
	
	public void newGame() {
		size = 0;
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				board[r][c] = EMPTY;
			}
		}
	}
	
	public boolean move(int r, int c) {
		if(board[r][c] == EMPTY) {
			board[r][c] = X;
			size++;
			return true;
		}
		return false;
	}
	
	public int[][] didWin(final int player) {
		int[][] result = new int[3][2];
		
		if(board[0][0] == player && board[0][1] == player && board[0][2] == player) {
			result[0][0] = 0;
			result[0][1] = 0;
			result[1][0] = 0;
			result[1][1] = 1;
			result[2][0] = 0;
			result[2][1] = 2;	
		} else if(board[1][0] == player && board[1][1] == player && board[1][2] == player) {
			result[0][0] = 1;
			result[0][1] = 0;
			result[1][0] = 1;
			result[1][1] = 1;
			result[2][0] = 1;
			result[2][1] = 2;	
		} else if(board[2][0] == player && board[2][1] == player && board[2][2] == player) {
			result[0][0] = 2;
			result[0][1] = 0;
			result[1][0] = 2;
			result[1][1] = 1;
			result[2][0] = 2;
			result[2][1] = 2;	
		} else if(board[0][0] == player && board[1][0] == player && board[2][0] == player) {
			result[0][0] = 0;
			result[0][1] = 0;
			result[1][0] = 1;
			result[1][1] = 0;
			result[2][0] = 2;
			result[2][1] = 0;	
		} else if(board[0][1] == player && board[1][1] == player && board[2][1] == player) {
			result[0][0] = 0;
			result[0][1] = 1;
			result[1][0] = 1;
			result[1][1] = 1;
			result[2][0] = 2;
			result[2][1] = 1;	
		} else if(board[0][2] == player && board[1][2] == player && board[2][2] == player) {
			result[0][0] = 0;
			result[0][1] = 3;
			result[1][0] = 1;
			result[1][1] = 3;
			result[2][0] = 2;
			result[2][1] = 3;	
		} else if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			result[0][0] = 0;
			result[0][1] = 0;
			result[1][0] = 1;
			result[1][1] = 1;
			result[2][0] = 2;
			result[2][1] = 2;	
		} else if(board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			result[0][0] = 0;
			result[0][1] = 2;
			result[1][0] = 1;
			result[1][1] = 1;
			result[2][0] = 2;
			result[2][1] = 0;	
		} else if(size == 9) {
			result[0][0] = -2;
			drawScore++;
		} else {
			result[0][0] = -1;
		}
		
		if(result[0][0] > -1) {
			switch(player) {
				case X: playerScore++; break;
				case Y: AIScore++; break;
			}
		}
		
		return result;
	}
	
	public int[] moveAI(boolean useAI) {
		size++;
		if(useAI) {
			return moveWithAI();
		} else {
			return moveWithRandom();
		}
	}
	
	private int[] moveWithAI() {
		return new int[0];
	}
	
	private int[] moveWithRandom() {
		ArrayList<int[]> emptySquares 	= new ArrayList<int[]>();
		int[] rowCol 					= new int[2];
		Random rand 					= new Random();
		
		for(int r = 0; r < board.length; r++) 
			for(int c = 0; c < board.length; c++) 
				if(board[r][c] == EMPTY) 
					emptySquares.add(new int[] {r, c});
		
		rowCol = emptySquares.get(rand.nextInt(emptySquares.size()));
		board[rowCol[0]][rowCol[1]] = Y;
		return rowCol;
	}
	
	public int getPlayerScore() {
		return this.playerScore;
	}
	
	public int getAIScore() {
		return this.AIScore;
	}
	
	public int getDrawScore() {
		return this.drawScore;
	}
}
