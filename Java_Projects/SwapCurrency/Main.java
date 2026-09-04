import javax.swing.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("SwapCurrency");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel title = new JLabel("Currency Converter");
        title.setBounds(130, 20, 200, 30);
        frame.add(title);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(50, 80, 100, 30);
        frame.add(amountLabel);

        JTextField amountField = new JTextField();
        amountField.setBounds(150, 80, 150, 30);
        frame.add(amountField);

        String[] currencies = {"USD", "INR", "EUR"};
        JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(50, 130, 100, 30);
        frame.add(fromCurrency);

        JComboBox<String> toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(200, 130, 100, 30);
        frame.add(toCurrency);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(130, 180, 100, 30);
        frame.add(convertButton);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(50, 230, 300, 30);
        frame.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String from = fromCurrency.getSelectedItem().toString();
                    String to = toCurrency.getSelectedItem().toString();

                    double rate = getRate(from, to);
                    double result = amount * rate;

                    resultLabel.setText("Result: " + result);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid amount");
                }
            }
        });

        frame.setVisible(true);
    }

    static double getRate(String from, String to) {
        if (from.equals("USD") && to.equals("INR")) return 83.12;
        if (from.equals("INR") && to.equals("USD")) return 0.012;
        if (from.equals("USD") && to.equals("EUR")) return 0.92;
        if (from.equals("EUR") && to.equals("USD")) return 1.08;
        if (from.equals("INR") && to.equals("EUR")) return 0.011;
        if (from.equals("EUR") && to.equals("INR")) return 90.0;
        return 1.0;
    }
}

