
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class calcGUI extends JFrame {

    private static final String[] OPERATIONS = {
        "Addition (a + b)",
        "Subtraction (a - b)",
        "Multiplication (a × b)",
        "Division (a ÷ b)",
        "Square (a²)",
        "Cube (a³)",
        "Square Root (√a)",
        "Cube Root (∛a)",
        "Modulus (a % b)",
        "Power (a^b)",
        "Factorial (a!)",
        "Sine   (sin a°)",
        "Cosine (cos a°)",
        "Tangent(tan a°)"
    };

    private final JComboBox<String> opBox = new JComboBox<>(OPERATIONS);
    private final JTextField txtA = new JTextField(8);
    private final JTextField txtB = new JTextField(8);
    private final JLabel resultLbl = new JLabel("Result: —");

    public calcGUI() {
        super("Simple Calculator GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(35, 25));
        setResizable(false);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("Operation:"));
        top.add(opBox);
        add(top, BorderLayout.NORTH);

        JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT));
        center.add(new JLabel("a:"));
        center.add(txtA);
        center.add(new JLabel("b:"));
        center.add(txtB);
        add(center, BorderLayout.CENTER);

        JButton btnCompute = new JButton("Compute");
        btnCompute.addActionListener(this::compute);
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottom.add(btnCompute);
        bottom.add(resultLbl);
        add(bottom, BorderLayout.SOUTH);

        opBox.addActionListener(e -> updateOperandState());
        updateOperandState(); 

        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    private void updateOperandState() {
        int idx = opBox.getSelectedIndex();
        boolean needsTwo = (idx <= 3) || idx == 8 || idx == 9; 
        txtB.setEnabled(needsTwo);
        if (!needsTwo) {
            txtB.setText("");
        }
    }

    private static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    private void compute(ActionEvent e) {
        try {
            double a = Double.parseDouble(txtA.getText().trim());
            double b = txtB.isEnabled() ? Double.parseDouble(txtB.getText().trim()) : 0;
            int op = opBox.getSelectedIndex();
            String ans;

            switch (op) {
                case 0 ->
                    ans = String.format("%.6f", a + b);
                case 1 ->
                    ans = String.format("%.6f", a - b);
                case 2 ->
                    ans = String.format("%.6f", a * b);
                case 3 ->
                    ans = (b == 0) ? "Error: ÷0" : String.format("%.6f", a / b);
                case 4 ->
                    ans = String.format("%.6f", a * a);
                case 5 ->
                    ans = String.format("%.6f", a * a * a);
                case 6 ->
                    ans = (a < 0) ? "Error: √ of negative" : String.format("%.6f", Math.sqrt(a));
                case 7 ->
                    ans = String.format("%.6f", Math.cbrt(a));
                case 8 ->
                    ans = (b == 0) ? "Error: %0" : String.format("%.6f", a % b);
                case 9 ->
                    ans = String.format("%.6f", Math.pow(a, b));
                case 10 -> {
                    if (a < 0 || a != (int) a) {
                        ans = "Error: factorial only for non-negative integers";
                    } else {
                        ans = String.valueOf(factorial((int) a));
                    }
                }
                case 11 ->
                    ans = String.format("%.6f", Math.sin(Math.toRadians(a)));
                case 12 ->
                    ans = String.format("%.6f", Math.cos(Math.toRadians(a)));
                case 13 ->
                    ans = String.format("%.6f", Math.tan(Math.toRadians(a)));
                default ->
                    ans = "—";
            }

            resultLbl.setText("Result: " + ans);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numeric values (e.g., 2, 2.5, -7).",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(calcGUI::new);
    }
}
