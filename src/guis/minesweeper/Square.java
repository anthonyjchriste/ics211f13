package guis.minesweeper;

/**
 * Represents the type and state of a single square on the board.
 * 
 * @author Anthony Christe
 * 
 */
public class Square {
  /**
   * The type of square this is.
   * 
   * @see SquareType
   */
  private SquareType type;

  /**
   * The current state of this square.
   * 
   * @see SquareState
   */
  private SquareState state;

  /**
   * The number of adjacent squares to this squares that contain mines.
   */
  private int adjacentMines;

  /**
   * Each square on the board can only be empty or a mine.
   */
  public enum SquareType {
    EMPTY, MINE;
  }

  /**
   * Determines if the contents of the square are known or unknown to a player.
   */
  public enum SquareState {
    KNOWN, UNKNOWN;
  }

  /**
   * Creates a new instance of an unknown square of desired SquareType.
   * @param type The SquareType to initially set this square as.
   * @see SquareType
   * @see SquareState
   */
  public Square(SquareType type) {
    this.type = type;
    this.state = SquareState.UNKNOWN;
    this.adjacentMines = 0;
  }

  /**
   * Returns the type of this square.
   * @return The SquareType of this square.
   * @see SquareType
   */
  public SquareType getSquareType() {
    return this.type;
  }

  /**
   * Sets the type of this square.
   * @param type The SquareType to set this square to.
   * @see SquareType
   */
  public void setSquareType(SquareType type) {
    this.type = type;
  }

  /**
   * Gets the current SquareState.
   * @return The current SquareState.
   * @see SquareState
   */
  public SquareState getSquareState() {
    return this.state;
  }

  /**
   * Updates the current SquareState.
   * @param state The new SquareState.
   * @see SquareState
   */
  public void setSquareState(SquareState state) {
    this.state = state;
  }

  /**
   * Returns the number of squares adjacent to this square which contain mines.
   * @return The number of squares adjacent to this square which contain mines.
   */
  public int getAdjacentMines() {
    return this.adjacentMines;
  }

  /**
   * Update the number of squares adjacent to this square which contain mines.
   * @param adjacentMines The number of squares adjacent to this square which contain mines.
   */
  public void setAdjacentMines(int adjacentMines) {
    this.adjacentMines = adjacentMines;
  }

  /**
   * Determine is this square's type is empty.
   * @return True if this square's type is empty.
   */
  public boolean isTypeEmpty() {
    return this.type.equals(SquareType.EMPTY);
  }

  /**
   * Determine is this square's type is mine.
   * @return True if this square's type is mine.
   */
  public boolean isTypeMine() {
    return this.type.equals(SquareType.MINE);
  }

  /**
   * Determine is this square's state is known.
   * @return True if this square's state is known.
   */
  public boolean isStateKnown() {
    return this.state.equals(SquareState.KNOWN);
  }

  /**
   * Determine is this square's state is unknown.
   * @return True if this square's state is unknown.
   */
  public boolean isStateUnknown() {
    return this.state.equals(SquareState.UNKNOWN);
  }
}
