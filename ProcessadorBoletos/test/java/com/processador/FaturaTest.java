package ProcessadorBoletos.test.java.com.processador;

import ProcessadorBoletos.src.main.java.com.processador.Fatura;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FaturaTest {

    @Test
    void testCriacao() {
        Fatura fatura = new Fatura(LocalDate.now(), 1500.00, "Carlos");

        assertEquals(LocalDate.now(), fatura.getData());
        assertEquals(1500.0, fatura.getValorTotal(), 2);
        assertEquals("Carlos", fatura.getNomeCliente());
    }
}