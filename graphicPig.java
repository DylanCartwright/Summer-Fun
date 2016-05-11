// File: GraphicsPigLatin.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import acm.program.*;

/**
 *  This program  uses the PigLatin class to convert a line of text to pig latin;
 *  it displays all text in a graphics window.
 *
 *  @author  Jim Schnepf, modified by J. Andrew Whitford Holey
 *  @version October 31, 2013
 */
public class GraphicsPigLatin extends GraphicsProgram {
  
  private JTextField original, translated;
  private JButton destroy;
  
  /**
   * Initialize the program layout
   */
  public void init() {
    addActionListeners();
    original = new JTextField(50);
    translated = new JTextField(50);
    original.addActionListener(this);
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(4, 1));
    p.add(new JLabel("Original:"));
    p.add(original);
    p.add(new JLabel("Pig Latin:"));
    p.add(translated);
    add(p, NORTH);
    destroy=new JButton("Destroy");
    destroy.addActionListener(this);
    add(destroy,SOUTH);
    validate();
  }
  
  /**
   * Display the pig latin text in the translated field when you
   * press Enter on the keyboard.
   */
  public void actionPerformed(ActionEvent event) {
    Object o=event.getSource();
    if (o == original) {
      translated.setText(PigLatin.convertLine(original.getText()));
    }
    else if (o == destroy) {
      destroy();
    }
  }
    
  /**
   * Standard main for a GraphicsProgram
   */
  public static void main(String [] args) {
    new GraphicsPigLatin().start();
  }
}
