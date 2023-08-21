package test.java.com.gerenciador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import main.java.com.gerenciador.Tarefa;

class TarefaTest {

	@Test
	void testCriacao() {
		Tarefa tarefa = new Tarefa("Teste", "descricaoTeste", LocalDate.now(), "alta");
		
		assertEquals("Teste", tarefa.getTitulo());
		assertEquals("descricaoTeste", tarefa.getDescricao());
		assertEquals(LocalDate.now(), tarefa.getDataDeVencimento());
		assertEquals("alta", tarefa.getPrioridade());
	}

}
