package com.lesamisdelescalade.criteria;


public class SearchSiteCriteria {
	// Site
	private String libelle;
	private Float hauteur;
	private Integer tagYN;
	private String ville;
	
	// Secteur
	private Integer nbSecteurMax;
	
	// Voie
	private Integer nbVoieMax;
	
	// Cotation
	private Integer nbLongueurMax;
		
	// Topo
	private Integer nbTopoMax;
	

	public SearchSiteCriteria(String libelle, Float hauteur, Integer tagYN, String ville,
			Integer nbSecteurMax, Integer nbVoieMax, Integer nbLongueurMax, Integer nbTopoMax) {
		super();
		this.libelle = libelle;
		this.hauteur = hauteur;
		this.tagYN = tagYN;
		this.ville = ville;;
		this.nbSecteurMax = nbSecteurMax;
		this.nbVoieMax = nbVoieMax;
		this.nbLongueurMax = nbLongueurMax;
		this.nbTopoMax = nbTopoMax;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Float getHauteur() {
		return hauteur;
	}

	public void setHauteur(Float hauteur) {
		this.hauteur = hauteur;
	}

	public Integer getTagYN() {
		return tagYN;
	}

	public void setTagYN(Integer tagYN) {
		this.tagYN = tagYN;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public Integer getNbSecteurMax() {
		return nbSecteurMax;
	}

	public void setNbSecteurMax(Integer nbSecteurMax) {
		this.nbSecteurMax = nbSecteurMax;
	}

	public Integer getNbTopoMax() {
		return nbTopoMax;
	}

	public void setNbTopoMax(Integer nbTopoMax) {
		this.nbTopoMax = nbTopoMax;
	}

	public Integer getNbLongueurMax() {
		return nbLongueurMax;
	}

	public void setNbLongueurMax(Integer nbLongueurMax) {
		this.nbLongueurMax = nbLongueurMax;
	}

	public Integer getNbVoieMax() {
		return nbVoieMax;
	}

	public void setNbVoieMax(Integer nbVoieMax) {
		this.nbVoieMax = nbVoieMax;
	}

	public Boolean isNull() {
		return this.libelle == null && this.hauteur == null && this.tagYN == null && this.ville == null
				&& this.nbSecteurMax == null && this.nbTopoMax == null && this.nbLongueurMax == null;
	}
}
