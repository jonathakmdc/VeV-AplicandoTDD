package test.java.com.gerenciador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import main.java.com.gerenciador.GerenciadorDeTarefas;

class GerenciadorDeTarefasTest {

	@Test
	void testCriacaoDeTarefa() {
		GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();

		assertEquals(0,
				gerenciador.addTarefa("Fazer Atividade", "realizar atividade", LocalDate.of(2023, 8, 1), "media"));
		
	}

}
