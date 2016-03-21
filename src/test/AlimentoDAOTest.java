package test;

import java.util.ArrayList;

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
		ArrayList<Alimento> listaAlimento = dao.getAllAlimento();
		alimento.setNome("Açafrão");
		alimento.setIdEstoque(1);
		alimento.setTotal(0);
//		float custo = 50;
		dao.adicionaAlimento(alimento);
		Assert.assertEquals(alimento.getIdEstoque(), dao.getLastAlimento().getIdEstoque());
		int idAlimento = dao.buscaAlimento(alimento.getIdEstoque()).getIdEstoque();
		Assert.assertEquals(alimento.getIdEstoque(), idAlimento);
		/*dao.modificaCusto(alimento.getIdEstoque(), custo);
		Assert.assertEquals(dao.buscaAlimento(idAlimento).getQuantidade(), 
				(alimento.getQuantidade() - (custo/alimento.getPeso_liq())),0.001);
		*/
		Assert.assertEquals(listaAlimento.size() + 1, dao.getAllAlimento().size());
	}

	@Test
	public void test2RemoveAlimento() {
		ArrayList<Alimento> listaAlimento = dao.getAllAlimento();
		alimento = dao.getLastAlimento();
		dao.removeAlimento(alimento.getIdAlimento());
		Assert.assertNotEquals(dao.getLastAlimento().getIdAlimento(), alimento.getIdAlimento());
		Assert.assertEquals(listaAlimento.size() - 1, dao.getAllAlimento().size());
	}
		
}
