package guis;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BasicGUI {
  private static JFrame frame = null;
  private static JPanel panel = null;
  private static JButton button   = null;

  private static void createAndShowUI() {
    frame   = new JFrame("Simple UI");
    panel   = new JPanel(new FlowLayout());
    button  = new JButton("Push Me!");

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(panel, "You pushed me!" , "Button Alert", JOptionPane.DEFAULT_OPTION);
      }
    });

    panel.add(button);
    frame.add(panel, BorderLayout.CENTER);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel.setPreferredSize(new Dimension(1200, 700));
    JFrame.setDefaultLookAndFeelDecorated(true);
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowUI();
      }
    });
  }
}
