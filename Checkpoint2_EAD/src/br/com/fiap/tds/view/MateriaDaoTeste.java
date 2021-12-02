package br.com.fiap.tds.view;

import br.com.fiap.tds.dao.MateriaDao;
import br.com.fiap.tds.dao.impl.MateriaDaoImpl;
import br.com.fiap.tds.entity.Materia;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class MateriaDaoTeste {

	public static void main(String[] args) {
		
		// Obter uma instancia MateriaDao
		MateriaDao dao = new MateriaDaoImpl(
				EntityManagerFactorySingleton.getInstance().createEntityManager());
		
		// Cadastrar uma materia
		Materia materia = new Materia("Química");
		
		try {
			dao.create(materia);
			dao.commit();
			System.out.println("Matéria registrada!");
		} catch (CommitException e) {
			System.out.println("Erro ao cadastrar a matéria");
		}
		
		// Pesquisar uma escola e exibir os dados
				try {
					materia = dao.findById(1);
					System.out.println(materia.getNome());
				} catch (EntityNotFoundException e) {
					System.out.println("Matéria não encontrada!");
				}
		
				
				// Atualizar uma escola
				materia = new Materia(1, "Física");
				
				try {
					dao.update(materia);
					dao.commit();
					System.out.println("Matéria atualizada!");
				} catch (CommitException e) {
					System.out.println(e.getMessage());
				}
				
				// Remover uma escola
				try {
					dao.delete(1);
					dao.commit();
					System.out.println("Matéria removido!");
				} catch (EntityNotFoundException | CommitException e) {
					System.out.println(e.getMessage());
				}
				
	}
	
}
