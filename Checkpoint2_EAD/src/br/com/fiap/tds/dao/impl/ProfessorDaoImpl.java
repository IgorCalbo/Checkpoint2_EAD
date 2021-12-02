package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ProfessorDao;
import br.com.fiap.tds.entity.Professor;

public class ProfessorDaoImpl extends GenericDaoImpl<Professor, Integer>
		implements ProfessorDao{

	public ProfessorDaoImpl(EntityManager em) {
		super(em);
	}

}
