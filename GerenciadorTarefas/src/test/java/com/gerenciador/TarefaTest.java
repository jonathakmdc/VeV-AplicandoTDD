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

}
