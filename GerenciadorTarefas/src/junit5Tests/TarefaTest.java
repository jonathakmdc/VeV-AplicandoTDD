package GerenciadorTarefas.src.junit5Tests;

import main.java.com.gerenciador.Tarefa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes de Unidade para Classe Tarefa")
class TarefaTest {

	Tarefa tarefa;

	@BeforeEach
	void setUp() {
		tarefa = new Tarefa("Teste", "descricaoTeste", LocalDate.now(), "alta");
	}

	@Test
	@DisplayName("Teste para criacao de tarefas")
	void testCriacaoTarefa(){
		assertEquals("Teste", tarefa.getTitulo());
		assertEquals("descricaoTeste", tarefa.getDescricao());
		assertEquals(LocalDate.now(), tarefa.getDataDeVencimento());
		assertEquals("alta", tarefa.getPrioridade());
	}

	@Test
	@DisplayName("Teste da edicao de tarefas")
	void testEdicaoTarefa() {
		assertEquals("Teste", tarefa.getTitulo());
		assertEquals("descricaoTeste", tarefa.getDescricao());
		assertEquals(LocalDate.now(), tarefa.getDataDeVencimento());
		assertEquals("alta", tarefa.getPrioridade());
		
		tarefa.atualizaDetalhes("Fazer Atividade", "realizar atividade", LocalDate.of(2023, 8, 1), "media");

		assertEquals("Fazer Atividade", tarefa.getTitulo());
		assertEquals("realizar atividade", tarefa.getDescricao());
		assertEquals(LocalDate.of(2023, 8, 1), tarefa.getDataDeVencimento());
		assertEquals("media", tarefa.getPrioridade());
	}
	
	@Test
	@DisplayName("Teste da edicao de um unico dado das tarefas")
	void testEdicaoTarefaUnicoDado() {
		assertEquals("Teste", tarefa.getTitulo());
		assertEquals("descricaoTeste", tarefa.getDescricao());
		assertEquals(LocalDate.now(), tarefa.getDataDeVencimento());
		assertEquals("alta", tarefa.getPrioridade());
		
		tarefa.setTitulo("Fazer fichamento");
		assertEquals("Fazer fichamento", tarefa.getTitulo());
		
		tarefa.setDescricao("realizar fichamento de ES");
		assertEquals("realizar fichamento de ES", tarefa.getDescricao());
		
		tarefa.setDataDeVencimento(LocalDate.of(2023, 4, 20));
		assertEquals(LocalDate.of(2023, 4, 20), tarefa.getDataDeVencimento());
		
		tarefa.setPrioridade("media");
		assertEquals("media", tarefa.getPrioridade());
	}
	
	@Test
	@DisplayName("Teste para lancamento da excecao ao colocar titulo invalido")
	void testExcecaoTituloInvalido() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			tarefa.setTitulo(null);
		});
		assertEquals("Titulo nao pode ser nulo", e.getMessage());
	}
	
	@Test
	@DisplayName("Teste para lancamento da excecao ao colocar descricao invalida")
	void testExcecaoDescricaoInvalida() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			tarefa.setDescricao(null);
		});
		assertEquals("Descricao nao pode ser nulo", e.getMessage());
	}
	
	@Test
	@DisplayName("Teste para lancamento da excecao ao colocar data de vencimento invalida")
	void testExcecaoDataDeVencimentoInvalida() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			tarefa.setDataDeVencimento(null);
		});
		assertEquals("Data de vencimento nao pode ser nulo", e.getMessage());
	}
	
	@Test
	@DisplayName("Teste para lancamento da excecao ao colocar prioridade invalida")
	void testExcecaoPrioridadeNula() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			tarefa.setPrioridade(null);
		});
		assertEquals("Prioridade nao pode ser nulo", e.getMessage());
	}
	
	@ParameterizedTest
	@DisplayName("Teste para verificacao de prioridade valida")
	@ValueSource(strings = {"alta", "media", "baixa"})
	void testExcecaoPrioridadeInvalida(String prioridade) {
		tarefa.setPrioridade(prioridade);
		assertEquals(prioridade, tarefa.getPrioridade());

		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			tarefa.setPrioridade(prioridade + ".");
		});
		assertEquals("Prioridade invalida, so pode alta, media ou baixa", e.getMessage());
	}
}
