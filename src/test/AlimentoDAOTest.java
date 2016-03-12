package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.AlimentoDAO;
import model.Alimento;

public class AlimentoDAOTest {
	AlimentoDAO dao = new AlimentoDAO();
	Alimento alimento;
	@Before
	public void setUp() {
		alimento = new Alimento();
	}
	@Test
	public void testAdicionaAlimento() {
		alimento.setNome("Açafrão");
		alimento.setIdRemessa(5);
		alimento.setIdRemessa(1);
		alimento.setTipo(2);
		alimento.setPeso_liq(100);
		alimento.setQuantidade(03);
		alimento.setFalta(2);
		alimento.setRecebido(300);
		dao.adicionaAlimento(alimento);
		Assert.assertEquals(alimento.getIdAlimento(), dao.getLastAlimento().getIdAlimento());
	}

	@Test
	public void testRemoveAlimento() {
		alimento = dao.getLastAlimento();
		dao.removeRemessa(alimento.getIdAlimento());
		Assert.assertNotEquals(dao.getLastAlimento().getIdAlimento(), alimento.getIdAlimento());
	}
	

}
