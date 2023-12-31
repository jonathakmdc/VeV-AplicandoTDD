package ProcessadorBoletos.test.java.com.processador;

import ProcessadorBoletos.src.main.java.com.processador.Boleto;
import ProcessadorBoletos.src.main.java.com.processador.Fatura;
import ProcessadorBoletos.src.main.java.com.processador.Pagamento;
import ProcessadorBoletos.src.main.java.com.processador.ProcessadorDeBoletos;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ProcessadorBoletosTest {

    @Test
    void testCriacao() {
        Boleto boleto1 = new Boleto("112233", LocalDate.now(), 1500.0);
        Boleto boleto2 = new Boleto("445566", LocalDate.now(), 2000.0);
        Boleto boleto3 = new Boleto("778899", LocalDate.now(), 3000.0);

        ArrayList<Boleto> listaBoletos = new ArrayList<Boleto>();
        ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();

        listaBoletos.add(boleto1);
        listaBoletos.add(boleto2);
        listaBoletos.add(boleto3);


        Pagamento pagamento1 = new Pagamento(boleto1.getValorPago(), boleto1.getData(),"BOLETO");
        Pagamento pagamento2 = new Pagamento(boleto2.getValorPago(), boleto2.getData(),"BOLETO");
        Pagamento pagamento3 = new Pagamento(boleto3.getValorPago(), boleto3.getData(),"BOLETO");
        pagamentos.add(pagamento1);
        pagamentos.add(pagamento2);
        pagamentos.add(pagamento3);

        ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos();
        assertEquals(pagamentos, processadorDeBoletos.analisaBoletos(listaBoletos));

    }

    @Test
    void testSomatorioValores() {
        Boleto boleto1 = new Boleto("112233", LocalDate.now(), 500);
        Boleto boleto2 = new Boleto("445566", LocalDate.now(), 500);
        Boleto boleto3 = new Boleto("778899", LocalDate.now(), 200);

        ArrayList<Boleto> listaBoletos = new ArrayList<Boleto>();

        listaBoletos.add(boleto1);
        listaBoletos.add(boleto2);
        listaBoletos.add(boleto3);

        ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos();
        assertEquals(1200.00, processadorDeBoletos.somaBoletosPagos(listaBoletos), 2);
    }

    @Test
    void testFaturaPaga() {
        Boleto boleto1 = new Boleto("112233", LocalDate.now(), 500);
        Boleto boleto2 = new Boleto("445566", LocalDate.now(), 500);
        Boleto boleto3 = new Boleto("778899", LocalDate.now(), 200);
        Fatura fatura = new Fatura(LocalDate.now(), 1500.00, "Carlos");
        Fatura fatura2 = new Fatura(LocalDate.now(), 1000.00, "Carlos");

        ArrayList<Boleto> listaBoletos = new ArrayList<Boleto>();
        ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();

        listaBoletos.add(boleto1);
        listaBoletos.add(boleto2);
        listaBoletos.add(boleto3);

        Pagamento pagamento1 = new Pagamento(boleto1.getValorPago(), boleto1.getData(),"BOLETO");
        Pagamento pagamento2 = new Pagamento(boleto2.getValorPago(), boleto2.getData(),"BOLETO");
        Pagamento pagamento3 = new Pagamento(boleto3.getValorPago(), boleto3.getData(),"BOLETO");

        pagamentos.add(pagamento1);
        pagamentos.add(pagamento2);
        pagamentos.add(pagamento3);

        ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos();
        assertFalse(processadorDeBoletos.verificaFaturaPaga(processadorDeBoletos.somaBoletosPagos(listaBoletos), fatura.getValorTotal()));
        assertEquals(pagamentos, processadorDeBoletos.analisaBoletos(listaBoletos));

        assertTrue(processadorDeBoletos.verificaFaturaPaga(processadorDeBoletos.somaBoletosPagos(listaBoletos), fatura2.getValorTotal()));
        assertEquals(pagamentos, processadorDeBoletos.analisaBoletos(listaBoletos));
    }
}
