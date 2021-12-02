package br.com.fiap.tds.view;


import br.com.fiap.tds.dao.EscolaDao;
import br.com.fiap.tds.dao.impl.EscolaDaoImpl;
import br.com.fiap.tds.entity.Escola;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class EscolaDaoTeste {

	public static void main(String[] args) {
		
		// Obter uma instancia EscolaDao
		EscolaDao dao = new EscolaDaoImpl(
				EntityManagerFactorySingleton.getInstance().createEntityManager());
		
		// Cadastrar uma escola
		Escola escola = new Escola("FIAP School", "Avenida Paulista");
		
		try {
			dao.create(escola);
			dao.commit();
			System.out.println("Escola registrada!");
		} catch (CommitException e) {
			System.out.println("Erro ao cadastrar o escola");
		}
		
		// Pesquisar uma escola e exibir os dados
		try {
			escola = dao.findById(1);
			System.out.println(escola.getNome() + " " + escola.getEndereco());
		} catch (EntityNotFoundException e) {
			System.out.println("Escola não encontrada!");
		}
		
		
		// Atualizar uma escola
		escola = new Escola(1, "FIAP School 22", "Avenida Paulista");
		
		try {
			dao.update(escola);
			dao.commit();
			System.out.println("Escola atualizado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		// Remover uma escola
		try {
			dao.delete(1);
			dao.commit();
			System.out.println("Escola removido!");
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
