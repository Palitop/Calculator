import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class Calculator extends JFrame {

    JTextArea panel;

    String textpanel = "";

    ArrayList<Character> symbols = new ArrayList();

    String[][] matrix = new String[4][4];

    public Calculator() {
        this.setSize(300, 370);
        this.setTitle("Calculator");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
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
        panel = new JTextArea();
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
            x += 78;
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
            if (x == (78 * 4) + 5) {
                c = 0;
                a++;
                x = 5;
                y += 60;
            }
        }

        panel.setBounds(5, 5, 290, 70);
        panel.setEditable(false);
        getContentPane().add(panel);
    }

    private void tokens(String s) {
        String aux = "";
        for (int i = 0; i < s.length(); i++) {
//            if () {
//                aux += s.charAt(i);
//            }else {
//                
//            }

        }
    }

//    private boolean different (char c) {
//        char symbols [] = new char [4];
//        for (int i = 0; i < 4; i++) {
//            if (c == symbols [i]) {
//                return true;
//            }
//        }
//        return false;
//    }
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
