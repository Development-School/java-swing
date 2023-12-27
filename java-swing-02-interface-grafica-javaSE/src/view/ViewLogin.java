package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ViewLogin {

	private JFrame frame;
	private JTextField txtLogin;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                //if ("Nimbus".equals(info.getName())) {
            	if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);
        }
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin window = new ViewLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(98, 88, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(98, 155, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(98, 113, 235, 20);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkLogin(txtLogin.getText(), new String(txtPassword.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema");
				}
				else {
					//JOptionPane.showMessageDialog(null, "Dados inválidos!");
						//ou
					//JOptionPane.showMessageDialog(null, "Dados inválidos!", "Título da Janela", JOptionPane.INFORMATION_MESSAGE);
					//JOptionPane.showMessageDialog(null, "Dados inválidos!", "Título da Janela", JOptionPane.ERROR_MESSAGE);
					JOptionPane.showMessageDialog(null, "Dados inválidos!", "Título da Janela", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEnter.setBounds(171, 228, 89, 23);
		frame.getContentPane().add(btnEnter);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(98, 182, 235, 23);
		frame.getContentPane().add(txtPassword);
	}
	
	//Chegar senha
	public boolean checkLogin(String login, String senha) {
		return login.equals("usuario") && senha.equals("123");
	}
}
