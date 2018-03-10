package fr.uitt.biblio.modele;

import java.io.Serializable;

public class Livre  implements Serializable  {
	public String titreLivre;
	public String categorieLivre;
	
	public Livre (String unTitre, String uneCatégorie) {
		titreLivre = unTitre;
		categorieLivre = uneCatégorie;
	}

	public String getCategorieLivre() {
		return categorieLivre;
	}

	public String getTitreLivre() {
		return titreLivre;
	}

	public void setCategorieLivre(String unCategorieLivre) {
		categorieLivre = unCategorieLivre;
	}

	public void setTitreLivre(String unTitreLivre) {
		titreLivre = unTitreLivre;
	}
	public String toString (){
		return getTitreLivre() + "  " + getCategorieLivre (); 
	}
}
