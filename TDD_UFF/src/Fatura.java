import java.util.Date;

public class Fatura {
	
	private Date data;
	private float valor;
	private String nomeCliente;
	private char paga;
	
	public Fatura(Date data, float valor, String nomeCliente) {
		this.data = data;
		this.valor = valor;
		this.nomeCliente = nomeCliente;
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
}
