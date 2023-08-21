package ProcessadorBoletos.src.main.java.com.processador;

import java.time.LocalDate;

public class Boleto {
    String codigoBoleto;
    LocalDate data;
    double valorPago;

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
