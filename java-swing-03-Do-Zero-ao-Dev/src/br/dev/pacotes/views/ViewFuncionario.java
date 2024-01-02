package br.dev.pacotes.views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.dev.pacotes.entities.Funcionario;
import br.dev.pacotes.models.ModelFuncionarios;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.Console;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewFuncionario {

	private JFrame frame;
	private JTextField txtCargo;
	private JTable tbFuncionarios;

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
					ViewFuncionario window = new ViewFuncionario();
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
	public ViewFuncionario() {		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		//1ª Opção		
//		Object[] colunas = {"Nome", "Cpf", "Salário", "Cargo", "Teste OP1"};
//		DefaultTableModel model = new DefaultTableModel();
//		model.setColumnIdentifiers(colunas);
		
		//2ª Opção
		ModelFuncionarios model = new ModelFuncionarios();		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 546, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel txtField = new JLabel("Nome");
		txtField.setBounds(10, 58, 46, 14);
		frame.getContentPane().add(txtField);
		
		JLabel textField2 = new JLabel("Cpf");
		textField2.setBounds(10, 83, 46, 14);
		frame.getContentPane().add(textField2);
		
		JLabel textField3 = new JLabel("Sal\u00E1rio");
		textField3.setBounds(10, 108, 46, 14);
		frame.getContentPane().add(textField3);
		
		JLabel textField4 = new JLabel("Cargo");
		textField4.setBounds(10, 133, 46, 14);
		frame.getContentPane().add(textField4);
		
		JTextField txtNome = new JTextField();
		txtNome.setBounds(67, 55, 258, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JTextField txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(66, 80, 258, 20);
		frame.getContentPane().add(txtCpf);
		
		JTextField txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(66, 105, 258, 20);
		frame.getContentPane().add(txtSalario);
		
		//txtCargo = new JTextField();
		JTextField txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(66, 130, 258, 20);
		frame.getContentPane().add(txtCargo);		

		//Cadastrar
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String nome = txtNome.getText();
//				String cpf = txtCpf.getText();
//				double salario = Double.parseDouble(txtSalario.getText());
//				String cargo = txtCargo.getText();
				
//				if(validarCampos(nome, cpf, salario, cargo)) {
//					Funcionario f = new Funcionario(nome, cpf, salario, cargo);
//					model.cadastrarFuncionario(f);	
//					limparCampos(); //Limpar campos de texto após cadastrar novo registro!
//				}					

				//System.out.println(f.getNome() + " " + f.getCpf() + " " + f.getSalario() + " " + f.getCargo());
				
				Funcionario f = new Funcionario(txtNome.getText(), txtCpf.getText(), Double.parseDouble(txtSalario.getText()), txtCargo.getText());
				if(validarCampos(f.getNome(), f.getCpf(), f.getSalario(), f.getCargo())) {
					model.cadastrarFuncionario(f);
					limparCampos();
				}									
			}		
			
			private void limparCampos() {
				// TODO Auto-generated method stub
				txtNome.setText(null);
				txtCpf.setText(null);
				txtSalario.setText(null);
				txtCargo.setText(null);				
			}
			
			public boolean validarCampos(String nome, String cpf, double salario, String cargo) {
				if(nome.trim().isEmpty() || cpf.trim().isEmpty() || cargo.trim().isEmpty() || Double.valueOf(salario).isNaN()) {
				//if(nome.trim().isEmpty() || cpf.trim().isEmpty() || cargo.trim().isEmpty() || Double.valueOf(salario).equals(null)) {
					//JOptionPane.showMessageDialog(this, "Campos não preenchidos!");
					JOptionPane.showMessageDialog(null, "Campos não preenchidos!");
					return false;
				}
				return true;
			}
		});

		btnCadastrar.setBounds(100, 168, 89, 23);
		frame.getContentPane().add(btnCadastrar);
		
		//Remover
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removerFuncionario(tbFuncionarios.getSelectedRow());
				txtNome.setText(null);
				txtCpf.setText(null);
				txtSalario.setText(null);
				txtCargo.setText(null);	
			}
		});
		btnRemover.setBounds(343, 168, 89, 23);
		frame.getContentPane().add(btnRemover);
		
		//Alterar
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario f = new Funcionario(txtNome.getText(), txtCpf.getText(), Double.parseDouble(txtSalario.getText()), txtCargo.getText());
				model.alterarFuncionario(tbFuncionarios.getSelectedRow(), f);
			}
		});
		btnAlterar.setBounds(220, 168, 89, 23);
		frame.getContentPane().add(btnAlterar);				
		
		JScrollPane pane = new JScrollPane();
		pane.setBounds(10, 214, 510, 188);
		frame.getContentPane().add(pane);

		tbFuncionarios = new JTable();		
		
		//Carregar Campos ao formulário
		tbFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//int index = tbFuncionarios.getSelectedRow();
				Funcionario f = model.returnFuncionario(tbFuncionarios.getSelectedRow());
				
				txtNome.setText(f.getNome());
				txtCpf.setText(f.getCpf());
				txtSalario.setText(String.valueOf(f.getSalario()));
				txtCargo.setText(f.getCargo());
			}
		});
		
		tbFuncionarios.setModel(model);			
		pane.setViewportView(tbFuncionarios);		
	}
}
