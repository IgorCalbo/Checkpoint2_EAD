package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_ALUNO")
@SequenceGenerator(name="aluno", sequenceName="SQ_TB_ALUNO", allocationSize=1)
public class Aluno {

	@Id
	@Column(name="cd_matricula")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aluno")
	private int codigo;
	
	@Column(name="nm_aluno", nullable=false, length=100)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento", nullable=false)
	private Calendar dataNascimento;
	
	@Column(name="nr_celular")
	private int celular;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero", nullable=false, length=20)
	private Genero genero;
	
	@Column(name="nr_senha", nullable=false)
	private int senha;
	
	@Column(name="ds_endereco", nullable=false, length=100)
	private String endereco;
	
	@Column(name="nm_responsavel", nullable=false, length=100)
	private String nomeResponsavel;
	
	@Column(name="nr_celular_responsavel", nullable=false)
	private int celularResponsavel;
		
	@ManyToOne
	@JoinColumn(name="nr_cnpj")
	private Escola escola;
	
	@ManyToOne
	@JoinColumn(name="cd_turma")
	private Turma turma;
	
	public Aluno() {}

	public Aluno(String nome, Calendar dataNascimento, int celular, Genero genero, int senha, String endereco,
			String nomeResponsavel, int celularResponsavel) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.celular = celular;
		this.genero = genero;
		this.senha = senha;
		this.endereco = endereco;
		this.nomeResponsavel = nomeResponsavel;
		this.celularResponsavel = celularResponsavel;
	}

	public Aluno(int codigo, String nome, Calendar dataNascimento, int celular, Genero genero, int senha,
			String endereco, String nomeResponsavel, int celularResponsavel) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.celular = celular;
		this.genero = genero;
		this.senha = senha;
		this.endereco = endereco;
		this.nomeResponsavel = nomeResponsavel;
		this.celularResponsavel = celularResponsavel;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public int getCelularResponsavel() {
		return celularResponsavel;
	}

	public void setCelularResponsavel(int celularResponsavel) {
		this.celularResponsavel = celularResponsavel;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
