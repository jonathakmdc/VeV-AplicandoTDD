package ProcessadorBoletos.test.java.com.processador;

import ProcessadorBoletos.src.main.java.com.processador.Fatura;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertEquals;

class FaturaTeste {

    @Test
    void testCriacao() {
        Fatura fatura = new Fatura(LocalDate.now(), 1500.00, "Carlos");
    }
}