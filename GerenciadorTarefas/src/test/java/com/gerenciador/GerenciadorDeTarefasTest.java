package GerenciadorTarefas.src.test.java.com.gerenciador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import GerenciadorTarefas.src.main.java.com.gerenciador.GerenciadorDeTarefas;
import GerenciadorTarefas.src.main.java.com.gerenciador.Tarefa;

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
		
		assertEquals(
				new Tarefa("Fazer Atividade 2", "realizar atividade de calculo", LocalDate.of(2023, 8, 15), "baixa"),
				gerenciador.editarTarefa(0, "Fazer Atividade 2", "realizar atividade de calculo",
						LocalDate.of(2023, 8, 15), "baixa"));

		assertEquals("Fazer Atividade 2", gerenciador.getTarefa(0).getTitulo());
		assertEquals("realizar atividade de calculo", gerenciador.getTarefa(0).getDescricao());
		assertEquals(LocalDate.of(2023, 8, 15), gerenciador.getTarefa(0).getDataDeVencimento());
		assertEquals("baixa", gerenciador.getTarefa(0).getPrioridade());
		
		assertEquals(null, gerenciador.getTarefa(1));
		
		assertEquals(null, gerenciador.editarTarefa(1, "Fazer Atividade 2", "realizar atividade de calculo", LocalDate.of(2023, 8, 15), "baixa"));
	}
	
	@Test
	void testExclusaoTarefa() {
		GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
		assertEquals(0, gerenciador.getQuantidadeTarefas());
		
		gerenciador.addTarefa("Fazer Atividade 2", "realizar atividade de calculo", LocalDate.of(2023, 8, 15), "baixa");
		
		assertEquals("Fazer Atividade 2", gerenciador.getTarefa(0).getTitulo());
		assertEquals("realizar atividade de calculo", gerenciador.getTarefa(0).getDescricao());
		assertEquals(LocalDate.of(2023, 8, 15), gerenciador.getTarefa(0).getDataDeVencimento());
		assertEquals("baixa", gerenciador.getTarefa(0).getPrioridade());
		
		assertEquals(1, gerenciador.getQuantidadeTarefas());
		
		assertTrue(gerenciador.excluirTarefa(0));
		
		assertEquals(0, gerenciador.getQuantidadeTarefas());
		
		assertEquals(null, gerenciador.getTarefa(0));
		
		assertFalse(gerenciador.excluirTarefa(0));
	}
	
	@Test
	void testListagemTarefas() {
		GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
		assertEquals(0, gerenciador.getQuantidadeTarefas());
		
		gerenciador.addTarefa("Fazer Atividade", "realizar atividade", LocalDate.of(2023, 8, 1), "baixa");
		
		gerenciador.addTarefa("Fazer Atividade 2", "realizar atividade de calculo", LocalDate.of(2023, 8, 15), "baixa");
		
		gerenciador.addTarefa("Revisar para prova", "revisar assunto de ES", LocalDate.of(2023, 8, 15), "media");
		
		gerenciador.addTarefa("Fazer Atividade AS", "realizar atividade de AS", LocalDate.of(2023, 8, 15), "alta");
		
		gerenciador.addTarefa("Instalar VS Code", "realizar instalacao de VS Code", LocalDate.of(2023, 8, 16), "baixa");
		
		assertEquals(5, gerenciador.getQuantidadeTarefas());
		
		assertEquals("0 - Fazer Atividade - realizar atividade - 2023-08-01 - baixa\n"
				+ "1 - Fazer Atividade AS - realizar atividade de AS - 2023-08-15 - alta\n"
				+ "2 - Revisar para prova - revisar assunto de ES - 2023-08-15 - media\n"
				+ "3 - Fazer Atividade 2 - realizar atividade de calculo - 2023-08-15 - baixa\n"
				+ "4 - Instalar VS Code - realizar instalacao de VS Code - 2023-08-16 - baixa", gerenciador.toString());
		
		gerenciador.excluirTarefa(1);
		
		assertEquals("0 - Fazer Atividade - realizar atividade - 2023-08-01 - baixa\n"
				+ "1 - Revisar para prova - revisar assunto de ES - 2023-08-15 - media\n"
				+ "2 - Fazer Atividade 2 - realizar atividade de calculo - 2023-08-15 - baixa\n"
				+ "3 - Instalar VS Code - realizar instalacao de VS Code - 2023-08-16 - baixa", gerenciador.toString());
		
		gerenciador.excluirTarefa(3);
		gerenciador.excluirTarefa(1);
		
		assertEquals("0 - Fazer Atividade - realizar atividade - 2023-08-01 - baixa\n"
				+ "1 - Fazer Atividade 2 - realizar atividade de calculo - 2023-08-15 - baixa", gerenciador.toString());
		
		gerenciador.excluirTarefa(1);
		gerenciador.excluirTarefa(0);
		
		assertEquals("", gerenciador.toString());
	}

}
