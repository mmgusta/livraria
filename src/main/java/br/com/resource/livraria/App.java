package br.com.resource.livraria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.resource.livraria.config.HibernateConfig;
import br.com.resource.livraria.dao.Dao;
import br.com.resource.livraria.modelos.Autor;
import br.com.resource.livraria.modelos.Cliente;
import br.com.resource.livraria.modelos.Genero;
import br.com.resource.livraria.modelos.Livro;
import br.com.resource.livraria.modelos.Venda;

public class App {
	
    public static void main( String[] args ){
    
    	Dao dao = new Dao();
    	
    	
    	//CLIENTE
    	Cliente cliente = new Cliente();
    	cliente.setNome("Gustavo Martins");
    	cliente.setTelefone("(11)99999-4444");
    	
    	dao.salva(cliente);
    	
    	//AUTOR
    	Autor autor = new Autor();
    	autor.setNome("Ferraz Ferrari");
    	autor.setEmail("ferraz@gmail.com");
    	
    	dao.salva(autor);
    	
    	Autor autor2 = new Autor();
    	autor2.setNome("Samaria Samanta");
    	autor2.setEmail("samanria@gmail.com");
    	
    	dao.salva(autor2);
    	
    	//GENERO
    	Genero genero = new Genero();
    	genero.setDescricao("Romance Vampiro");
    	
    	dao.salva(genero);
    	
    	//LIVRO
    	Livro livro = new Livro();
    	List<Autor> autores = new ArrayList<Autor>();
    	autores.add(autor);
    	livro.setTitulo("Opusculo");
    	livro.setPreco(59.9);
    	livro.setEstoque(10);
    	livro.setGenero(genero);
    	livro.setAutores(autores);
    	
    	dao.salva(livro);
    	
    	Livro livro2 = new Livro();
    	List<Autor> autores2 = new ArrayList<Autor>();
    	autores2.add(autor);
    	autores2.add(autor2);
    	livro2.setTitulo("Opusculo - O Retorno");
    	livro2.setPreco(79.9);
    	livro2.setEstoque(10);
    	livro2.setGenero(genero);
    	livro2.setAutores(autores2);
    	
    	dao.salva(livro2);
    	
    	//VENDA
    	Venda venda = new Venda();
    	venda.setCliente(cliente);
    	venda.setData(LocalDate.now());
    	venda.adicionaLivro(livro, 2);
    	venda.adicionaLivro(livro2, 3);
    	dao.atualiza(livro);
    	dao.atualiza(livro2);
    	dao.salva(venda);
    
    	
    }
}
