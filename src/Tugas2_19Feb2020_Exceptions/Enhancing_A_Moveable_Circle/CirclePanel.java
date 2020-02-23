/*
 * Created By Ananda Bayu Fauzan.
 */
package Tugas2_19Feb2020_Exceptions.Enhancing_A_Moveable_Circle;

/**
 *
 * @author Ananda Bayu
 */
// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CirclePanel extends JPanel{
    private final int CIRCLE_SIZE = 50;
    private int x,y, width, height;
    private Color c;
    JButton left = new JButton("Left");
    JButton right = new JButton("Right");
    JButton up = new JButton("Up");
    JButton down = new JButton("Down");
    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public CirclePanel(int width, int height){
        // Set coordinates so circle starts in (0, 0)
        x = 0;
        y = 0;
        c = Color.green;
        this.width = width;
        this.height = height;
        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
        // Create buttons to move the circle
        
        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));
        down.addActionListener(new MoveListener(0,20));
        
        left.setMnemonic(KeyEvent.VK_L);
        right.setMnemonic(KeyEvent.VK_R);
        up.setMnemonic(KeyEvent.VK_U);
        down.setMnemonic(KeyEvent.VK_D);
        
        left.setToolTipText("Move the circle to the left as much as 20");
        right.setToolTipText("Move the circle to the right as much as 20");
        up.setToolTipText("Move the circle up as much as 20");
        down.setToolTipText("Move the circle down as much as 20");
        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
    }
    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    @Override
    public void paintComponent(Graphics page){
        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }
    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener{
        private int dx;
        private int dy;
        //---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        //---------------------------------------------------------------
        public MoveListener(int dx, int dy){
            this.dx = dx;
            this.dy = dy;
        }
        //---------------------------------------------------------------
        // Change x and y coordinates and repaint.
        //---------------------------------------------------------------
        @Override
        public void actionPerformed(ActionEvent e){
            if(dx == 0){
                if(y + dy < 0)
                    up.setEnabled(false);
                else{
                    if(y + dy > height)
                        down.setEnabled(false);
                    else{
                        y += dy;
                        x += dx;
                        repaint();
                        up.setEnabled(true);
                        down.setEnabled(true);
                    }
                }
            }
            else{
                if(x + dx < 0)
                    left.setEnabled(false);
                else{
                    if(x + dx > width)
                        right.setEnabled(false);
                    else{
                        y += dy;
                        x += dx;
                        repaint();
                        left.setEnabled(true);
                        right.setEnabled(true);
                    }
                }
            }
        }
    }
}