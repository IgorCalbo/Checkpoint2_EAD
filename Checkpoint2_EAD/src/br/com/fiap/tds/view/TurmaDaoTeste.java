package br.com.fiap.tds.view;

import br.com.fiap.tds.dao.TurmaDao;
import br.com.fiap.tds.dao.impl.TurmaDaoImpl;
import br.com.fiap.tds.entity.Turma;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class TurmaDaoTeste {

	public static void main(String[] args) {
		
		// Obter uma instancia TurmaDao
		TurmaDao dao = new TurmaDaoImpl(
				EntityManagerFactorySingleton.getInstance().createEntityManager());
		
		// Cadastrar uma turma
		Turma turma = new Turma("2TDSG");
		
		try {
			dao.create(turma);
			dao.commit();
			System.out.println("Turma registrada!");
		} catch (CommitException e) {
			System.out.println("Erro ao cadastrar a turma");
		}
		
		
		// Pesquisar uma turma e exibir os dados
		try {
			turma = dao.findById(1);
			System.out.println(turma.getNome());
		} catch (EntityNotFoundException e) {
			System.out.println("Matéria não encontrada!");
		}
		
		
		// Atualizar uma turma
		turma = new Turma(1, "2TDSF");
		
		try {
			dao.update(turma);
			dao.commit();
			System.out.println("Turma atualizada!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		// Remover uma turma
		try {
			dao.delete(1);
			dao.commit();
			System.out.println("Turma removido!");
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
