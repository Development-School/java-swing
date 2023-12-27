import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumero1;
	private JTextField txtNumero2;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CALCULADORA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(173, 28, 108, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SOMA:");
		lblNewLabel_1.setBounds(50, 61, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero 1");
		lblNewLabel_2.setBounds(50, 86, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero 2");
		lblNewLabel_3.setBounds(150, 86, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtNumero1 = new JTextField();
		txtNumero1.setBounds(50, 106, 46, 20);
		contentPane.add(txtNumero1);
		txtNumero1.setColumns(10);
		
		txtNumero2 = new JTextField();
		txtNumero2.setBounds(150, 106, 46, 20);
		contentPane.add(txtNumero2);
		txtNumero2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Resultado:");
		lblNewLabel_4.setBounds(248, 86, 57, 14);
		contentPane.add(lblNewLabel_4);
		
		txtResultado = new JTextField();
		txtResultado.setBounds(248, 106, 86, 20);
		contentPane.add(txtResultado);
		txtResultado.setColumns(10);
		
		JButton btnCalcularSoma = new JButton("Calcular");
		btnCalcularSoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double nun1 = Double.parseDouble(txtNumero1.getText());
				double nun2 = Double.parseDouble(txtNumero2.getText());
				
				//double soma = (nun1 + nun2);
				txtResultado.setText(String.valueOf(nun1 + nun2));	
			}
		});
		btnCalcularSoma.setBounds(50, 154, 89, 23);
		contentPane.add(btnCalcularSoma);
		
		Label label = new Label("+");
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBounds(113, 106, 15, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("=");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_1.setBounds(213, 106, 22, 22);
		contentPane.add(label_1);
	}
}
