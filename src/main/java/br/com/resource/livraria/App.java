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
    	
    	Cliente cliente = new Cliente();
    	cliente.setNome("Gustavo Martins");
    	cliente.setTelefone("11-95580-5775");
    	
    	dao.salva(cliente);
    	
    	Genero genero = new Genero();
    	genero.setDescricao("Romance Vampiro");
    	
    	dao.salva(genero);
    	
    	Autor autor = new Autor();
    	autor.setNome("Amilio Amélio");
    	autor.setEmail("amilio@amelio.com.br");
    	
    	dao.salva(autor);
    	
    	Autor autor2 = new Autor();
    	autor2.setNome("Samara Samiro");
    	autor2.setEmail("samiro@gmail.com");
    	
    	dao.salva(autor2);
    	
    	Livro livro = new Livro();
    	List<Autor> autores = new ArrayList<Autor>();
    	autores.add(autor);
    	autores.add(autor2);
    	livro.setTitulo("Opusculo");
    	livro.setPreco(79.9);
    	livro.setEstoque(10);
    	livro.setAutores(autores);
    	livro.setGenero(genero);
    	
    	dao.salva(livro);
    	
    	Livro livro2 = new Livro();
    	List<Autor> autores2 = new ArrayList<Autor>();
    	autores2.add(autor);
    	autores2.add(autor2);
    	livro2.setTitulo("Opusculo O Retorno");
    	livro2.setPreco(98.99);
    	livro2.setEstoque(10);
    	livro2.setAutores(autores2);
    	livro2.setGenero(genero);
    	
    	dao.salva(livro2);
    	
    	//VENDA
    	Venda venda = new Venda();
    	venda.setCliente(cliente);
    	venda.setData(LocalDate.now());
    	venda.adicionaLivro(livro, 2);
    	venda.adicionaLivro(livro2, 1);
    	
    	dao.salva(venda);
    	
    }
}
