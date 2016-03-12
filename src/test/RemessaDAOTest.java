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
		remessa.setIdEscola(1);
		remessa.setNome("infantil");
		remessa.setDate("01/03/2016");
		//Remessa teste = dao.getLastRemessa();
		Remessa teste = dao.getLastRemessa();
		Assert.assertNotEquals(teste.getIdRemessa(), remessa.getIdRemessa());
		dao.adicionaRemessa(remessa);
		teste = dao.getLastRemessa();
		Assert.assertEquals(teste.getIdRemessa(), remessa.getIdRemessa());
	}
	
	@Test
	public void testRemoveRemessa() {
		int id = dao.getLastRemessa().getIdRemessa();
		dao.removeRemessa(id);
		Assert.assertNotEquals(id, dao.getLastRemessa().getIdRemessa());
	}
	
}
