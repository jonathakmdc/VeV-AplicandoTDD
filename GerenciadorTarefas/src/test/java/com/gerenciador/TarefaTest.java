package test.java.com.gerenciador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class TarefaTest {

	@Test
	void testCriacao() {
		Tarefa tarefa = new Tarefa("Teste", "descricaoTeste", new Date(), "alta");
	}

}
