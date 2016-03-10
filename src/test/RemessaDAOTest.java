package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.RemessaDAO;
import model.Remessa;

public class RemessaDAOTest {
	private Remessa remessa;
	private RemessaDAO dao = new RemessaDAO();
	
	@Before
	public void setUp() {
		remessa = new Remessa();
	}
	
	@Test
	public void testAdicionaRemessa() {
		remessa.setNomeAlimento("A�afr�o");
		remessa.setIdRemessa(5);
		remessa.setIdEscola(1);
		remessa.setTipo(2);
		remessa.setPeso_liq(100);
		remessa.setQuantidade(03);
		remessa.setFalta(2);
		remessa.setRecebido(300);
		remessa.setDate("01/03/2016");
		dao.adicionaRemessa(remessa);
		Assert.assertEquals(remessa.getIdRemessa(), dao.getLastRemessa().getIdRemessa());
	}

	@Test
	public void testRemoveRemessa() {
		remessa = dao.getLastRemessa();
		dao.removeRemessa(remessa.getIdRemessa());
		Assert.assertNotEquals(dao.getLastRemessa(), remessa);
	}

}
