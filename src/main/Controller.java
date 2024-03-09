package org.example;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Controller extends JFrame {
    public static Polynomial parsePolynomial(String input) {
        Polynomial polynomial = new Polynomial();
        Pattern pattern = Pattern.compile("([+-]?\\d*\\.?\\d*)?x(\\^(\\d+))?");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String monom = matcher.group();
            String semn = "+";
            if (monom.startsWith("+") || monom.startsWith("-")) {
                semn = monom.substring(0, 1);monom = monom.substring(1);}
            Double coeficient = 1.0; Integer exponent = 0;
            if (monom.contains("x")) {
                if (monom.equals("x")) {
                    if(semn.equals("+"))
                    {coeficient=1.0;}
                    else
                    {coeficient=-1.0;}} else {
                    if (monom.startsWith("x")) {
                        coeficient = 1.0;} else {
                        coeficient = Double.parseDouble(monom.substring(0, monom.indexOf("x")));}
                    if (monom.contains("^")) {
                        exponent = Integer.parseInt(monom.substring(monom.indexOf("^") + 1));} else {
                        exponent = 1;}}} else {
                coeficient = Double.parseDouble(monom);
                exponent = 0;}
            if (semn.equals("-")) {
                coeficient = -coeficient;}
            polynomial.addMonom(exponent, coeficient);}
        return polynomial;}
    public ImageIcon image;
    public Controller() {
        setTitle("Calculator Polinoame");setSize(920, 920);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);setLayout(null);
        JPanel mainPanel = new JPanel();
        JLabel textLabel = new JLabel("Calculator Polinoame");
        textLabel.setBounds(50, 50, getWidth(), 50);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        Font font = new Font("Times New Roman", Font.PLAIN, 50);
        textLabel.setFont(font);add(textLabel);
        textLabel.setForeground(Color.CYAN);
        JLabel text1= new JLabel("Polinom1");
        text1.setBounds(60, 150, 200, 100);
        Font font1 = new Font("Times New Roman", Font.PLAIN, 40);
        text1.setFont(font1);add(text1);
        text1.setForeground(Color.CYAN);
        JLabel text2= new JLabel("Polinom2");
        text2.setBounds(60, 200, 200, 100);
        Font font2 = new Font("Times New Roman", Font.PLAIN, 40);
        text2.setFont(font2);add(text2);
        text2.setForeground(Color.CYAN);
        JTextField textField1 = new JTextField();
        textField1.setBounds(220, 170, 600, 50);
        textField1.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        textField1.setForeground(Color.PINK);add(textField1);
        JTextField textField2 = new JTextField();
        textField2.setBounds(220, 230, 600, 50);
        textField2.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        textField2.setForeground(Color.PINK);add(textField2);
        JTextField textFieldRezultat = new JTextField();
        textFieldRezultat.setBounds(60, 400, 800, 70);
        textFieldRezultat.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        textFieldRezultat.setForeground(Color.PINK);add(textFieldRezultat);
        JLabel text3 = new JLabel("Rezultat");
        text3.setBounds(60, 300, getWidth(), 50);
        text3.setHorizontalAlignment(JLabel.CENTER);
        Font font3 = new Font("Times New Roman", Font.PLAIN, 50);
        text3.setFont(font3);add(text3);
        text3.setForeground(Color.MAGENTA);
        JButton button1 = new JButton("Adunare");
        button1.setBounds(60, 500, 100, 50);
        button1.setSize(350, 100);
        button1.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        button1.setForeground(Color.CYAN);add(button1);
        Operatii operatii=new Operatii();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = textField1.getText();
                String input2 = textField2.getText();
                Polynomial polinom1 = parsePolynomial(input1);
                Polynomial polinom2 = parsePolynomial(input2);
                Polynomial result = operatii.addPolynomials(polinom1, polinom2);
                textFieldRezultat.setText(result.toString());

            }
        });
        JButton button2 = new JButton("Inmultire");
        button2.setBounds(60, 610, 100, 50);
        button2.setSize(350, 100);
        add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = textField1.getText();
                String input2 = textField2.getText();
                Polynomial polinom1 = parsePolynomial(input1);
                Polynomial polinom2 = parsePolynomial(input2);
                Polynomial result = operatii.mulPolynomials(polinom1, polinom2);
                textFieldRezultat.setText(result.toString());

            }
        });
        JButton button3 = new JButton("Integrare");
        button3.setBounds(60, 720, 100, 50);
        button3.setSize(350, 100);
        add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = textField1.getText();
                String input2 = textField2.getText();
                Polynomial polinom1 = parsePolynomial(input1);
                Polynomial result = operatii.integratePolynomial(polinom1);
                textFieldRezultat.setText(result.toString());
            }
        });
        JButton button4 = new JButton("Scadere");
        button4.setBounds(450, 500, 100, 50);
        button4.setSize(350, 100);
        add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = textField1.getText();
                String input2 = textField2.getText();
                Polynomial polinom1 = parsePolynomial(input1);
                Polynomial polinom2 = parsePolynomial(input2);
                Polynomial result = operatii.subtractPolynomials(polinom1, polinom2);
                textFieldRezultat.setText(result.toString());
            }
        });
        JButton button5 = new JButton("Impartire");
        button5.setBounds(450, 610, 100, 50);
        button5.setSize(350, 100);
        add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = textField1.getText();
                String input2 = textField2.getText();
                Polynomial polinom1 = parsePolynomial(input1);
                Polynomial polinom2 = parsePolynomial(input2);
                Polynomial result = operatii.divPolynomials(polinom1, polinom2);
                textFieldRezultat.setText(result.toString());
            }
        });

        JButton button6 = new JButton("Derivare");
        button6.setBounds(450, 720, 100, 50);
        button6.setSize(350, 100);
        add(button6);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = textField1.getText();
                String input2 = textField2.getText();
                Polynomial polinom = parsePolynomial(input1);
                Polynomial result = operatii.derivatePolynomial(polinom);
                textFieldRezultat.setText(result.toString());
            }
        });
        button1.setBackground(Color.MAGENTA);button2.setBackground(Color.MAGENTA);
        button3.setBackground(Color.MAGENTA);button4.setBackground(Color.MAGENTA);
        button5.setBackground(Color.MAGENTA);button6.setBackground(Color.MAGENTA);
        button2.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        button2.setForeground(Color.CYAN);
        button3.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        button3.setForeground(Color.CYAN);
        button4.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        button4.setForeground(Color.CYAN);
        button5.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        button5.setForeground(Color.CYAN);
        button6.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        button6.setForeground(Color.CYAN);

        ImageIcon icon = new ImageIcon("poza_interfata2.jpg");
        Image img = icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(img);
        JLabel label = new JLabel(newIcon);
        label.setBounds(0, 0, getWidth(), getHeight());
        add(label);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        setVisible(true);
    }
    public static void main(String[] args) {
        Controller controller = new Controller();

    }
}
