package ProcessadorBoletos.src.main.java.com.processador;


import java.time.LocalDate;
import java.util.Date;


public class Fatura {
    private LocalDate data;
    private double valorTotal;
    private String nomeCliente;


    public Fatura(LocalDate data, double valorTotal, String nomeCliente) {
        this.setData(data);
        this.setValorTotal(valorTotal);
        this.setNomeCliente(nomeCliente);
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("data nao pode ser nulo");
        }
        this.data = data;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null) {
            throw new IllegalArgumentException("nomeCliente nao pode ser nulo");
        }
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
