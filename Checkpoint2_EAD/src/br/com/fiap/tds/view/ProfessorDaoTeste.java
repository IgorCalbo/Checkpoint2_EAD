package br.com.fiap.tds.view;

import br.com.fiap.tds.dao.ProfessorDao;
import br.com.fiap.tds.dao.impl.ProfessorDaoImpl;
import br.com.fiap.tds.entity.Professor;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class ProfessorDaoTeste {

	public static void main(String[] args) {
	
		// Obter uma instancia ProfessorDao
		ProfessorDao dao = new ProfessorDaoImpl(
				EntityManagerFactorySingleton.getInstance().createEntityManager());
	
	
	// Cadastrar uma professor
	Professor professor = new Professor("Peter", 931314414, "Formado em línguas");
	
	try {
		dao.create(professor);
		dao.commit();
		System.out.println("Professor registrado!");
	} catch (CommitException e) {
		System.out.println("Erro ao cadastrar o professor");
	}
	
	// Pesquisar um professor e exibir os dados
			try {
				professor = dao.findById(1);
				System.out.println(professor.getNome() + " " + professor.getSenha() + professor.getEspecificacao());
			} catch (EntityNotFoundException e) {
				System.out.println("Professor não encontrado!");
			}
	
			
			// Atualizar um professor
			professor = new Professor("George", 81282181, "Formado em exatas");
			
			try {
				dao.update(professor);
				dao.commit();
				System.out.println("Professor atualizado!");
			} catch (CommitException e) {
				System.out.println(e.getMessage());
			}
			
			
			// Remover um professor
			try {
				dao.delete(1);
				dao.commit();
				System.out.println("Professor removido!");
			} catch (EntityNotFoundException | CommitException e) {
				System.out.println(e.getMessage());
			}
			
	}
	
}
