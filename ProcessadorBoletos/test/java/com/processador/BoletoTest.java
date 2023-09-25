package ProcessadorBoletos.test.java.com.processador;

import ProcessadorBoletos.src.main.java.com.processador.Boleto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testar a funcionalidade de boleto")
public class BoletoTest {
	
    @Test
    @DisplayName("Teste para criação de boletos")
    void testCriacao() {
        Boleto boleto = new Boleto("112233", LocalDate.now(), 1500.0);

        assertEquals("112233", boleto.getCodigoBoleto());
        assertEquals(LocalDate.now(), boleto.getData());
        assertEquals(1500.0, boleto.getValorPago(), 2);
    }
}
