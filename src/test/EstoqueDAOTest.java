package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.EstoqueDAO;
import model.Estoque;

public class EstoqueDAOTest {

	private EstoqueDAO dao = new EstoqueDAO();
	private Estoque estoque;

	@Before
	public void setUp() {
		estoque = new Estoque();
	}

	@Test
	public void test2AdicionaEstoque() {
		estoque.setIdEscola(1);
		estoque.setNome("Teste");
		dao.adicionaEstoque(estoque);
		Assert.assertEquals(estoque.getIdEstoque(), dao.getLastEstoque().getIdEstoque());
	}
	
	@Test
	public void test1RemoveAlimento() {
		estoque = dao.getLastEstoque();
		System.out.println(estoque.getNome());
		if(estoque.getNome().equals("Teste")) {
			dao.removeEstoque(estoque.getIdEstoque());
			Assert.assertNotEquals(dao.getLastEstoque().getIdEstoque(), estoque.getIdEstoque());
		}
		else {
			Assert.assertFalse(true);
		}
	}
}
