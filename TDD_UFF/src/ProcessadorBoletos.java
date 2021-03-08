import java.util.Date;
import java.util.List;

public class ProcessadorBoletos {
	
	public String pagar(Fatura fatura, List<Boleto> boletos) {
		float total = 0;
		for(int i = 0; i < boletos.size(); i++) {
			total += boletos.get(i).getValorPago();
			Pagamento pagamento = new Pagamento(boletos.get(i).getValorPago(), new Date(), Pagamento.TipoPagamento.BOLETO);
			fatura.addPagamento(pagamento);
		}
		if(total >= fatura.getValor()) {
			fatura.setPaga();
			return "PAGA";
		}
		else {
			return "NÃO PAGA";
		}
	}
	
}
