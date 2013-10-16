package guis.minesweeper;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Creates and displays this MineSweeper game.
 * 
 * @author Anthony Christe
 * 
 */
public class MineSweeper extends JApplet {
  private static final long serialVersionUID = 3958689290041063677L;
  private JFrame frame;
  private static int rows = 10;
  private static int cols = 10;
  private static int mines = 10;
  
  public MineSweeper() {
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JFrame.setDefaultLookAndFeelDecorated(true);
    frame.add(new BoardUI(Difficulty.EASY), BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }
  
  @Override
  public void init() {
    this.add(new MineSweeper());
  }

  /**
   * Read in the size arguments for the board and create the GUI.
   * 
   * @param args The first argument should be the number of rows, the second should be the number of
   * columns, and the third should be the number of mines.
   */
  public static void main(String[] args) {
    if (args.length < 3) {
      System.out.println("usage: java -jar MineSweeper.jar rows columns mines");
      return;
    }

    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MineSweeper();
      }
    });
  }
}

