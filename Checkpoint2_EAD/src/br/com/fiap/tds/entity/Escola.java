package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ESCOLA")
@SequenceGenerator(name="escola", sequenceName="SQ_TB_ESCOLA", allocationSize=1)
public class Escola {
	
	@Id
	@Column(name="nr_cnpj")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="escola")
	private int cnpj;
	
	@Column(name="nm_escola", nullable=false, length=80)
	private String nome;
	
	@Column(name="ds_endereco", nullable=false, length=100)
	private String endereco;
	
	@OneToMany(mappedBy = "escola", cascade = CascadeType.ALL) 
	private List<Aluno> alunos;
	
	@OneToMany(mappedBy = "escola", cascade = CascadeType.ALL) 
	private List<Funcionario> funcionarios;
	
	public Escola() {}
	
	public Escola(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}

	public Escola(int cnpj, String nome, String endereco) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}

	public void addAluno(Aluno aluno) {
		if (getAlunos() == null)
			setAlunos(new ArrayList<>());
		
		getAlunos().add(aluno);
		aluno.setEscola(this);
	}
	
	public void addFuncionario(Funcionario func) {
		if (getFuncionarios() == null)
			setFuncionarios(new ArrayList<>());
		
		getFuncionarios().add(func);
		func.setEscola(this);
	}
	
	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}
