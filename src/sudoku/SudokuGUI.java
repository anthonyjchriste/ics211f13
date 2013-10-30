package sudoku;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Provides a front end graphical user interface that works seamlessly with the Sudoko and SudokuTest files.
 *
 * @author Amthony Christe
 */
public class SudokuGUI extends JPanel implements ActionListener {
  private static final int SIZE = 9;
  private static JFrame frame;
  private JPanel gridPanel;
  private JPanel menuPanel;
  private JTextField[][] squares;
  private JButton buttonSolve;
  private JButton buttonOpen;
  private JButton buttonSave;
  private JButton buttonLock;
  private JButton buttonVerify;

  /**
   * Specify this layout as a border layout, set the window size, and call the init routine.
   */
  public SudokuGUI() {
    super(new BorderLayout());
    this.setPreferredSize(new Dimension(600, 600));
    init();
  }

  /**
   * Bootstrap the program.
   */
  private static void createAndShowUI() {
    frame = new JFrame("Recursive Sudoku Solver");
    frame.add(new SudokuGUI(), BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JFrame.setDefaultLookAndFeelDecorated(true);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowUI();
      }
    });
  }

  /**
   * Initializes all GUI elements.
   */
  private void init() {
    gridPanel = new JPanel(new GridLayout(SIZE, SIZE));
    menuPanel = new JPanel(new FlowLayout());

    // Text fields representing each sudoko square
    squares = new JTextField[SIZE][SIZE];

    // Initially set all text fields to 0 (empty)
    for (int r = 0; r < SIZE; r++) {
      for (int c = 0; c < SIZE; c++) {
        squares[r][c] = new JTextField("0");
        squares[r][c].setHorizontalAlignment((int) CENTER_ALIGNMENT);
        squares[r][c].setEditable(false);
        gridPanel.add(squares[r][c]);
      }
    }

    // Change colors to 9 different sudoko regions
    colorizeSquares();

    // Menu Buttons
    buttonOpen = new JButton("Open");
    buttonSave = new JButton("Save");
    buttonSolve = new JButton("Solve");
    buttonVerify = new JButton("Verify");
    buttonLock = new JButton("Unlock");

    buttonOpen.addActionListener(this);
    buttonSave.addActionListener(this);
    buttonSolve.addActionListener(this);
    buttonVerify.addActionListener(this);
    buttonLock.addActionListener(this);

    menuPanel.add(buttonOpen);
    menuPanel.add(buttonSave);
    menuPanel.add(buttonSolve);
    menuPanel.add(buttonVerify);
    menuPanel.add(buttonLock);

    // Add the two panels to this
    add(gridPanel, BorderLayout.CENTER);
    add(menuPanel, BorderLayout.SOUTH);
  }

  /**
   * Handles button clicks.
   *
   * @param actionEvent
   */
  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    JButton source = (JButton) actionEvent.getSource();
    // Open button
    if (source == buttonOpen) {
      try {
        openFile();
      } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
      } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
      }
    }

    // Save button
    if (source == buttonSave) {
      try {
        saveFile();
      } catch (IOException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
      }
    }

    // Solve button
    if (source == buttonSolve) {
      solve();
    }

    // Verify button
    if (source == buttonVerify) {
      verify();
    }

    // Lock/Unlock button
    if (source == buttonLock) {
      if (buttonLock.getText().equals("Unlock")) {
        setSquaresEditable(true);
        buttonLock.setText("Lock");
      } else if (buttonLock.getText().equals("Lock")) {
        setSquaresEditable(false);
        buttonLock.setText("Unlock");
      }
    }
  }

  /**
   * Attempts to open a text file representing a partially filled sudoku board.
   * A valid sudoku file is of the following format:
   * <p/>
   * N,N,N,N,N,N,N,N,N
   * N,N,N,N,N,N,N,N,N
   * N,N,N,N,N,N,N,N,N
   * N,N,N,N,N,N,N,N,N
   * N,N,N,N,N,N,N,N,N
   * N,N,N,N,N,N,N,N,N
   * N,N,N,N,N,N,N,N,N
   * N,N,N,N,N,N,N,N,N
   * N,N,N,N,N,N,N,N,N
   * <p/>
   * i.e., 9 rows delimited by a new line, and 9 columns delimited by a comma where each N represents a digit 0 - 9.
   *
   * @throws FileNotFoundException    If the chosen file can not be found.
   * @throws IllegalArgumentException If the data does not match the valid format.
   */
  private void openFile() throws FileNotFoundException, IllegalArgumentException {
    JFileChooser fileChooser = new JFileChooser();
    int returnVal = fileChooser.showDialog(this, "Open");
    Scanner in;
    File file;
    String[] splitLine;

    // If the user has canceled, no need to continue
    if (returnVal != JFileChooser.APPROVE_OPTION) {
      return;
    }

    file = fileChooser.getSelectedFile();
    in = new Scanner(file);

    // Row
    int r = 0;

    // Update squares with data from file
    while (in.hasNextLine()) {
      splitLine = in.nextLine().split(",");

      // Verify the length of the row
      if (splitLine.length != SIZE) {
        throw new IllegalArgumentException(String.format("Row length(%d) not correct in %s at row %d",
                                                         splitLine.length, file, r));
      }

      for (int c = 0; c < SIZE; c++) {
        // Verify each item in row
        if (splitLine[c].length() != 1 || !(Character.isDigit(splitLine[c].charAt(0)))) {
          throw new IllegalArgumentException(String.format("Invalid token %s in %s at row %d col %d",
                                                           splitLine[c], file, r, c));
        }
        // Update square
        squares[r][c].setText(splitLine[c]);
      }
      // Move to next row
      r++;
    }
  }

  /**
   * Save the current state of the sudoku board to a selected file.
   */
  private void saveFile() throws IOException {
    JFileChooser fileChooser = new JFileChooser();
    int returnVal = fileChooser.showDialog(this, "Save");
    BufferedWriter out = null;
    File file;

    // If the user has canceled, no need to continue
    if (returnVal != JFileChooser.APPROVE_OPTION) {
      return;
    }

    file = fileChooser.getSelectedFile();

    out = new BufferedWriter(new FileWriter(file));
    for (int r = 0; r < SIZE; r++) {
      for (int c = 0; c < SIZE; c++) {
        out.write(squares[r][c].getText());
        if (c < SIZE - 1) {
          out.write(",");
        }
      }
      out.write("\n");
    }
    out.close();

  }

  /**
   * Calls the solve method of the Sudoku class.
   */
  private void solve() {
    int[][] sudoku = getSudokuFromSquares();

    if (Sudoku.fillSudoku(sudoku)) {
      update(sudoku);
      JOptionPane.showMessageDialog(this, "Solution found.");
    } else {
      JOptionPane.showMessageDialog(this, "Solution NOT found.");
    }
  }

  /**
   * Calls the checkSudoku method of the Sudoku class.
   */
  private void verify() {
    int[][] sudoku = getSudokuFromSquares();

    if (Sudoku.checkSudoku(sudoku, true)) {
      JOptionPane.showMessageDialog(this, "Sudoku rules do hold.");
    } else {
      JOptionPane.showMessageDialog(this, "Sudoku rules do NOT hold.");
    }
  }

  /**
   * Sets all text fields to either editable or not-editable.
   * @param editable The state of the text fields.
   */
  private void setSquaresEditable(boolean editable) {
    for (int r = 0; r < SIZE; r++) {
      for (int c = 0; c < SIZE; c++) {
        squares[r][c].setEditable(editable);
      }
    }
  }

  /**
   * Colors the 9 different regions with a checkerboard effect.
   * I'm sure this isn't the most elegant solution, but it's the best I could come up with in a short time. Please
   * feel free to improve.
   */
  private void colorizeSquares() {
    for (int r = 0; r < SIZE; r++) {
      for (int c = 0; c < SIZE; c++) {
        // First three rows
        if (r >= 0 && r <= 2) {
          // First three columns
          if (c >= 0 && c <= 2) {
            squares[r][c].setBackground(Color.BLACK);
            squares[r][c].setForeground(Color.WHITE);
          }
          // Middle three columns
          if (c >= 3 && c <= 5) {
            squares[r][c].setBackground(Color.WHITE);
          }
          // Lsat three columns
          if (c >= 6 && c <= 8) {
            squares[r][c].setBackground(Color.BLACK);
            squares[r][c].setForeground(Color.WHITE);
          }
        }

        // Middle three rows
        if (r >= 3 && r <= 5) {
          // First three columns
          if (c >= 0 && c <= 2) {
            squares[r][c].setBackground(Color.WHITE);
          }
          // Middle three columns
          if (c >= 3 && c <= 5) {
            squares[r][c].setBackground(Color.BLACK);
            squares[r][c].setForeground(Color.WHITE);
          }
          // Last three columns
          if (c >= 6 && c <= 8) {
            squares[r][c].setBackground(Color.WHITE);
          }
        }

        // Last three rows
        if (r >= 6 && r <= 8) {
          // First three columns
          if (c >= 0 && c <= 2) {
            squares[r][c].setBackground(Color.BLACK);
            squares[r][c].setForeground(Color.WHITE);
          }
          // Middle three columns
          if (c >= 3 && c <= 5) {
            squares[r][c].setBackground(Color.WHITE);
          }
          // Last three columns
          if (c >= 6 && c <= 8) {
            squares[r][c].setBackground(Color.BLACK);
            squares[r][c].setForeground(Color.WHITE);
          }
        }
      }
    }
  }

  /**
   * Given a 2d int array representation of the board, update the text field squares with those values.
   *
   * @param sudoku The 2d array representing the sudoku board.
   */
  public void update(int[][] sudoku) {
    // Verify that the size of the array is correct
    if ((sudoku.length != SIZE) || (sudoku[0].length != SIZE)) {
      throw new IllegalArgumentException("Sudoku size does not match squares size");
    }

    for (int r = 0; r < SIZE; r++) {
      for (int c = 0; c < SIZE; c++) {
        squares[r][c].setText(Integer.toString(sudoku[r][c]));
      }
    }
  }

  /**
   * Return a 2d array representation of the sudoku board given the current values of the text fields making up the
   * squares.
   *
   * @return A 2d integer array representation of the sudoku board.
   */
  public int[][] getSudokuFromSquares() {
    int[][] sudoku = new int[SIZE][SIZE];
    for (int r = 0; r < SIZE; r++) {
      for (int c = 0; c < SIZE; c++) {
        sudoku[r][c] = Integer.parseInt(squares[r][c].getText());
      }
    }
    return sudoku;
  }
}