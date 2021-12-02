package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_TURMA")
@SequenceGenerator(name="turma", sequenceName="SQ_TB_TURMA", allocationSize=1)
public class Turma {

	@Id
	@Column(name="cd_turma")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="turma")
	private int codigo;
	
	@Column(name="nm_turma", nullable=false, length=20)
	private String nome;
	
	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL) 
	private List<Aluno> alunos;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="TB_TURMA_PROFESSOR", 
			joinColumns = @JoinColumn(name="cd_turma"),
			inverseJoinColumns = @JoinColumn(name="cd_professor"))
	private List<Professor> professores;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="TB_TURMA_MATERIA", 
			joinColumns = @JoinColumn(name="cd_turma"),
			inverseJoinColumns = @JoinColumn(name="cd_materia"))
	private List<Materia> materias;
	
	public Turma() {}

	public Turma(String nome) {
		super();
		this.nome = nome;
	}

	public Turma(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public void addAluno(Aluno aluno) {
		if (getAlunos() == null)
			setAlunos(new ArrayList<>());
		
		getAlunos().add(aluno);
		aluno.setTurma(this);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
		
}
