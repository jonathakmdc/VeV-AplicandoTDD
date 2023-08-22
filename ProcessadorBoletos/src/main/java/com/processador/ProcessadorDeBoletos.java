package ProcessadorBoletos.src.main.java.com.processador;

import java.util.ArrayList;

public class ProcessadorDeBoletos {
    public ArrayList<Pagamento> analisaBoletos(ArrayList<Boleto> boletos){
        ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();


        for (Boleto boleto : boletos) {
            Pagamento pagamento = new Pagamento(boleto.getValorPago(), boleto.getData(), "BOLETO");
            pagamentos.add(pagamento);
        }


        return pagamentos;
    }


    public double somaBoletosPagos(ArrayList<Boleto> boletos) {
        double totalPago = 0;
        for (Boleto boleto : boletos) {
            totalPago += boleto.getValorPago();
        }
        return totalPago;
    }


}
