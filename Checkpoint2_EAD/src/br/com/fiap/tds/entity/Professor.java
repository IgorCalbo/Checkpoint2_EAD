package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PROFESSOR")
@SequenceGenerator(name="professor", sequenceName="SQ_TB_PROFESSOR", allocationSize=1)
public class Professor {

	@Id
	@Column(name="cd_professor")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="professor")
	private int codigo;
		
	@Column(name="nm_professor", nullable=false, length=100)
	private String nome;
	
	@Column(name="nr_senha", nullable=false)
	private int senha;
	
	@Column(name="ds_especificacao", nullable=false, length=40)
	private String especificacao;
	
	@ManyToOne
	@JoinColumn(name="nr_rg")
	private Funcionario funcionario;
	
	@ManyToMany(mappedBy = "professores")
	private List<Turma> turmas;
	
	public Professor() {}
	
	public Professor(String nome, int senha, String especificacao) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.especificacao = especificacao;
	}
	
	public Professor(int codigo, String nome, int senha, String especificacao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.senha = senha;
		this.especificacao = especificacao;
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

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

}
