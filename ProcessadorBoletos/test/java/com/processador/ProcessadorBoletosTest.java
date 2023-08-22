package ProcessadorBoletos.test.java.com.processador;

import ProcessadorBoletos.src.main.java.com.processador.Boleto;
import ProcessadorBoletos.src.main.java.com.processador.Pagamento;
import ProcessadorBoletos.src.main.java.com.processador.ProcessadorDeBoletos;
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
        ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();

        Pagamento pagamento1 = new Pagamento(boleto1.getValorPago(), boleto1.getData(),"BOLETO");
        Pagamento pagamento2 = new Pagamento(boleto2.getValorPago(), boleto2.getData(),"BOLETO");
        Pagamento pagamento3 = new Pagamento(boleto3.getValorPago(), boleto3.getData(),"BOLETO");
        pagamentos.add(pagamento1);
        pagamentos.add(pagamento2);
        pagamentos.add(pagamento3);

        assertEquals(pagamentos, processadorBoletos.analisaBoletos(listaBoletos));

    }
}
