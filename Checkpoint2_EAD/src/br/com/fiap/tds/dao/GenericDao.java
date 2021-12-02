package br.com.fiap.tds.dao;

import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;

public interface GenericDao<E,K> {

	void create(E entidade);
	
	// 90% dos casos é integer aqui (por causa do codigo como pk)
	// mas para "capturar" todos os casos, use K
	E findById(K id) throws EntityNotFoundException;

	void update(E entidade);
	
	void delete(K id) throws EntityNotFoundException;
	
	void commit() throws CommitException;
}
