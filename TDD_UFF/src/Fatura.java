import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fatura {
	
	private Date data;
	private float valor;
	private String nomeCliente;
	private char paga;
	private List<Pagamento> pagamentos;
	
	public Fatura(Date data, float valor, String nomeCliente) {
		this.data = data;
		this.valor = valor;
		this.nomeCliente = nomeCliente;
		this.pagamentos = new ArrayList<Pagamento>();
		this.paga = ' ';
	}
	
	public float getValor() {
		return this.valor;
	}
	
	public void setPaga() {
		this.paga = 'X';
	}
	
	public char getPaga() {
		return this.paga;
	}
	
	public void addPagamento(Pagamento pagamento) {
		pagamentos.add(pagamento);
	}
	
	public List<Pagamento> getPagamentos() {
		return this.pagamentos;
	}
}
