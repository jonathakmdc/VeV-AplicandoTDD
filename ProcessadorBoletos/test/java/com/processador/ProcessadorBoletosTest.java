package ProcessadorBoletos.test.java.com.processador;

import ProcessadorBoletos.src.main.java.com.processador.Boleto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ProcessadorBoletosTest {

    @Test
    void testCriacao() {
        Boleto boleto1 = new Boleto("112233", LocalDate.now(), 1500.0);
        Boleto boleto2 = new Boleto("445566", LocalDate.now(), 2000.0);
        Boleto boleto3 = new Boleto("778899", LocalDate.now(), 3000.0);

        ArrayList<Boleto> listaBoletos = new ArrayList<Boleto>();
        listaBoletos.add(boleto1);
        listaBoletos.add(boleto2);
        listaBoletos.add(boleto3);

        ProcessadorBoletos processadorBoletos = new ProcessadorBoletos(listaBoletos);

    }
}
