package main.java.com.gerenciador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

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

	public Tarefa editarTarefa(int index, String titulo, String descricao, LocalDate dataDeVencimento,
			String prioridade) {
		try {
			this.tarefas.get(index).atualizaDetalhes(titulo, descricao, dataDeVencimento, prioridade);
			return this.getTarefa(index);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public Tarefa getTarefa(int index) {
		try {
			return this.tarefas.get(index);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public boolean excluirTarefa(int index) {
		try {
			this.tarefas.remove(index);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
}
