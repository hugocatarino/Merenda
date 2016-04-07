package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.AlimentoDAO;
import model.Alimento;

public class AlimentoDAOTest {
	private AlimentoDAO dao = new AlimentoDAO();
	private Alimento alimento;
	private String nomeAlimento = "Teste";

	@Before
	public void setUp() {
		alimento = new Alimento();
	}

	@Test
	public void test1AdicionaAlimento() {
		ArrayList<Alimento> listaAlimento = dao.getAllAlimento();
		alimento.setNome(nomeAlimento);
		alimento.setIdEstoque(1);
		alimento.setTotal(0);
//		float custo = 50;
		dao.adicionaAlimento(alimento);
		Assert.assertEquals(alimento.getIdEstoque(), dao.getLastAlimento().getIdEstoque());
		Assert.assertNotEquals(listaAlimento.size(), dao.getAllAlimento().size());
	}

	@Test
	public void test2RemoveAlimento() {
		ArrayList<Alimento> listaAlimento = dao.getAllAlimento();
		dao.removeAlimento(nomeAlimento);
		Assert.assertNotEquals(dao.getLastAlimento().getNome(), alimento.getNome());
		Assert.assertEquals(listaAlimento.size() - 1, dao.getAllAlimento().size());
	}
}
