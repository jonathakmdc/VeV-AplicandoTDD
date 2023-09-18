package GerenciadorTarefas.src.junit5Tests;

import main.java.com.gerenciador.Tarefa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TarefaTest {

	Tarefa tarefa;

	@BeforeEach
	void setUp() {
		tarefa = new Tarefa("Teste", "descricaoTeste", LocalDate.now(), "alta");
	}

	@Test
	void testCriacaoTarefa(){
		assertEquals("Teste", tarefa.getTitulo());
		assertEquals("descricaoTeste", tarefa.getDescricao());
		assertEquals(LocalDate.now(), tarefa.getDataDeVencimento());
		assertEquals("alta", tarefa.getPrioridade());
	}

	@Test
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
	void testExcecaoTituloInvalido() {
		try {
			tarefa.setTitulo(null);
			fail("Exceção deveria ter sido lançada!");
		} catch(IllegalArgumentException e) {
			assertEquals("Titulo nao pode ser nulo", e.getMessage());
		}
	}
	
	@Test
	void testExcecaoDescricaoInvalida() {
		try {
			tarefa.setDescricao(null);
			fail("Exceção deveria ter sido lançada!");
		} catch(IllegalArgumentException e) {
			assertEquals("Descricao nao pode ser nulo", e.getMessage());
		}
	}
	
	@Test
	void testExcecaoDataDeVencimentoInvalida() {
		try {
			tarefa.setDataDeVencimento(null);
			fail("Exceção deveria ter sido lançada!");
		} catch(IllegalArgumentException e) {
			assertEquals("Data de vencimento nao pode ser nulo", e.getMessage());
		}
	}
	
	@Test
	void testExcecaoPrioridadeNula() {
		try {
			tarefa.setPrioridade(null);
			fail("Exceção deveria ter sido lançada!");
		} catch(IllegalArgumentException e) {
			assertEquals("Prioridade nao pode ser nulo", e.getMessage());
		}
	}
	
	@Test
	void testExcecaoPrioridadeInvalida() {
		tarefa.setPrioridade("baixa");
		assertEquals("baixa", tarefa.getPrioridade());
		
		tarefa.setPrioridade("alta");
		assertEquals("alta", tarefa.getPrioridade());
		
		tarefa.setPrioridade("media");
		assertEquals("media", tarefa.getPrioridade());
		
		try {
			tarefa.setPrioridade("ok");
			fail("Exceção deveria ter sido lançada!");
		} catch(IllegalArgumentException e) {
			assertEquals("Prioridade invalida, so pode alta, media ou baixa", e.getMessage());
		}
	}
}
