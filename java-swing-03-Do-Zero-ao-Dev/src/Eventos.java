import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eventos {

	private JFrame frame;
	private JTextField txtArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eventos window = new Eventos();
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
	public Eventos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtArea = new JTextField();
		txtArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//Semelhante ao Hover (CSS)	
				txtArea.setText("Entrou!");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtArea.setText("");
			}
		});
		txtArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtArea.setBounds(161, 103, 112, 36);
		frame.getContentPane().add(txtArea);
		txtArea.setColumns(10);
		
		JButton btnClique = new JButton("Clique aqui");
		btnClique.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnClique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtArea.setText("Clicou!!!");
			}
		});
		btnClique.setBounds(171, 150, 89, 23);
		frame.getContentPane().add(btnClique);
	}

}
