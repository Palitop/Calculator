import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.KeyListener;

public class Calculator extends JFrame implements KeyListener {

    JTextField panel;
    JTextField panelresult;

    String textpanel = "";
    String secuence = "";

    ArrayList<Character> symbols = new ArrayList();

    String[][] matrix = new String[4][4];

    public Calculator() {
        this.setSize(275, 350);
        this.setTitle("Calculator");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.addKeyListener(this);
        initComponents();
    }

    private void fill() {
        int num = 9;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = String.valueOf(num);
                num--;
            }
        }
        matrix[0][3] = "+";
        matrix[1][3] = "-";
        matrix[2][3] = "*";
        matrix[3][3] = "/";
        matrix[3][0] = "C";
        matrix[3][1] = "0";
        matrix[3][2] = "=";
    }

    private void initComponents() {
        panel = new JTextField();
        panelresult = new JTextField();
        fill();

        int x = 5;
        int y = 80;

        int a = 0;
        int c = 0;

        for (int i = 0; i < 4 * 4; i++) {
            JButton b = new JButton();
            b.setBounds(x, y, 60, 55);
            b.setText(matrix[a][c]);
            String s = matrix[a][c];
            getContentPane().add(b);
            x += 68;
            if (matrix[a][c].equalsIgnoreCase("C")) {
                b.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textpanel = "";
                        panel.setText(null);
                    }
                });
            } else if (matrix[a][c].equalsIgnoreCase("=")) {
                b.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        secuence = panel.getText();
                        tokens(secuence);
                    }
                });
            } else {
                b.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textpanel += s;
                        panel.setText(textpanel);
                    }
                });
            }
            c++;
            if (x == (68 * 4) + 5) {
                c = 0;
                a++;
                x = 5;
                y += 60;
            }
        }       

        panel.setBounds(5, 5, 265, 35);
        panel.setBackground(Color.white);
        panel.setBorder(null);
        panel.setFont(new Font ("Courier", 1, 15));
        panel.setEditable(false);
        getContentPane().add(panel);
        
        panelresult.setBounds(5, 40, 265, 35);
        panelresult.setFont(new Font ("Courier", 1, 25));
        panelresult.setBackground(Color.white);
        panelresult.setHorizontalAlignment(JTextField.RIGHT);
        panelresult.setBorder(null);
        panelresult.setEditable(false);
        getContentPane().add(panelresult);
    }

    private void tokens(String s) {
        String aux = "";
        ArrayList<Integer> numeros = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) && i != s.length()-1) {
                aux += s.charAt(i);
            } else if (i == s.length()-1) {
                aux += s.charAt(i);
                numeros.add((int) Integer.parseInt(aux));
            } else {
                numeros.add((int) Integer.parseInt(aux));
                aux = "";
                symbols.add(s.charAt(i));
            }
        }
        
        panelresult.setText(String.valueOf(operations (symbols.get(0), numeros.get(0), numeros.get(1))));
        symbols.clear();
        numeros.clear();
        textpanel = "";
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        char c = ke.getKeyChar();
        if (Character.isDigit(c)) {
            System.out.println(c);
            switch (c) {
                case 0:
                    textpanel += 0;
                    panel.setText(textpanel);
                    break;
                case 1:
                    textpanel += 1;
                    panel.setText(textpanel);
                    break;
                case 2:
                    textpanel += 2;
                    panel.setText(textpanel);
                    break;
                case 3:
                    textpanel += 3;
                    panel.setText(textpanel);
                    break;
                case 4:
                    textpanel += 4;
                    panel.setText(textpanel);
                    break;
                case 5:
                    textpanel += 5;
                    panel.setText(textpanel);
                    break;
                case 6:
                    textpanel += 6;
                    panel.setText(textpanel);
                    break;
                case 7:
                    textpanel += 7;
                    panel.setText(textpanel);
                    break;
                case 8:
                    textpanel += 8;
                    panel.setText(textpanel);
                    break;
                case 9:
                    textpanel += 9;
                    panel.setText(textpanel);
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int operations(char symbol, int a, int b) {
        int result = 0;
        switch (symbol) {
            case '+':
                result = sum(a, b);
                break;
            case '-':
                result = rest(a, b);
                break;
            case '*':
                result = multiplication(a, b);
                break;
            case '/':
                result = division(a, b);
                break;
        }
        return result;
    }

    private void result(String s) {
        String aux = "";
        ArrayList<Integer> numbers = new ArrayList();
        ArrayList<Character> symbols = new ArrayList();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*' && s.charAt(i) != '/') {
                aux += s.charAt(i);
            } else {
                symbols.add(s.charAt(i));
                result = Integer.parseInt(aux);
                numbers.add(result);
            }
        }

    }

    private int sum(int a, int b) {
        return a + b;
    }

    private int rest(int a, int b) {
        return a - b;
    }

    private int multiplication(int a, int b) {
        return a * b;
    }

    private int division(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.setVisible(true);
    }

}
