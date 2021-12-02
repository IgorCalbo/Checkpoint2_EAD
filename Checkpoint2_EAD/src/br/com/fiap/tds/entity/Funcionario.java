package br.com.fiap.tds.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_FUNCIONARIO")
@SequenceGenerator(name="funcionario", sequenceName="SQ_TB_FUNCIONARIO", allocationSize=1)
public class Funcionario {

	@Id
	@Column(name="nr_rg")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="funcionario")
	private int rg;
	
	@Column(name="nr_cpf", nullable=false)
	private int cpf;
	
	@Column(name="nm_funcionario", nullable=false, length=100)
	private String nome;
	
	@Column(name="nr_celular", nullable=false)
	private int celular;
	
	@Column(name="ds_endereco", nullable=false, length=100)
	private String endereco;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero", nullable=false, length=20)
	private Genero genero;
	
	@Column(name="ds_salario", nullable=false)
	private double salario;
	
	@ManyToOne
	@JoinColumn(name="nr_cnpj")
	private Escola escola;
	
	@OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL) // nome do atributo
	private Professor professor;
	
	public Funcionario() {}
	
	public Funcionario(int cpf, String nome, int celular, String endereco, Genero genero, double salario) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.celular = celular;
		this.endereco = endereco;
		this.genero = genero;
		this.salario = salario;
	}

	public Funcionario(int rg, int cpf, String nome, int celular, String endereco, Genero genero, double salario) {
		super();
		this.rg = rg;
		this.cpf = cpf;
		this.nome = nome;
		this.celular = celular;
		this.endereco = endereco;
		this.genero = genero;
		this.salario = salario;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}
