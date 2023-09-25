package ProcessadorBoletos.test.java.com.processador;

import ProcessadorBoletos.src.main.java.com.processador.Boleto;
import ProcessadorBoletos.src.main.java.com.processador.Fatura;
import ProcessadorBoletos.src.main.java.com.processador.Pagamento;
import ProcessadorBoletos.src.main.java.com.processador.ProcessadorDeBoletos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testar todas as funcionalidades do processador de boletos")
public class ProcessadorBoletosTest {

    ProcessadorDeBoletos processadorDeBoletos;
    Boleto boleto1;
    Boleto boleto2;
    Boleto boleto3;
    ArrayList<Boleto> listaBoletos;
    ArrayList<Pagamento> pagamentos;
    Pagamento pagamento1;
    Pagamento pagamento2;
    Pagamento pagamento3;
    Fatura fatura1;
    Fatura fatura2;

    @BeforeEach
    void setup() {
        processadorDeBoletos = new ProcessadorDeBoletos();
        boleto1 = new Boleto("112233", LocalDate.now(), 1500.0);
        boleto2 = new Boleto("445566", LocalDate.now(), 2000.0);
        boleto3 = new Boleto("778899", LocalDate.now(), 3000.0);
        listaBoletos = new ArrayList<Boleto>();
        pagamentos = new ArrayList<Pagamento>();
        pagamento1 = new Pagamento(boleto1.getValorPago(), boleto1.getData(),"BOLETO");
        pagamento2 = new Pagamento(boleto2.getValorPago(), boleto2.getData(),"BOLETO");
        pagamento3 = new Pagamento(boleto3.getValorPago(), boleto3.getData(),"BOLETO");
        fatura1 = new Fatura(LocalDate.now(), 7000.00, "Carlos");
        fatura2 = new Fatura(LocalDate.now(), 1000.00, "Carlos");
    }

    @BeforeEach
    void setupFuncionalidades() {
        listaBoletos.add(boleto1);
        listaBoletos.add(boleto2);
        listaBoletos.add(boleto3);

        pagamentos.add(pagamento1);
        pagamentos.add(pagamento2);
        pagamentos.add(pagamento3);
    }

    @Test
    @DisplayName("Teste criação de boletos e pagamentos")
    void testCriacao() {
        assertEquals(pagamentos, processadorDeBoletos.analisaBoletos(listaBoletos));
    }

    @Test
    @DisplayName("Teste verifica somatorio dos valores dos boletos")
    void testSomatorioValores() {
        assertEquals(6500, processadorDeBoletos.somaBoletosPagos(listaBoletos), 2);
    }

    @Test
    @DisplayName("Teste verifica se fatura foi paga")
    void testFaturaPaga() {

        assertFalse(processadorDeBoletos.verificaFaturaPaga(processadorDeBoletos.somaBoletosPagos(listaBoletos), fatura1.getValorTotal()));
        assertEquals(pagamentos, processadorDeBoletos.analisaBoletos(listaBoletos));

        assertTrue(processadorDeBoletos.verificaFaturaPaga(processadorDeBoletos.somaBoletosPagos(listaBoletos), fatura2.getValorTotal()));
        assertEquals(pagamentos, processadorDeBoletos.analisaBoletos(listaBoletos));
    }
}
