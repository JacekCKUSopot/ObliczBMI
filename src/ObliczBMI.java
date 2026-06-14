import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObliczBMI extends JFrame {

    private JLabel lblWaga;
    private JTextField txtWaga;
    private JLabel lblWzrost;
    private JTextField txtWzrost;
    private JButton btnBMI;
    private JLabel lblWynik;

    public ObliczBMI() {
        setTitle("Kalkulator BMI");
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));

        lblWaga = new JLabel("Waga (kg): ");
        txtWaga = new JTextField(6);
        lblWzrost = new JLabel("Wzrost (m): ");
        txtWzrost = new JTextField(6);
        btnBMI = new JButton("Oblicz BMI");
        lblWynik = new JLabel("Wynik: ");

        panel.add(lblWaga);
        panel.add(txtWaga);
        panel.add(lblWzrost);
        panel.add(txtWzrost);
        panel.add(btnBMI);
        panel.add(lblWynik);

        btnBMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double waga = Double.parseDouble(txtWaga.getText());
                    double wzrost = Double.parseDouble(txtWzrost.getText());
                    double wzrostCm = wzrost / 100.0;
                    double bmi = waga / (wzrostCm * wzrostCm);
                    // Wyświetlamy wynik z dokładnością do 2 miejsc po przecinku
                    lblWynik.setText(String.format("Twoje BMI wynosi: %.2f", bmi));
                } catch (NumberFormatException ex) {
                    // Obsługa błędu – użytkownik wpisał nieprawidłową wartość
                    lblWynik.setText("Błąd! Podaj liczbę.");
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ObliczBMI();
    }
}