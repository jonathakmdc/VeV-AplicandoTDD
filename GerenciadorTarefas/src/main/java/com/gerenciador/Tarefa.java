package main.java.com.gerenciador;

import java.time.LocalDate;

public class Tarefa {
	private String titulo;
	private String descricao;
	private LocalDate dataDeVencimento;
	private String prioridade;
	
	public Tarefa(String titulo, String descricao, LocalDate dataDeVencimento, String prioridade) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataDeVencimento = dataDeVencimento;
		this.prioridade = prioridade;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getDataDeVencimento() {
		return dataDeVencimento;
	}

	public String getPrioridade() {
		return prioridade;
	}

}
