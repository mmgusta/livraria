package br.com.resource.livraria.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.resource.livraria.config.HibernateConfig;

public class Dao {
	
	public <T> void salva(T entidade) {
		try(Session session = HibernateConfig.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(entidade);
			session.getTransaction().commit();
		}
	}
	
	public <T> void atualiza(T entidade) {
		try(Session session = HibernateConfig.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.merge(entidade);
			session.getTransaction().commit();
		}
	}
	
	public <T> void deleta(T entidade) {
		try(Session session = HibernateConfig.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(entidade);
			session.getTransaction().commit();
		}
	}
	
	public <T> List<T> buscaTodos(Class<T> nomeClasse) {
		try(Session session = HibernateConfig.getSessionFactory().openSession()) {
			return session.createQuery("from " + nomeClasse.getName()).getResultList();
		}
	}
	
	public <T> T buscaPorId(Class<T> nomeClasse, int id) {
		try(Session session = HibernateConfig.getSessionFactory().openSession()) {
			return session.get(nomeClasse, id);
		}
	}

}
