package GerenciadorTarefas.src.main.java.com.gerenciador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {
	private List<Tarefa> tarefas;

	public GerenciadorDeTarefas() {
		this.tarefas = new ArrayList<Tarefa>();
	}

	public void addTarefa(String titulo, String descricao, LocalDate dataDeVencimento, String prioridade) {
		Tarefa tarefa = new Tarefa(titulo, descricao, dataDeVencimento, prioridade);

		this.tarefas.add(tarefa);

		this.ordenaListaTarefas();
	}

	public int getQuantidadeTarefas() {
		return this.tarefas.size();
	}

	public Tarefa editarTarefa(int index, String titulo, String descricao, LocalDate dataDeVencimento,
			String prioridade) {
		try {
			this.tarefas.get(index).atualizaDetalhes(titulo, descricao, dataDeVencimento, prioridade);
			this.ordenaListaTarefas();
			return new Tarefa(titulo, descricao, dataDeVencimento, prioridade);
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

	private void ordenaListaTarefas() {
		this.tarefas.sort((tarefa1, tarefa2) -> {
			int dataVencimento = tarefa1.getDataDeVencimento().compareTo(tarefa2.getDataDeVencimento());
			if (dataVencimento != 0) {
				return dataVencimento;
			}
			return this.compararPrioridade(tarefa1.getPrioridade().toLowerCase(),
					tarefa2.getPrioridade().toLowerCase());
		});
	}

	private int compararPrioridade(String prioridade1, String prioridade2) {
		if (prioridade1.equals(prioridade2)) {
			return 0;
		} else if (prioridade1.equals("alta")) {
			return -1;
		} else if (prioridade2.equals("alta")) {
			return 1;
		} else if (prioridade1.equals("media")) {
			return -1;
		} else if (prioridade2.equals("media")) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < this.tarefas.size(); i++) {
			Tarefa tarefa = this.tarefas.get(i);
			result.append(i).append(" - ").append(tarefa.getTitulo()).append(" - ").append(tarefa.getDescricao())
					.append(" - ").append(tarefa.getDataDeVencimento()).append(" - ").append(tarefa.getPrioridade());
			if (i < this.tarefas.size() - 1) {
				result.append("\n");
			}
		}
		return result.toString();
	}

}
