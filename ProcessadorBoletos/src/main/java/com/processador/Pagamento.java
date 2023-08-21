package ProcessadorBoletos.src.main.java.com.processador;

import java.time.LocalDate;

public class Pagamento {
    double valorPago;
    LocalDate data;
    String tipoPagamento;

    public Pagamento(double valorPago, LocalDate data, String tipoPagamento) {
        this.valorPago = valorPago;
        this.data = data;
        this.tipoPagamento = tipoPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public LocalDate getData() {
        return data;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }
}
