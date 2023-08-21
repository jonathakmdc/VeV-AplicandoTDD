package ProcessadorBoletos.src.main.java.com.processador;

import java.util.ArrayList;

public class ProcessadorDeBoletos {
    ArrayList<Boleto> listaBoletos = new ArrayList<Boleto>();

    public ProcessadorDeBoletos(ArrayList<Boleto> listaBoletos) {
        this.listaBoletos = listaBoletos;
    }

    public ArrayList<Boleto> getListaBoletos() {
        return listaBoletos;
    }
}
