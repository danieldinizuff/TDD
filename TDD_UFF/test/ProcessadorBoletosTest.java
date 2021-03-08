import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProcessadorBoletosTest {
	
	ProcessadorBoletos proc;
	
	@BeforeEach
	public void inicializa() {
		proc = new ProcessadorBoletos();
	}
	
	@Test
	public void testFaturaPaga() {
		
		Fatura fatura = new Fatura(new Date(), 500, "Daniel");
		List<Boleto> listaBoletos = new ArrayList<Boleto>();
		listaBoletos.add(new Boleto("12345", new Date(), 500));
		Assertions.assertEquals("PAGA", proc.pagar(fatura, listaBoletos));
		System.out.println("Test paga: " + fatura.getPaga());
	}
	
	@Test
	public void testFaturaNaoPaga() {
		
		Fatura fatura = new Fatura(new Date(), 500, "Daniel");
		List<Boleto> listaBoletos = new ArrayList<Boleto>();
		listaBoletos.add(new Boleto("12345", new Date(), 400));
		listaBoletos.add(new Boleto("12346", new Date(), 20));
		listaBoletos.add(new Boleto("12347", new Date(), 50));
		Assertions.assertEquals("NÃO PAGA", proc.pagar(fatura, listaBoletos));
		System.out.println("Test não paga: " + fatura.getPaga());
	}
	
	@Test
	public void testAssociaPagamento() {
		Fatura fatura = new Fatura(new Date(), 500, "Daniel");
		Pagamento pagamento = new Pagamento(100, new Date(), Pagamento.TipoPagamento.BOLETO);
		fatura.setPagamento(pagamento);
		Assertions.assertNotNull(fatura.getPagamento());
	}
	
}
