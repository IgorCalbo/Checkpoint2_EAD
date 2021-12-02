package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.EscolaDao;
import br.com.fiap.tds.dao.TurmaDao;
import br.com.fiap.tds.dao.impl.EscolaDaoImpl;
import br.com.fiap.tds.dao.impl.TurmaDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Escola;
import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.entity.Materia;
import br.com.fiap.tds.entity.Professor;
import br.com.fiap.tds.entity.Turma;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Cadastro {

	// Cadastrar todas as entidades relacionadas
	public static void main(String[] args) {
		
		// Instanciar uma escola
		Escola escola = new Escola("FIAP", "Avenida Paulista");
		
		// Instanciar dois alunos e dois funcionarios
		Aluno aluno1 = new Aluno("Fred", new GregorianCalendar(2000,Calendar.NOVEMBER, 19),
		947443421, Genero.MASCULINO, 12345678, "Avenida Paulista", "Marcos", 95674197);
		Aluno aluno2 = new Aluno("Carla", new GregorianCalendar(2002,Calendar.FEBRUARY, 21),
		922673421, Genero.FEMININO, 12345678, "Avenida Paulista", "Flavia", 95674197);
		
		Funcionario funcionario1 = new Funcionario(511661168, "Alexandre", 977654132, 
				"Avenida Paulista", Genero.MASCULINO, 3000.0);
		Funcionario funcionario2 = new Funcionario(511661168, "Juliana", 832144132, 
				"Avenida Paulista", Genero.FEMININO, 6000.0);
		
		// Adicionar os alunos e funcionarios na escola
		escola.addAluno(aluno1);
		escola.addAluno(aluno2);
		escola.addFuncionario(funcionario1);
		escola.addFuncionario(funcionario2);
		
		
		// Instanciar 2 professores
		Professor professor1 = new Professor("Peter", 931314414, "Formado em línguas");
		Professor professor2 = new Professor("George", 81282181, "Formado em exatas");
		
		// Adicionar os professores em funcionarios
		funcionario1.setProfessor(professor1);
		funcionario2.setProfessor(professor2);
		
		// Instanciar 2 turmas
		Turma turma1 = new Turma("2TDSG");
		Turma turma2 = new Turma("2TDSF");
		
		// Criar uma lista de turmas e adiciona-las
		List<Turma> turmas = new ArrayList<>();
		turmas.add(turma1);
		turmas.add(turma2);
		
		// Setar professores nas turmas
		professor1.setTurmas(turmas);
		professor2.setTurmas(turmas);
		
		// Instanciar duas matérias
		Materia materia1 = new Materia("Química");
		Materia materia2 = new Materia("Física");
		
		// Setar matérias nas turmas
		materia1.setTurmas(turmas);
		materia2.setTurmas(turmas);
		
		// Setar alunos nas turmas
		aluno1.setTurma(turma1);
		aluno2.setTurma(turma2);
		
		// Cadastrar uma escola
		// Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		// Instanciar uma escolaDao
		EscolaDao dao = new EscolaDaoImpl(em);
		TurmaDao dao2 = new TurmaDaoImpl(em);
		TurmaDao dao3 = new TurmaDaoImpl(em);
		
		try {
			// Persistir o sistema
			dao.create(escola);	
			dao2.create(turma1);
			dao3.create(turma2);
			
			// Commit 
			dao.commit();
			System.out.println("Tudo ok!");
		}catch(CommitException e) {
			System.out.println("Deu ruim...");
		}
		
		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
		
	}
	
}
