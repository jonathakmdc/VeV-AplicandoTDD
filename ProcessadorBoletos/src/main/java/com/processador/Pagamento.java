package ProcessadorBoletos.src.main.java.com.processador;

import java.time.LocalDate;
import java.util.Objects;

public class Pagamento {
    double valorPago;
    LocalDate data;
    String tipoPagamento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Double.compare(valorPago, pagamento.valorPago) == 0 && Objects.equals(data, pagamento.data) && Objects.equals(tipoPagamento, pagamento.tipoPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valorPago, data, tipoPagamento);
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "valorPago=" + valorPago +
                ", data=" + data +
                ", tipoPagamento='" + tipoPagamento + '\'' +
                '}';
    }

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
