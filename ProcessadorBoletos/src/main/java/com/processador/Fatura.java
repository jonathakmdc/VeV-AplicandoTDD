package ProcessadorBoletos.src.main.java.com.processador;


import java.time.LocalDate;
import java.util.Date;


public class Fatura {
    private LocalDate data;
    private double valorTotal;
    private String nomeCliente;


    public Fatura(LocalDate data, double valorTotal, String nomeCliente) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.nomeCliente = nomeCliente;
    }


    public LocalDate getData() {
        return data;
    }


    public double getValorTotal() {
        return valorTotal;
    }


    public String getNomeCliente() {
        return nomeCliente;
    }
}
