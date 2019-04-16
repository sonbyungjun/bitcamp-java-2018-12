package ch30;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Test extends JFrame {
  JButton b1 = new JButton("1");
  JButton b2 = new JButton("2");
  JButton b3 = new JButton("3");
  
  public Test() {
    super("제목을 여기에");
    
    this.setLayout(new FlowLayout());
    
    this.add(b1);
    this.add(b2);
    this.add(b3);
    
    this.setSize(300, 400);
    
    this.setVisible(true);
    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args) {
    new Test();
  }
}
