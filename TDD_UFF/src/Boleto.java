import java.util.Date;

public class Boleto {

	private String codigoBoleto;
	private Date data;
	private float valorPago;
	
	public Boleto(String codigoBoleto, Date data, float valorPago) {
		this.codigoBoleto = codigoBoleto;
		this.data = data;
		this.valorPago = valorPago;
	}
	
	public float getValorPago() {
		return this.valorPago;
	}
	
}
