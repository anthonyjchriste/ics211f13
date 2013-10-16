package guis.ttt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

@SuppressWarnings({"serial","unchecked"})
public class TicTacToe extends JPanel implements ActionListener {
  private static JFrame frame   = null;
  // Game state
  private int player        = TicTacToeBoard.X;
  private TicTacToeBoard game   = new TicTacToeBoard();
  private boolean useAI     = false;
  
  // Menu and status bar
  JMenuBar menuBar        = null;
  JMenu menu            = null;
  JMenuItem menuItem        = null;
  JRadioButtonMenuItem rbMenu   = null;
  ButtonGroup group       = null;
  JPanel pnlStatus        = null;
  JLabel lblScore         = null;
  
  // Board components
  private JPanel pnlBoard     = null;
  private JButton[][] buttons;
  private ImageIcon[][][] icons = null;
  
  public TicTacToe() {
    super(new BorderLayout());
    initUI();
  }
  
  public final void initUI() {
    // Menu bar
    menuBar = new JMenuBar();
    menu  = new JMenu("File");
    group   = new ButtonGroup();
    
    rbMenu  = new JRadioButtonMenuItem("Random AI");
    rbMenu.addActionListener(this);
    rbMenu.setActionCommand("random");
    rbMenu.setSelected(true);
    group.add(rbMenu);
    menu.add(rbMenu);
    
    rbMenu  = new JRadioButtonMenuItem("Minimax AI");
    rbMenu.addActionListener(this);
    rbMenu.setActionCommand("minimax");
    group.add(rbMenu);
    menu.add(rbMenu);
    
    menu.addSeparator();
    
    menuItem = new JMenuItem("Exit");
    menuItem.addActionListener(this);
    menuItem.setActionCommand("exit");
    menu.add(menuItem);
    
    menuBar.add(menu);
    frame.setJMenuBar(menuBar);
    
    // Status bar
    pnlStatus = new JPanel(new FlowLayout());
    lblScore = new JLabel("Player:0 AI:0 Draws:0", JLabel.RIGHT);
    pnlStatus.add(lblScore);
    this.add(pnlStatus, BorderLayout.SOUTH);
    
    // Buttons 
    pnlBoard = new JPanel(new GridLayout(3, 3, 5, 5));
    pnlBoard.setPreferredSize(new Dimension(600, 600));
    pnlBoard.setBackground(java.awt.Color.BLACK);
    
    icons = new ImageIcon[3][3][3];
    for(int r = 0; r < icons.length; r++) {
      for(int c = 0; c < icons[0].length; c++) {
        for(int d = 0; d < icons[0][0].length; d++) {
          switch(d) {
            case 0: icons[r][c][d] = new ImageIcon("img/img" + r + "" + c + ".jpg"); break;
            case 1: icons[r][c][d] = new ImageIcon("img/img" + r + "" + c + "x.jpg"); break;
            case 2: icons[r][c][d] = new ImageIcon("img/img" + r + "" + c + "o.jpg"); break;
          }
        }
      }
    }
    
    buttons = new JButton[3][3];
    for(int r = 0; r < buttons.length; r++) {
      for(int c = 0; c < buttons[0].length; c++) {
        buttons[r][c] = new JButton(icons[r][c][0]);
        buttons[r][c].addActionListener(this);
        pnlBoard.add(buttons[r][c]);
      }
    }
    this.add(pnlBoard, BorderLayout.CENTER);
  }
  
  private static void createAndShowUI() {
    frame = new JFrame("JTicTacToe");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new TicTacToe(), BorderLayout.CENTER);
    JFrame.setDefaultLookAndFeelDecorated(true);
    frame.pack();
    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent evt) {
    int[] AIMove;
    
    if(evt.getActionCommand().equals("random")) {
      useAI = false;
      return;
    }
    if(evt.getActionCommand().equals("minimax")) {
      useAI = true;
      return;
    }
    if(evt.getActionCommand().equals("exit")) {
      System.exit(0);
    }
    
    for(int r = 0; r < buttons.length; r++) {
      for(int c = 0; c < buttons[0].length; c++) {
        if(evt.getSource() == buttons[r][c] && game.move(r, c)) {
          updateUI(TicTacToeBoard.X, r, c);
          if(!checkWin(TicTacToeBoard.X)) {
            AIMove = game.moveAI(useAI);
            updateUI(TicTacToeBoard.Y, AIMove[0], AIMove[1]);
            checkWin(TicTacToeBoard.Y);
          }
        }
      }
    }
  }
  
  private void updateUI(final int player, int r, int c) {
    int move = (player == TicTacToeBoard.X) ? 1 : 2;
    buttons[r][c].setIcon(icons[r][c][move]);
  }
  
  private void resetUI() {
    for(int r = 0; r < buttons.length; r++)
      for(int c = 0; c < buttons[0].length; c++)
        buttons[r][c].setIcon(icons[r][c][0]);
  }
  
  
  private boolean checkWin(final int player) {
    int[][] results = game.didWin(player);
    String playerStr = (player == TicTacToeBoard.X) ? "X" : "O";
    if(results[0][0] > -1) {
      lblScore.setText("Player:" + game.getPlayerScore() + " AI:" + game.getAIScore() + " Draws:" + game.getDrawScore());
      showDialog("Player " + playerStr + " wins!");
      game.newGame();
      resetUI();
      return true;
    } else if(results[0][0] == -2) {
      lblScore.setText("Player:" + game.getPlayerScore() + " AI:" + game.getAIScore() + " Draws:" + game.getDrawScore());
      showDialog("Draw!");
      game.newGame();
      resetUI();
      return true;
    }
    return false;
  }
  
  private void showDialog(String message) {
    int n = JOptionPane.showConfirmDialog(frame, message + " Play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
    if(n == JOptionPane.NO_OPTION) System.exit(0);
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowUI();
      }
    });
  }
}
