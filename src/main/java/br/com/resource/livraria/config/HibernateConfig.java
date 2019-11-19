package br.com.resource.livraria.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.com.resource.livraria.modelos.Autor;
import br.com.resource.livraria.modelos.Cliente;
import br.com.resource.livraria.modelos.Genero;
import br.com.resource.livraria.modelos.Livro;
import br.com.resource.livraria.modelos.LivroVenda;
import br.com.resource.livraria.modelos.LivroVendaId;
import br.com.resource.livraria.modelos.Venda;

public class HibernateConfig {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			try {
				
				Configuration config = new Configuration();
				
				Properties prop = new Properties();
				
				prop.put(Environment.DRIVER, "org.postgresql.Driver");
				prop.put(Environment.URL, "jdbc:postgresql://localhost:5432/db_livraria_novo");
				prop.put(Environment.USER, "postgres");
				prop.put(Environment.PASS, "admin");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				
				prop.put(Environment.SHOW_SQL, "true");
				
				prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				config.setProperties(prop);
				
				config.addAnnotatedClass(Autor.class);
				config.addAnnotatedClass(Cliente.class);
				config.addAnnotatedClass(Genero.class);
				config.addAnnotatedClass(Livro.class);
				config.addAnnotatedClass(Venda.class);
				config.addAnnotatedClass(LivroVenda.class);
				config.addAnnotatedClass(LivroVendaId.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
													.applySettings(config.getProperties())
													.build();
				
				sessionFactory = config.buildSessionFactory(serviceRegistry);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return sessionFactory;
		
	}

}
