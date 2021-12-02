package br.com.fiap.tds.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Classe que gerencia a única instância da fábrica de entity manager
 
public class EntityManagerFactorySingleton {
	
	// Atributo estático que armazena a única instância
	private static EntityManagerFactory fabrica;
	
	// Construtor privado (não pode)-> new EntityManageFactorySingleton();
	private EntityManagerFactorySingleton() {}
	
	// Método estático que retorna a única instância
	public static EntityManagerFactory getInstance() {
		// Validar se existe uma instância da fábrica
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
}
