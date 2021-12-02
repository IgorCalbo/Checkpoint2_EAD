package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.tds.dao.AlunoDao;
import br.com.fiap.tds.dao.impl.AlunoDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class AlunoDaoTeste {

	public static void main(String[] args) {
		
		// Obter uma instancia AlunoDao
		AlunoDao dao = new AlunoDaoImpl(
				EntityManagerFactorySingleton.getInstance().createEntityManager());
		
		// Cadastrar um aluno
		Aluno aluno = new Aluno("Fred", 
				new GregorianCalendar(2000,Calendar.NOVEMBER, 19),
				947443421, Genero.MASCULINO, 12345678, "Avenida Paulista", 
				"Marcos", 95674197);
		
		try {
			dao.create(aluno);
			dao.commit();
			System.out.println("Aluno registrado!");
		} catch (CommitException e) {
			System.out.println("Erro ao cadastrar o aluno");
		}
		
				// Pesquisar um aluno e exibir os dados
				try {
					aluno = dao.findById(1);
					System.out.println(aluno.getNome() + " " + aluno.getDataNascimento() + 
							" " + aluno.getCelular() + " " + aluno.getGenero() + " " + 
							aluno.getSenha() + aluno.getEndereco() + aluno.getNomeResponsavel() 
							+ " " + aluno.getCelularResponsavel());
				} catch (EntityNotFoundException e) {
					System.out.println("Aluno não encontrado!");
				}
				
		
				// Atualizar um aluno
				aluno = new Aluno(1, "Carla", 
						new GregorianCalendar(2002,Calendar.FEBRUARY, 21),
						922673421, Genero.FEMININO, 12345678, "Avenida Paulista", 
						"Flavia", 95674197);
				
				try {
					dao.update(aluno);
					dao.commit();
					System.out.println("Aluno atualizado!");
				} catch (CommitException e) {
					System.out.println(e.getMessage());
				}
				
		
				// Remover um aluno
				try {
					dao.delete(1);
					dao.commit();
					System.out.println("Aluno removido!");
				} catch (EntityNotFoundException | CommitException e) {
					System.out.println(e.getMessage());
				}
				
		
	}
	
}
