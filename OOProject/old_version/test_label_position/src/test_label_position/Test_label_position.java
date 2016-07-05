
package test_label_position;

import java.awt.*;
import javax.swing.*;



public class Test_label_position {
    public JFrame JF ;
    public JLabel JL ;
    
    Test_label_position(){
        JF = new JFrame();
        JF.setSize(500,500);
        JF.setVisible(true);
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JF.setLayout(null);
        
        JL = new JLabel("hello world");

        //JL.setBounds(50, 50, 100, 100);
        JF.add(JL);
    }
    
    public static void main(String[] args) {
       new Test_label_position();
    }
    
}
