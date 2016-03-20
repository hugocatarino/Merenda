package main;

import dao.EscolaDAO;
import model.Escola;
import view.TelaPrincipal;

public class main {

	public static void main(String[] args) {	
		/*
		Escola escola = new Escola();
		EscolaDAO dao = new EscolaDAO();
		escola.setNome("Escola Municipal Grande Vale");
		dao.adicionaEscola(escola);
		*/
//		dao.removeEscola(escola.getNome());
            TelaPrincipal mainFrame = new TelaPrincipal();
            mainFrame.setVisible(true);

	}

}
