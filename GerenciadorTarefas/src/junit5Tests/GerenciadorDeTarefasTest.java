package GerenciadorTarefas.src.junit5Tests;

import GerenciadorTarefas.src.main.java.com.gerenciador.GerenciadorDeTarefas;
import GerenciadorTarefas.src.main.java.com.gerenciador.Tarefa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes de Unidade para Classe GerenciadorDeTarefas")
class GerenciadorDeTarefasTest {

	GerenciadorDeTarefas gerenciador;

	@BeforeEach
	void setUp() {
		gerenciador = new GerenciadorDeTarefas();
	}

	@Test
	@DisplayName("Teste para criacao de tarefas")
	void testCriacaoDeTarefa() {
		assertEquals(0, gerenciador.getQuantidadeTarefas());
		
		gerenciador.addTarefa("Fazer Atividade", "realizar atividade", LocalDate.of(2023, 8, 1), "media");
		
		assertEquals(1, gerenciador.getQuantidadeTarefas());

	}
	
	@Test
	@DisplayName("Teste da edicao de tarefas")
	void testEdicaoDeTarefa() {
		assertEquals(0, gerenciador.getQuantidadeTarefas());
		
		gerenciador.addTarefa("Fazer Atividade", "realizar atividade", LocalDate.of(2023, 8, 1), "media");
		
		assertEquals(1, gerenciador.getQuantidadeTarefas());
		
		assertEquals(
				new Tarefa("Fazer Atividade 2", "realizar atividade de calculo", LocalDate.of(2023, 8, 15), "baixa"),
				gerenciador.editarTarefa(0, "Fazer Atividade 2", "realizar atividade de calculo",
						LocalDate.of(2023, 8, 15), "baixa"));

		Tarefa tarefaEditada = gerenciador.editarTarefa(0, "Fazer Atividade 2", "realizar atividade de calculo",
				LocalDate.of(2023, 8, 15), "baixa");

		assertAll("Verificação da Edição de Tarefa",
				() -> assertEquals("Fazer Atividade 2", tarefaEditada.getTitulo(), "Título não corresponde"),
				() -> assertEquals("realizar atividade de calculo", tarefaEditada.getDescricao(), "Descrição não corresponde"),
				() -> assertEquals(LocalDate.of(2023, 8, 15), tarefaEditada.getDataDeVencimento(), "Data de vencimento não corresponde"),
				() -> assertEquals("baixa", tarefaEditada.getPrioridade(), "Prioridade não corresponde")
		);
		
		assertNull(gerenciador.getTarefa(1));
		
		assertNull(gerenciador.editarTarefa(1, "Fazer Atividade 2", "realizar atividade de calculo", LocalDate.of(2023, 8, 15), "baixa"));
	}
	
	@Test
	@DisplayName("Teste da exclusao de tarefas")
	void testExclusaoTarefa() {
		assertEquals(0, gerenciador.getQuantidadeTarefas());
		
		gerenciador.addTarefa("Fazer Atividade 2", "realizar atividade de calculo", LocalDate.of(2023, 8, 15), "baixa");
		
		assertEquals("Fazer Atividade 2", gerenciador.getTarefa(0).getTitulo());
		assertEquals("realizar atividade de calculo", gerenciador.getTarefa(0).getDescricao());
		assertEquals(LocalDate.of(2023, 8, 15), gerenciador.getTarefa(0).getDataDeVencimento());
		assertEquals("baixa", gerenciador.getTarefa(0).getPrioridade());
		
		assertEquals(1, gerenciador.getQuantidadeTarefas());
		
		assertTrue(gerenciador.excluirTarefa(0));
		
		assertEquals(0, gerenciador.getQuantidadeTarefas());
		
		assertNull(gerenciador.getTarefa(0));
		
		assertFalse(gerenciador.excluirTarefa(0));
	}
	
	@Test
	@DisplayName("Teste da Listagem de Tarefas")
	void testListagemTarefas() {
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
