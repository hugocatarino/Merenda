package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.Remessa_has_AlimentoDAO;
import model.Remessa_has_Alimento;

public class Remessa_has_AlimentoDAOTest {

	Remessa_has_AlimentoDAO dao = new Remessa_has_AlimentoDAO();
	Remessa_has_Alimento remessaAlimento;
	@Before
	public void setUp() {
		remessaAlimento = new Remessa_has_Alimento();
	}
	
	@Test
	public void test1AdicionaRemessaALimento() {
		remessaAlimento.setIdAlimento("Açafrão");
		remessaAlimento.setIdRemessa(1);
		remessaAlimento.setFalta(2);
		remessaAlimento.setPeso_liq(100);
		remessaAlimento.setQuantidade(3);
		remessaAlimento.setRecebido(300);
		remessaAlimento.setTipo(2);
//		float custo = 50;
		dao.adicionaRemessa_has_Alimento(remessaAlimento);
		Assert.assertEquals(remessaAlimento.getIdAlimento(), dao.getLastRemessa_has_Alimento().getIdAlimento());
		Assert.assertEquals(remessaAlimento.getIdRemessa(), dao.getLastRemessa_has_Alimento().getIdRemessa());
	}

	@Test
	public void test2RemoveRemessa_has_Alimento() {
		Remessa_has_Alimento remessaAlimento = dao.getLastRemessa_has_Alimento();
		dao.removeIdAlimentoRemessa_has_Alimento(remessaAlimento.getIdAlimento());
		Assert.assertNotEquals(dao.getLastRemessa_has_Alimento().getIdAlimento(), remessaAlimento.getIdAlimento());
	}
		
}