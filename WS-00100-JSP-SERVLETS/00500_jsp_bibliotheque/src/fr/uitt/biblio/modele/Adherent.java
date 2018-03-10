/*
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
package fr.uitt.biblio.modele;

import java.io.Serializable;
import java.util.ArrayList;

public class Adherent implements Serializable, IAdherent {
	private String nomAdherent;
	private String motDePasse;
	private ArrayList listeLivres;

	public Adherent (String unNomAdherent, String unMotDePasse) {
		nomAdherent = unNomAdherent;
		motDePasse = unMotDePasse;
		listeLivres = new ArrayList ();
	}
	

	public ArrayList getListeLivres() {
		return listeLivres;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public String getNomAdherent() {
		return nomAdherent;
	}

	
	public void setMotDePasse(String unMotDePasse) {
		motDePasse = unMotDePasse;
	}

	public void setNomAdherent(String unNom) {
		nomAdherent = unNom;
	}

	public void ajoutLivre(Livre unLivre) {
		listeLivres.add(unLivre);
	}

	public Livre retraitLivre (String unTitre, String uneCategorie){
		return null;
		
	}
}
