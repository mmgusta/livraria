package br.com.resource.livraria.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private LocalDate data;
	
	private double total;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy="venda", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<LivroVenda> livros = new ArrayList<LivroVenda>();
	
	public void adicionaLivro(Livro livro, int qtd) {
		LivroVenda livroVenda = new LivroVenda(livro, this, qtd);
		
		//relacionamento bilateral
		livros.add(livroVenda);
		livro.getVendas().add(livroVenda);
		
		double subTotal = qtd * livro.getPreco();
		livroVenda.setSubtotal(subTotal);
		
		this.total += subTotal;
		livro.alteraEstoque(qtd);
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
