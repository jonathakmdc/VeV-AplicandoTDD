package test.java.com.gerenciador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import main.java.com.gerenciador.Tarefa;

class TarefaTest {

	@Test
	void testCriacaoTarefa() {
		Tarefa tarefa = new Tarefa("Teste", "descricaoTeste", LocalDate.now(), "alta");

		assertEquals("Teste", tarefa.getTitulo());
		assertEquals("descricaoTeste", tarefa.getDescricao());
		assertEquals(LocalDate.now(), tarefa.getDataDeVencimento());
		assertEquals("alta", tarefa.getPrioridade());
	}

	@Test
	void testEdicaoTarefa() {
		Tarefa tarefa = new Tarefa("Teste", "descricaoTeste", LocalDate.now(), "alta");

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
		Tarefa tarefa = new Tarefa("Teste", "descricaoTeste", LocalDate.now(), "alta");

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
		Tarefa tarefa = new Tarefa("Teste", "descricaoTeste", LocalDate.now(), "alta");

		try {
			tarefa.setTitulo(null);
			fail("Exceção deveria ter sido lançada!");
		} catch(IllegalArgumentException e) {
			assertEquals("Titulo nao pode ser nulo", e.getMessage());
		}
	}
	
	@Test
	void testExcecaoDescricaoInvalida() {
		Tarefa tarefa = new Tarefa("Teste", "descricaoTeste", LocalDate.now(), "alta");

		try {
			tarefa.setDescricao(null);
			fail("Exceção deveria ter sido lançada!");
		} catch(IllegalArgumentException e) {
			assertEquals("Descricao nao pode ser nulo", e.getMessage());
		}
	}

}
