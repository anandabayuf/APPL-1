/*
 * Created By Ananda Bayu Fauzan.
 */
package Tugas2_19Feb2020_Exceptions.A_Currency_Converter;

/**
 *
 * @author Ananda Bayu
 */
// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RatePanel extends JPanel{
    private double[] rate; // exchange rates
    private String[] currencyName;
    private JLabel result;
    JComboBox comboBox;
    JTextField textField;
    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel (){
        JLabel title = new JLabel ("How much is that in dollars?");
        title.setAlignmentX (Component.CENTER_ALIGNMENT);
        title.setFont (new Font ("Helvetica", Font.BOLD, 20));
        
        // Set up the arrays for the currency conversions
        currencyName = new String[] {"Select the currency..",
                                "European Euro", "Canadian Dollar",
                                "Japanese Yen", "Australian Dollar",
                                "Indian Rupee", "Mexican Peso"};
        rate = new double [] {0.0, 1.2103, 0.7351,
                            0.0091, 0.6969,
                            0.0222, 0.0880};
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add (title,gbc);
        
        comboBox = new JComboBox(currencyName);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(comboBox, gbc);
        
        textField = new JTextField();
        textField.setPreferredSize( new Dimension( 50, 30 ) );
        
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(textField, gbc);
        
        
        
        result = new JLabel (" ------------ ");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add (result, gbc);
        Dimension sizeLabel = result.getPreferredSize();
        result.setBounds(100, 3000, sizeLabel.width, sizeLabel.height);
        
        
        comboBox.addActionListener(new ComboListener());
        textField.addActionListener(new ComboListener());
    }
    // ******************************************************
    // Represents an action listener for the combo box.
    // ******************************************************
    private class ComboListener implements ActionListener{
        // --------------------------------------------------
        // Determines which currency has been selected and
        // the value in that currency then computes and
        // displays the value in U.S. Dollars.
        // --------------------------------------------------
        @Override
        public void actionPerformed (ActionEvent event){
            int index = comboBox.getSelectedIndex();
            
            /*result.setText ("1 " + currencyName[index] +
                        " = " + rate[index] + " U.S. Dollars");*/
            try {
                result.setText(textField.getText() + " " + currencyName[index] +
                        " = " + Integer.parseInt(textField.getText()) 
                    * rate[index] + " U.S. Dollars");
            } catch (NumberFormatException e) {
                
            }
        }
    }
}