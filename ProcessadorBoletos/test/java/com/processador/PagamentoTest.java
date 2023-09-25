package ProcessadorBoletos.test.java.com.processador;

import ProcessadorBoletos.src.main.java.com.processador.Pagamento;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testar a funcionalidade de pagamento")
public class PagamentoTest {

    @Test
    @DisplayName("Teste para criação de pagamento")
    void testCriacao() {
        Pagamento pagamento = new Pagamento(1500.00, LocalDate.now(),"BOLETO");

        assertEquals(1500.0, pagamento.getValorPago(), 2);
        assertEquals(LocalDate.now(), pagamento.getData());
        assertEquals("BOLETO", pagamento.getTipoPagamento());

    }
}
