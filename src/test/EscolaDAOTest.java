package test;

import org.junit.Before;
import org.junit.Test;

import dao.EscolaDAO;
import org.junit.Assert;
import model.Escola;

public class EscolaDAOTest {
	private Escola escola;
	private EscolaDAO dao = new EscolaDAO();
	
	@Before
	public void setUp() {
		escola = new Escola();
	}
	
	@Test
	public void testAdicionaEscola() {
		String nome = "Escola Municipal Saci Perere";
		escola.setNome(nome);
		dao.adicionaEscola(escola);
		Escola test = dao.getLastEscola();
		Assert.assertEquals(escola.getNome(), test.getNome());
	}
	
	@Test
	public void testRemoveEscola() {
		String nome = "Escola Municipal Saci Perere";
		escola.setNome(nome);
		Escola test = dao.getLastEscola();
		dao.removeEscola(nome);
		Assert.assertNotEquals(test.getIdEscola(), dao.getLastEscola().getIdEscola());
	}

}
