package test.java.com.gerenciador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import main.java.com.gerenciador.GerenciadorDeTarefas;

class GerenciadorDeTarefasTest {

	@Test
	void testCriacaoDeTarefa() {
		GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
		assertEquals(0, gerenciador.getQuantidadeTarefas());
		
		gerenciador.addTarefa("Fazer Atividade", "realizar atividade", LocalDate.of(2023, 8, 1), "media");
		
		assertEquals(1, gerenciador.getQuantidadeTarefas());

	}
	
	@Test
	void testEdicaoDeTarefa() {
		GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
		assertEquals(0, gerenciador.getQuantidadeTarefas());
		
		gerenciador.addTarefa("Fazer Atividade", "realizar atividade", LocalDate.of(2023, 8, 1), "media");
		
		assertEquals(1, gerenciador.getQuantidadeTarefas());
		
		assertEquals(gerenciador.getTarefa(0), gerenciador.editarTarefa(0, "Fazer Atividade 2", "realizar atividade de cálculo", LocalDate.of(2023, 8, 15), "baixa"));
		
		assertEquals("Fazer Atividade 2", gerenciador.getTarefa(0).getTitulo());
		assertEquals("realizar atividade de cálculo", gerenciador.getTarefa(0).getDescricao());
		assertEquals(LocalDate.of(2023, 8, 15), gerenciador.getTarefa(0).getDataDeVencimento());
		assertEquals("baixa", gerenciador.getTarefa(0).getPrioridade());
		
		assertEquals(null, gerenciador.getTarefa(1));
		
		assertEquals(null, gerenciador.editarTarefa(1, "Fazer Atividade 2", "realizar atividade de cálculo", LocalDate.of(2023, 8, 15), "baixa"));
	}

}
