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
		alimento.setIdEstoque(1);
		alimento.setTipo(2);
		alimento.setPeso_liq(100);
		alimento.setQuantidade(03);
		alimento.setFalta(2);
		alimento.setRecebido(300);
		int idRemessa = 1;
		float custo = 50;
		dao.adicionaAlimento(alimento,idRemessa);
		Assert.assertEquals(alimento.getIdEstoque(), dao.getLastAlimento().getIdEstoque());
		int idAlimento = dao.buscaAlimento(alimento.getIdEstoque()).getIdEstoque();
		Assert.assertEquals(alimento.getIdEstoque(), idAlimento);
		/*dao.modificaCusto(alimento.getIdEstoque(), custo);
		Assert.assertEquals(dao.buscaAlimento(idAlimento).getQuantidade(), 
				(alimento.getQuantidade() - (custo/alimento.getPeso_liq())),0.001);
		*/
	}

	@Test
	public void test2RemoveAlimento() {
		alimento = dao.getLastAlimento();
		dao.removeAlimento(alimento.getIdAlimento());
		Assert.assertNotEquals(dao.getLastAlimento().getIdAlimento(), alimento.getIdAlimento());
	}
	
	
	
	
}
