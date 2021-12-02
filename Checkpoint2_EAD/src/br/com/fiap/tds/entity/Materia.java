package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_MATERIA")
@SequenceGenerator(name="materia", sequenceName="SQ_TB_MATERIA", allocationSize=1)
public class Materia {

	@Id
	@Column(name="cd_materia")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="materia")
	private int codigo;
	
	@Column(name="nm_materia", nullable=false, length=30)
	private String nome;
	
	@ManyToMany(mappedBy = "materias")
	private List<Turma> turmas;
	
	public Materia() {}

	public Materia(String nome) {
		super();
		this.nome = nome;
	}

	public Materia(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
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

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
}
