package ProcessadorBoletos.src.main.java.com.processador;

import java.time.LocalDate;
import java.util.Objects;

public class Pagamento {
    private double valorPago;
    private LocalDate data;
    private String tipoPagamento;

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

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("data nao pode ser nulo");
        }
        this.data = data;
    }

    public void setTipoPagamento(String tipoPagamento) {
        if (tipoPagamento == null) {
            throw new IllegalArgumentException("tipoPagamento nao pode ser nulo");
        }
        this.tipoPagamento = tipoPagamento;
    }

    public Pagamento(double valorPago, LocalDate data, String tipoPagamento) {
        this.setValorPago(valorPago);
        this.setData(data);
        this.setTipoPagamento(tipoPagamento);
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
