package guis.minesweeper;

public enum Difficulty {
  EASY (8, 8, 8),
  MEDIUM (10, 10, 20),
  HARD (9, 9, 40),
  HELL(10, 10, 99),
  CUSTOM (-1, -1, -1);
  
  
  private int rows;
  private int cols;
  private int mines; 
  
  private Difficulty(int rows, int cols, int mines) {
    this.rows = rows;
    this.cols = cols;
    this.mines = mines;
  }
  
  public int rows() {
    return this.rows;
  }
  
  public int cols() {
    return this.cols;
  }
  
  public int mines() {
    return this.mines;
  }
}
