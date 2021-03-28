package currencyconverter;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class Currencyconverter extends JFrame implements ActionListener {

    private Container container;
    private JLabel title;
    private Font font, font2;
    private JComboBox box;
    private JTextField get;
    private JTextArea output;
    private JScrollPane pane;
    private JButton Convert, Clear;
    private final String[] money = {"BD TO USD", "USD TO BD", "BD TO EURO", "EURO TO BD", "EURO TO USD", "USD TO EURO", "POUND TO EURO", "POUND TO USD", "POUND TO BD", "POUND TO CAD", "BD TO POUND", "USD TO POUND"};

    Currencyconverter() {
        this.setBounds(300, 200, 500, 400);
        this.setTitle("Currency Converter");
        initComponents();
    }

    public void initComponents() {
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.green);
        //create font Style//
        font = new Font("Arial", Font.BOLD, 35);
        font2 = new Font("Arial", Font.BOLD, 20);

        //title create in currency converter application//
        title = new JLabel("Currency Converter");
        title.setBounds(0, 0, 500, 80);
        title.setOpaque(true);
        title.setBackground(Color.red);
        title.setForeground(Color.black);
        title.setFont(font);
        title.setHorizontalAlignment(JLabel.CENTER);
        container.add(title);

        //////CREATE JCOMBO box////
        box = new JComboBox(money);
        box.setBounds(25, 110, 200, 50);
        box.setEditable(true);
        box.setFont(font2);
        container.add(box);

        //create Jtext Field////
        get = new JTextField();
        get.setBounds(25, 180, 200, 50);
        get.setFont(font2);
        container.add(get);

        //create Jtext Area output//
        output = new JTextArea();
        output.setFont(font2);
        output.setBackground(Color.WHITE);
        output.setForeground(Color.BLACK);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setEditable(false);

        // Create JScrollPane  ....//
        pane = new JScrollPane(output);
        pane.setBounds(245, 110, 220, 120);
        container.add(pane);

        //Create JButton///
        Convert = new JButton("CONVERT");
        Convert.setBounds(20, 260, 220, 50);
        Convert.setFont(font);
        Convert.setBackground(Color.red);
        Convert.setForeground(Color.black);
        container.add(Convert);

        //Clear Jbutton//
        Clear = new JButton("CLEAR");
        Clear.setBounds(245, 260, 220, 50);
        Clear.setFont(font);
        Clear.setBackground(Color.red);
        Clear.setForeground(Color.black);
        container.add(Clear);

        Convert.addActionListener(this);
        Clear.addActionListener(this);
        get.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent input) {

        if (input.getSource() == Convert);
        {
            try {
                SetCalculation();//method
            } catch (Exception excep) {
                JOptionPane.showMessageDialog(null, excep + "Try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (input.getSource() == get);
        {
            try {
                SetCalculation();
            } catch (Exception excep) {
                JOptionPane.showMessageDialog(null, excep + "Try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (input.getSource() == Clear);
        {
            output.setText("");
            get.setText("");
        }

    }

    public void SetCalculation() //method
    {
        String s = box.getSelectedItem().toString();

        DecimalFormat formate = new DecimalFormat("0.00000");

        String d = get.getText();

        if (d.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Any Number", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            if (s == money[0] ) {
                
                double BD = Double.valueOf(get.getText());
                double USD = BD * 0.01173;
                String output = String.valueOf(formate.format(USD));
                this.output.setText(""+USD);
                
            } else if (s == money[1]) {
                double USD = Double.valueOf(get.getText());
                double BD = USD / 0.01173;
                String out = String.valueOf(formate.format(BD));
                this.output.setText(out + "TK");
            }

        }

    }

    public static void main(String[] args) {
        Currencyconverter converter = new Currencyconverter();        
        converter.setVisible(true);
        converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
