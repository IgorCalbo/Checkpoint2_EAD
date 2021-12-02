package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.EscolaDao;
import br.com.fiap.tds.entity.Escola;

public class EscolaDaoImpl extends GenericDaoImpl<Escola, Integer> implements EscolaDao{

	public EscolaDaoImpl(EntityManager em) {
		super(em);
	}

}
