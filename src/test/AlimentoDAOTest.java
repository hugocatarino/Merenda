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
	public void test1AdicionaAlimento() {
		alimento.setNome("Açafrão");
		alimento.setIdRemessa(1);
		alimento.setTipo(2);
		alimento.setPeso_liq(100);
		alimento.setQuantidade(03);
		alimento.setFalta(2);
		alimento.setRecebido(300);
		float custo = 50;
		dao.adicionaAlimento(alimento);
		Assert.assertEquals(alimento.getIdAlimento(), dao.getLastAlimento().getIdAlimento());
		int idAlimento = dao.buscaAlimento(alimento.getIdAlimento()).getIdAlimento();
		Assert.assertEquals(alimento.getIdAlimento(), idAlimento);
		dao.modificaCusto(alimento.getIdAlimento(), custo);
		Assert.assertEquals(dao.buscaAlimento(idAlimento).getQuantidade(), 
				(alimento.getQuantidade() - (custo/alimento.getPeso_liq())),0.001);
	}	
	
	@Test
	public void test2RemoveAlimento() {
		alimento = dao.getLastAlimento();
		dao.removeRemessa(alimento.getIdAlimento());
		Assert.assertNotEquals(dao.getLastAlimento().getIdAlimento(), alimento.getIdAlimento());
	}
	
	
	
	
}
