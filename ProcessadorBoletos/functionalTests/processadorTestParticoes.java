package ProcessadorBoletos.functionalTests;

import ProcessadorBoletos.src.main.java.com.processador.Boleto;
import ProcessadorBoletos.src.main.java.com.processador.Fatura;
import ProcessadorBoletos.src.main.java.com.processador.Pagamento;
import ProcessadorBoletos.src.main.java.com.processador.ProcessadorDeBoletos;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class processadorTestParticoes {

    @Test
    void testParticoes1(){
        Fatura fatura = new Fatura(LocalDate.now(), 0, "");

        Boleto boleto = new Boleto("112233", LocalDate.now(), 0);
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
    void testParticoes2(){
        Fatura fatura = new Fatura(LocalDate.now(), 1, "");

        Boleto boleto = new Boleto("112233", LocalDate.now(), 0);
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
    void testParticoes3(){
        Fatura fatura = new Fatura(LocalDate.now(), 100, "");

        Boleto boleto = new Boleto("112233", LocalDate.now(), 99);
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
    void testParticoes4(){
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

    @Test
    void testParticoes5(){
        Fatura fatura = new Fatura(LocalDate.now(), 100, "");

        Boleto boleto = new Boleto("112233", LocalDate.now(), 101);
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
    void testParticoes6(){
        Fatura fatura = new Fatura(LocalDate.now(), 1500, "");

        Boleto boleto1 = new Boleto("112233", LocalDate.now(), 500);
        Boleto boleto2 = new Boleto("112234", LocalDate.now(), 400);
        Boleto boleto3 = new Boleto("112235", LocalDate.now(), 600);

        ArrayList<Boleto> listaBoletos = new ArrayList<Boleto>();
        ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();

        Pagamento pagamento1 = new Pagamento(boleto1.getValorPago(), boleto2.getData(),"BOLETO");
        Pagamento pagamento2 = new Pagamento(boleto2.getValorPago(), boleto2.getData(),"BOLETO");
        Pagamento pagamento3 = new Pagamento(boleto3.getValorPago(), boleto3.getData(),"BOLETO");

        listaBoletos.add(boleto1);
        listaBoletos.add(boleto2);
        listaBoletos.add(boleto3);
        pagamentos.add(pagamento1);
        pagamentos.add(pagamento2);
        pagamentos.add(pagamento3);

        ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos();
        assertTrue(processadorDeBoletos.verificaFaturaPaga(processadorDeBoletos.somaBoletosPagos(listaBoletos), fatura.getValorTotal()));
        assertEquals(pagamentos, processadorDeBoletos.analisaBoletos(listaBoletos));
    }
}
