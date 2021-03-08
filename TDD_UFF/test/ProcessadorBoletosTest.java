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
		
		Fatura fatura = new Fatura(new Date(), 1500, "Daniel");
		List<Boleto> listaBoletos = new ArrayList<Boleto>();
		listaBoletos.add(new Boleto("12345", new Date(), 500));
		Assertions.assertEquals("PAGA", proc.pagar(fatura, listaBoletos));
		
	}
	
}
