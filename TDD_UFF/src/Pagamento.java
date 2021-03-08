import java.util.Date;

public class Pagamento {
	
	enum TipoPagamento { BOLETO };
	
	private float valorPago;
	private Date data;
	private TipoPagamento tipoDePagamento;
	
	public Pagamento(float valorPago, Date data, TipoPagamento tipoDePagamento) {
		this.valorPago = valorPago;
		this.data = data;
		this.tipoDePagamento = tipoDePagamento;
	}
	
}
