package ProcessadorBoletos.test.java.com.processador;

import ProcessadorBoletos.src.main.java.com.processador.Fatura;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class BoletoTest {

    @Test
    void testCriacao() {
        Boleto boleto = new Boleto("112233", LocalDate.now(), 1500.0);

    }
}
