package guis.minesweeper;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import guis.minesweeper.Square.SquareState;
import guis.minesweeper.Square.SquareType;

/**
 * Represents the state of a rectangular board.
 * 
 * @author Anthony Christe
 * 
 */
public class Board {
  /**
   * A rectangular set of squares.
   * 
   * @see Square
   */
  private Square[][] board;

  /**
   * Determines when a game is over.
   */
  private boolean gameOver;
  
  /**
   * Determines if game was won or lost. 
   */
  private boolean lost;
  
  /**
   * Creates a new rectangular board filled with empty squares and a random number of mines.
   * 
   * This also updates the number of mines that are adjacent to each square.
   * 
   * @param rows The number of rows in the board.
   * @param cols The number of columns in the board.
   * @param mines The number of mines in the board.
   */
  public Board(int rows, int cols, int mines) {
    this.board = new Square[rows][cols];
    this.gameOver = false;

    // Fill the board with empty squares
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        board[r][c] = new Square(SquareType.EMPTY);
      }
    }

    // Randomly select N (where N = mines) squares to be a mine
    List<Square> squares = new LinkedList<Square>();
    for (int r = 0; r < board.length; r++) {
      squares.addAll(Arrays.asList(board[r]));
    }
    Collections.shuffle(squares);
    squares = squares.subList(0, mines);

    for (Square square : squares) {
      square.setSquareType(SquareType.MINE);
    }

    // Re-scan and count how many mines are adjacent to each square
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        board[r][c].setAdjacentMines(this.countAdjacentMines(r, c));
      }
    }
  }

  /**
   * Selects a square on the board.
   * 
   * Depending on the state and type of the square, one of three actions will take place. The game
   * will end, the square will be marked as known, or a path of safe squared will be found.
   * 
   * This will be called from the UI when the user selects a button corresponding with a square.
   * 
   * @param row The row of square.
   * @param col The column of the square.
   */
  public void selectSquare(int row, int col) {
    Square square = board[row][col];
    System.out.println("selecting");
    // This square has been previously selected
    if (square.isStateKnown()) {
      return;
    }

    // User selected a mine
    if (square.isTypeMine()) {
      this.lost = true;
      this.gameOver();
    }
    // This square is safe, but N or more neighbors are mines
    else if (square.getAdjacentMines() > 0) {
      square.setSquareState(SquareState.KNOWN);
    }
    // Safe and no adjacent mines, uncover safe path
    else {
      markFreePath(row, col);
    }
    // Check to see if user won
    if(didWin()) {
      this.gameOver();
    }
  }

  /**
   * Recursively marks all adjacent squares that are not adjacent to a mine.
   * 
   * This will create a path of squares that are adjacent to no mines. The out walls of the path
   * are squares that are adjacent to mines and the first layer of those are revealed.
   * 
   * @param row The current row the square is in.
   * @param col The current column the square is in.
   */
  private void markFreePath(int row, int col) {
    Square square = board[row][col];

    // We've found a mine or an already known square
    if (square.isStateKnown() || square.isTypeMine()) {
      return;
    }

    // Now that we've visited this square, mark as known
    square.setSquareState(SquareState.KNOWN);

    // Adjacent to any mines?
    if (square.getAdjacentMines() > 0) {
      return;
    }

    // Recursively call on all eight neighbors
    for (int r = row - 1; r <= row + 1; r++) {
      for (int c = col - 1; c <= col + 1; c++) {
        if (isInBounds(r, c) && !(r == row && c == col)) {
          markFreePath(r, c);
        }
      }

    }
  }

  /**
   * If the only remaining unknown squares are mines, then the user won.
   */
  private boolean didWin() {
    for(Square[] row : board) {
      for(Square square : row) {
        if(square.isStateUnknown() && square.isTypeEmpty()) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Has this game been lost?
   * @return If this game has been lost.
   */
  public boolean hasLost() {
    return this.lost;
  }
  
  /**
   * Mark all mines as known when game has ended.
   */
  private void gameOver() {
    this.gameOver = true;
    for (Square[] row : board) {
      for (Square square : row) {
        if (square.isTypeMine() && square.isStateUnknown()) {
          square.setSquareState(SquareState.KNOWN);
        }
      }
    }
  }

  /**
   * Returns the squares stored in the board object.
   * @return The squares stored in the board object.
   */
  public Square[][] getSquares() {
    return this.board;
  }

  /**
   * Return whether or not the game has ended.
   * @return If the game ha ended.
   */
  public boolean getGameOver() {
    return this.gameOver;
  }

  /**
   * Finds the number of mines adjacent to a square.
   * @param row The row of the square.
   * @param col The column of the square.
   * @return The number of mines adjacent to a square.
   */
  public int countAdjacentMines(int row, int col) {
    int mines = 0;
    for (int r = row - 1; r <= row + 1; r++) {
      for (int c = col - 1; c <= col + 1; c++) {
        if (isInBounds(r, c) && !(r == row && c == col) && board[r][c].isTypeMine()) {
          mines++;
        }
      }
    }
    return mines;
  }

  /**
   * Tests that a given row and column are within the bounds of the board.
   * @param row The row to test.
   * @param col The column to test.
   * @return Whether or not a given row and column are within the bounds of the board.
   */
  public boolean isInBounds(int row, int col) {
    return (row >= 0) && (row < board.length) && (col >= 0) && (col < board[0].length);
  }
}
