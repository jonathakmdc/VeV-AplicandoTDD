package ProcessadorBoletos.functionalTests;

import ProcessadorBoletos.src.main.java.com.processador.Boleto;
import ProcessadorBoletos.src.main.java.com.processador.Fatura;
import ProcessadorBoletos.src.main.java.com.processador.Pagamento;
import ProcessadorBoletos.src.main.java.com.processador.ProcessadorDeBoletos;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class processadorTestDecisao {

    @Test
    void testDecisao1(){
        Fatura fatura = new Fatura(LocalDate.now(), 100, "");

        Boleto boleto = new Boleto("112233", LocalDate.now(), 120);
        ArrayList<Boleto> listaBoletos = new ArrayList<Boleto>();
        ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();

        Pagamento pagamento = new Pagamento(boleto.getValorPago(), boleto.getData(),"BOLETO");

        listaBoletos.add(boleto);
        pagamentos.add(pagamento);

        ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos();
        assertTrue(processadorDeBoletos.verificaFaturaPaga(processadorDeBoletos.somaBoletosPagos(listaBoletos), fatura.getValorTotal()));
        assertEquals(pagamentos, processadorDeBoletos.analisaBoletos(listaBoletos));
    }

    @Test
    void testDecisao2(){
        Fatura fatura = new Fatura(LocalDate.now(), 100, "");

        Boleto boleto = new Boleto("112233", LocalDate.now(), 25);
        ArrayList<Boleto> listaBoletos = new ArrayList<Boleto>();
        ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();

        Pagamento pagamento = new Pagamento(boleto.getValorPago(), boleto.getData(),"BOLETO");

        listaBoletos.add(boleto);
        pagamentos.add(pagamento);

        ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos();
        assertFalse(processadorDeBoletos.verificaFaturaPaga(processadorDeBoletos.somaBoletosPagos(listaBoletos), fatura.getValorTotal()));
        assertEquals(pagamentos, processadorDeBoletos.analisaBoletos(listaBoletos));
    }

    @Test
    void testDecisao3(){
        Fatura fatura = new Fatura(LocalDate.now(), 100, "");

        Boleto boleto = new Boleto("112233", LocalDate.now(), 100);
        ArrayList<Boleto> listaBoletos = new ArrayList<Boleto>();
        ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();

        Pagamento pagamento = new Pagamento(boleto.getValorPago(), boleto.getData(),"BOLETO");

        listaBoletos.add(boleto);
        pagamentos.add(pagamento);

        ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos();
        assertTrue(processadorDeBoletos.verificaFaturaPaga(processadorDeBoletos.somaBoletosPagos(listaBoletos), fatura.getValorTotal()));
        assertEquals(pagamentos, processadorDeBoletos.analisaBoletos(listaBoletos));
    }
}
