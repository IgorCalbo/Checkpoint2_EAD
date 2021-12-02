package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.MateriaDao;
import br.com.fiap.tds.entity.Materia;

public class MateriaDaoImpl extends GenericDaoImpl<Materia, Integer> 
				implements MateriaDao{

	public MateriaDaoImpl(EntityManager em) {
		super(em);
	}

}
