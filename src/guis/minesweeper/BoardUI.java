package guis.minesweeper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Creates and manages a JPanel full of button that represent the squares of the playing field.
 * 
 * @author Anthony Christe
 * 
 */
public class BoardUI extends JPanel implements ActionListener {
  private static final long serialVersionUID = -5028688960583260077L;

  /**
   * Length and width of buttons.
   */
  private static final int BUTTON_SIZE = 42;

  /**
   * Game logic management.
   */
  private Board board;

  /**
   * Each Jbutton maps to a square on the board.
   */
  private JButton[][] buttons;

  private int rows;
  private int cols;
  private int mines;
  
  private boolean firstRun = true;

  /**
   * Creates a new game board and maps buttons to the board.
   */
  public BoardUI(Difficulty difficulty) {
    super(new GridLayout(difficulty.rows(), difficulty.cols()));
    this.rows = difficulty.rows();
    this.cols = difficulty.cols();
    this.mines = difficulty.mines();
    newGame();
  }

  private void newGame() {
    board = new Board(rows, cols, mines);
    buttons = new JButton[rows][cols];

    for (int r = 0; r < buttons.length; r++) {
      for (int c = 0; c < buttons[0].length; c++) {
        buttons[r][c] = new JButton();
        buttons[r][c].addActionListener(this);
        buttons[r][c].setPreferredSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
        if(this.firstRun) {
          this.add(buttons[r][c]);
        }
      }
    }
    this.firstRun = false;
    this.updateBoardUI();
  }

  /**
   * Determines which button fired the event, selects that square on the board, and updates the ui.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();

    System.out.println(e);

    if (source instanceof JMenuItem) {
      switch (((JMenuItem) source).getText()) {
      case "New Game":
        this.newGame();
        break;
      case "Exit":
        System.exit(0);
      }
    }

    for (int r = 0; r < buttons.length; r++) {
      for (int c = 0; c < buttons[0].length; c++) {
        if (source.equals(buttons[r][c])) {
          board.selectSquare(r, c);
          updateBoardUI();
          return;
        }
      }
    }
  }

  /**
   * Updates each button on the board to the current state of the game.
   */
  private void updateBoardUI() {
    Square[][] squares = board.getSquares();

    for (int r = 0; r < squares.length; r++) {
      for (int c = 0; c < squares[0].length; c++) {
        updateButtonUI(buttons[r][c], squares[r][c]);
      }
    }

    // Determine if the game has been won or lost
    if (board.getGameOver()) {
      if (board.hasLost()) {
        this.displayGameOverMessage("You lost.");
      }
      else {
        this.displayGameOverMessage("You won!.");
      }
    }
  }

  /**
   * Updates a button depending on the state and type of square on the board.
   * 
   * If the game is over disable and mark button dead. If the square is known and a mine, disable
   * and mark this button as a mine. If the square is known and adjacent to a mine, disable and
   * update the adjacency count. If the square is known, and not adjacent to a mine, disable the
   * button.
   * 
   * Note: I'm sure this could be broken up and simplified a bit.
   * 
   * @param button The button currently being updated.
   * @param square The square corresponding to the button.
   */
  private void updateButtonUI(JButton button, Square square) {
    // Game is over
    if (board.getGameOver() && square.isStateUnknown()) {
      button.setEnabled(false);
      button.setBackground(Color.BLACK);
      button.setText("?");
    }

    // Known state
    if (square.isStateKnown() && button.isEnabled()) {
      button.setEnabled(false);

      // Mine
      if (square.isTypeMine()) {
        button.setText("#");
        button.setBackground(Color.RED);
      }
      // Empty
      else {
        // Neighbors contain mines
        if (square.getAdjacentMines() > 0) {
          button.setText(Integer.toString(square.getAdjacentMines()));
        }
      }
    }
  }

  private void displayGameOverMessage(String msg) {
    JOptionPane.showConfirmDialog(this, msg, "Game Over", JOptionPane.PLAIN_MESSAGE);
  }
}
