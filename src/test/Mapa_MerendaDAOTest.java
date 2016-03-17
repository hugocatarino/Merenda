package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.Mapa_MerendaDAO;
import model.Mapa_Merenda;

public class Mapa_MerendaDAOTest {
	private Mapa_Merenda mapa;
	private Mapa_MerendaDAO dao = new Mapa_MerendaDAO();
	@Before
	public void setUp() {
		mapa = new Mapa_Merenda();
	}
	
	@Test
	public void test1AdicionaMapa_Merenda() {
		mapa.setRemessa_idRemessa(1);
		mapa.setCardapio("Arroz com frango");
		mapa.setTurno("Primeiro");
		mapa.setNumero_Aluno(40);
		mapa.setDate("05/03/2016");
		dao.adicionaMapa_Merenda(mapa);
		Assert.assertEquals(mapa.getIdMapa_Merenda(),  dao.getLastMapa_Merenda().getIdMapa_Merenda());
	}
	@Test
	public void test2RemoveMapa_Merenda() {
		int id = dao.getLastMapa_Merenda().getIdMapa_Merenda();
		dao.removeMapa_Merenda(id);
		Assert.assertNotEquals(id, dao.getLastMapa_Merenda().getIdMapa_Merenda());

	}
	
	

}
