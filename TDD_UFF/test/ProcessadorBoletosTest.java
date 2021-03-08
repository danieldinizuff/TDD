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
	}
	
	@Test
	public void testFaturaNaoPaga() {
		
		Fatura fatura = new Fatura(new Date(), 500, "Daniel");
		List<Boleto> listaBoletos = new ArrayList<Boleto>();
		listaBoletos.add(new Boleto("12345", new Date(), 400));
		listaBoletos.add(new Boleto("12346", new Date(), 20));
		listaBoletos.add(new Boleto("12347", new Date(), 50));
		Assertions.assertEquals("NÃO PAGA", proc.pagar(fatura, listaBoletos));
	}
	
	@Test
	public void testAssociaPagamento() {
		Fatura fatura = new Fatura(new Date(), 500, "Daniel");
		Pagamento pagamento = new Pagamento(100, new Date(), Pagamento.TipoPagamento.BOLETO);
		fatura.addPagamento(pagamento);
		Assertions.assertNotNull(fatura.getPagamentos());
	}
	
	@Test
	public void testAssociaPagamentosFaturaNaoPaga() {
		Fatura fatura = new Fatura(new Date(), 500, "Daniel");
		List<Boleto> listaBoletos = new ArrayList<Boleto>();
		listaBoletos.add(new Boleto("12345", new Date(), 400));
		listaBoletos.add(new Boleto("12346", new Date(), 20));
		listaBoletos.add(new Boleto("12347", new Date(), 50));
		proc.pagar(fatura, listaBoletos);
		Assertions.assertTrue(3 == fatura.getPagamentos().size());
		Assertions.assertEquals(' ', fatura.getPaga());
	}
	
	@Test
	public void testAssociaPagamentosFaturaPaga() {
		Fatura fatura = new Fatura(new Date(), 500, "Daniel");
		List<Boleto> listaBoletos = new ArrayList<Boleto>();
		listaBoletos.add(new Boleto("12345", new Date(), 400));
		listaBoletos.add(new Boleto("12346", new Date(), 20));
		listaBoletos.add(new Boleto("12347", new Date(), 50));
		listaBoletos.add(new Boleto("12347", new Date(), 30));
		proc.pagar(fatura, listaBoletos);
		Assertions.assertTrue(4 == fatura.getPagamentos().size());
		Assertions.assertEquals('X', fatura.getPaga());
	}
	
}
