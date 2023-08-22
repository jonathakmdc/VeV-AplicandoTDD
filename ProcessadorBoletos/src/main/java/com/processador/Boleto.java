package ProcessadorBoletos.src.main.java.com.processador;

import java.time.LocalDate;
import java.util.Objects;

public class Boleto {
    String codigoBoleto;
    LocalDate data;
    double valorPago;

    @Override
    public String toString() {
        return "Boleto{" +
                "codigoBoleto='" + codigoBoleto + '\'' +
                ", data=" + data +
                ", valorPago=" + valorPago +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boleto boleto = (Boleto) o;
        return Double.compare(valorPago, boleto.valorPago) == 0 && Objects.equals(codigoBoleto, boleto.codigoBoleto) && Objects.equals(data, boleto.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoBoleto, data, valorPago);
    }

    public String getCodigoBoleto() {
        return codigoBoleto;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValorPago() {
        return valorPago;
    }

    public Boleto(String codigoBoleto, LocalDate data, double valorPago) {
        this.codigoBoleto = codigoBoleto;
        this.data = data;
        this.valorPago = valorPago;
    }

}
