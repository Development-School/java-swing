package br.dev.pacotes.models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.dev.pacotes.entities.Funcionario;

public class ModelFuncionarios extends AbstractTableModel {

	ArrayList<Funcionario> funcionarios = new ArrayList<>();
	
	//1ª Opção (Comentado pois retorna da ViewFuncionario)
	//String[] colunas = {"Nome", "Cpf", "Salário", "Cargo"};

	//2ª Opção (Se descomentado Retornará da ModelFuncionario)
	String[] colunas = {"Nome", "Cpf", "Salário", "Cargo"};
	
	public void cadastrarFuncionario(Funcionario f) {
		funcionarios.add(f);
		this.fireTableDataChanged(); //Atualizar tabelas sempre que adicionado novo registro
	}
	
	public Funcionario returnFuncionario(int index) {
		return funcionarios.get(index);
	}
	
	public void alterarFuncionario(int index, Funcionario f) {
		funcionarios.set(index, f);
		this.fireTableDataChanged();
	}
	
	public void removerFuncionario(int index) {
		funcionarios.remove(index);
		this.fireTableDataChanged();
	}
	
	public String[] getColunas() {
		return colunas;
	}
	
	@Override
	public int getRowCount() {
		return funcionarios.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return funcionarios.get(rowIndex).getNome();
		}else if(columnIndex == 1) {
			return funcionarios.get(rowIndex).getCpf();
		}else if(columnIndex == 2) {
			return funcionarios.get(rowIndex).getSalario();
		}
		else if(columnIndex == 3) {
			return funcionarios.get(rowIndex).getCargo();
		}
		return columnIndex;
	}

	
	
}
