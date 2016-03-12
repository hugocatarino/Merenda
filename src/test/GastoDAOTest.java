package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.GastoDAO;
import model.Gasto;

public class GastoDAOTest {
	
	private GastoDAO dao = new GastoDAO();
	private Gasto gasto;
	
	@Before
	public void setUp() {
		gasto = new Gasto();
	}
	
	@Test
	public void test1AdicionaGasto() {
		gasto.setIdAlimento(1);
		gasto.setIdMapa_Merenda(1);
		gasto.setPeso(50);
		dao.adicionaGasto(gasto);
		Assert.assertEquals(gasto.getIdGasto(), dao.GetLastGasto().getIdGasto());
	}
	
	@Test
	public void test2RemoveGasto() {
		int idTest = dao.GetLastGasto().getIdGasto();
		dao.removeGasto(idTest);
		Assert.assertNotEquals(idTest, dao.GetLastGasto().getIdGasto());
	}

}
