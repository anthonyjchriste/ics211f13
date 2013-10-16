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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BasicActionListener extends JPanel implements ActionListener {
  private static JFrame frame = null;
  private JButton buttonA, buttonB;
  private JTextField fieldA, fieldB;

  public BasicActionListener() {
    super(new FlowLayout());

    buttonA = new JButton("A");
    buttonB = new JButton("B");
    fieldA = new JTextField("Foo");
    fieldB = new JTextField("Bar");

    buttonA.addActionListener(this);
    buttonB.addActionListener(this);

    this.add(buttonA);
    this.add(buttonB);
    this.add(fieldA);
    this.add(fieldB);
    this.setPreferredSize(new Dimension(500, 200));
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == buttonA) {
      JOptionPane.showMessageDialog(this, fieldA.getText(), "Button Alert", JOptionPane.DEFAULT_OPTION);
    }

    if(e.getSource() == buttonB) {
      JOptionPane.showMessageDialog(this, fieldB.getText(), "Button Alert", JOptionPane.DEFAULT_OPTION);
    }
  }

  private static void createAndShowUI() {
    frame = new JFrame("Simple UI");
    frame.add(new BasicActionListener(), BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
