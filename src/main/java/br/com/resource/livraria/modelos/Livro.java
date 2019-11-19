package br.com.resource.livraria.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, length=100)
	private String titulo;
	
	@Column(nullable=false)
	private double preco;
	
	@Column(nullable=false)
	private int estoque;
	
	@ManyToOne
	@JoinColumn(name="genero_id")
	private Genero genero;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="escreve", joinColumns = {
			@JoinColumn(referencedColumnName="id")},
			inverseJoinColumns = {
					@JoinColumn(referencedColumnName="id")
			})
	private List<Autor> autores;
	
	@OneToMany(mappedBy="livro", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<LivroVenda> vendas = new ArrayList<LivroVenda>();

	public List<LivroVenda> getVendas() {
		return vendas;
	}

	public void setVendas(List<LivroVenda> vendas) {
		this.vendas = vendas;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	//vamos fazer as FK depois
}
