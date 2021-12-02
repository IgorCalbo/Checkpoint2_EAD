package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.TurmaDao;
import br.com.fiap.tds.entity.Turma;

public class TurmaDaoImpl extends GenericDaoImpl<Turma, Integer>
		implements TurmaDao{

	public TurmaDaoImpl(EntityManager em) {
		super(em);
	}

}
