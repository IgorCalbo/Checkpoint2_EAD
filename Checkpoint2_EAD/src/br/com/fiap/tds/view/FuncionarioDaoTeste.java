package br.com.fiap.tds.view;

import br.com.fiap.tds.dao.FuncionarioDao;
import br.com.fiap.tds.dao.impl.FuncionarioDaoImpl;
import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class FuncionarioDaoTeste {

	public static void main(String[] args) {
		
		// Obter uma instancia FuncionarioDao
		FuncionarioDao dao = new FuncionarioDaoImpl(
				EntityManagerFactorySingleton.getInstance().createEntityManager());
		
		// Cadastrar um funcionario
		Funcionario funcionario = new Funcionario(511661168, "Alexandre", 977654132, 
				"Avenida Paulista", Genero.MASCULINO, 3000.0);
		
		try {
			dao.create(funcionario);
			dao.commit();
			System.out.println("Funcionario registrada!");
		} catch (CommitException e) {
			System.out.println("Erro ao cadastrar o funcionario");
		}
		
		
		// Pesquisar um funcionario e exibir os dados
				try {
					funcionario = dao.findById(1);
					System.out.println(funcionario.getCpf() + " " + funcionario.getNome() +  " "
							+ funcionario.getCelular() + " " + funcionario.getEndereco() + " "
							+ funcionario.getGenero() + " " + funcionario.getSalario());
				} catch (EntityNotFoundException e) {
					System.out.println("Funcionario não encontrada!");
				}
		
				
				// Atualizar um funcionario
				funcionario = new Funcionario(511661168, "Juliana", 832144132, 
						"Avenida Paulista", Genero.FEMININO, 6000.0);
				
				try {
					dao.update(funcionario);
					dao.commit();
					System.out.println("Funcionario atualizado!");
				} catch (CommitException e) {
					System.out.println(e.getMessage());
				}
				
				
				// Remover um funcionario
				try {
					dao.delete(1);
					dao.commit();
					System.out.println("Funcionario removido!");
				} catch (EntityNotFoundException | CommitException e) {
					System.out.println(e.getMessage());
				}
				
				
	}
	
}
