import java.util.Date;

public class Boleto {

	String codigoBoleto;
	Date data;
	float valorPago;
	
	public Boleto(String codigoBoleto, Date data, float valorPago) {
		this.codigoBoleto = codigoBoleto;
		this.data = data;
		this.valorPago = valorPago;
	}
	
}
