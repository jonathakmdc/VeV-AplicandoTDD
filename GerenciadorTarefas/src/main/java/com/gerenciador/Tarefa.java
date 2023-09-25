package GerenciadorTarefas.src.main.java.com.gerenciador;

import java.time.LocalDate;
import java.util.Objects;

public class Tarefa {
	private String titulo;
	private String descricao;
	private LocalDate dataDeVencimento;
	private String prioridade;

	public Tarefa(String titulo, String descricao, LocalDate dataDeVencimento, String prioridade) {
		this.setTitulo(titulo);
		this.setDescricao(descricao);
		this.setDataDeVencimento(dataDeVencimento);
		this.setPrioridade(prioridade);
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

	public void setTitulo(String titulo) {
		if (titulo == null) {
			throw new IllegalArgumentException("Titulo nao pode ser nulo");
		}
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		if (descricao == null) {
			throw new IllegalArgumentException("Descricao nao pode ser nulo");
		}
		this.descricao = descricao;
	}

	public void setDataDeVencimento(LocalDate dataDeVencimento) {
		if (dataDeVencimento == null) {
			throw new IllegalArgumentException("Data de vencimento nao pode ser nulo");
		}
		this.dataDeVencimento = dataDeVencimento;
	}

	public void setPrioridade(String prioridade) {
		if (prioridade == null) {
			throw new IllegalArgumentException("Prioridade nao pode ser nulo");
		}
		if (!prioridade.equals("alta") && !prioridade.equals("media") && !prioridade.equals("baixa")) {
			throw new IllegalArgumentException("Prioridade invalida, so pode alta, media ou baixa");
		}
		this.prioridade = prioridade;
	}

	public void atualizaDetalhes(String titulo, String descricao, LocalDate dataDeVencimento, String prioridade) {
		this.setTitulo(titulo);
		this.setDescricao(descricao);
		this.setDataDeVencimento(dataDeVencimento);
		this.setPrioridade(prioridade);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDeVencimento, descricao, prioridade, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(dataDeVencimento, other.dataDeVencimento) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(prioridade, other.prioridade) && Objects.equals(titulo, other.titulo);
	}

}
