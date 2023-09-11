package ProcessadorBoletos.test.java.com.processador;

import ProcessadorBoletos.src.main.java.com.processador.Pagamento;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PagamentoTest {

    @Test
    void testCriacao() {
        Pagamento pagamento = new Pagamento(1500.00, LocalDate.now(),"BOLETO");

        assertEquals(1500.0, pagamento.getValorPago(), 2);
        assertEquals(LocalDate.now(), pagamento.getData());
        assertEquals("BOLETO", pagamento.getTipoPagamento());

    }
}
