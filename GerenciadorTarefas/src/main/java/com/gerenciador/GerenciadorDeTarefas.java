package main.java.com.gerenciador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {
	private List<Tarefa> tarefas;

	public GerenciadorDeTarefas() {
		this.tarefas = new ArrayList();
	}

	public void addTarefa(String titulo, String descricao, LocalDate dataDeVencimento, String prioridade) {
		Tarefa tarefa = new Tarefa(titulo, descricao, dataDeVencimento, prioridade);
		
		this.tarefas.add(tarefa);
	}

	public int getQuantidadeTarefas() {
		return this.tarefas.size();
	}

	public void editarTarefa(int index, String titulo, String descricao, LocalDate dataDeVencimento, String prioridade) {
		this.tarefas.get(index).atualizaDetalhes(titulo, descricao, dataDeVencimento, prioridade);
	}

	public Tarefa getTarefa(int index) {
		return this.tarefas.get(index);
	}
}
