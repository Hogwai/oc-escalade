package com.lesamisdelescalade.criteria;

/**
 * Criteria class for the search site feature
 * @author Lilian
 *
 */
public class SearchSiteCriteria {
	// Site
	private String libelle;
	private Float hauteur;
	private Integer tagYN;
	private String ville;
	
	// Secteur
	private Integer nbSecteurMin;
		

	public SearchSiteCriteria(String libelle, Float hauteur, Integer tagYN, String ville,
			Integer nbSecteurMin) {
		super();
		this.libelle = libelle;
		this.hauteur = hauteur;
		this.tagYN = tagYN;
		this.ville = ville;
		this.nbSecteurMin = nbSecteurMin;
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
	
	public Integer getNbSecteurMin() {
		return nbSecteurMin;
	}

	public void setNbSecteurMax(Integer nbSecteurMin) {
		this.nbSecteurMin = nbSecteurMin;
	}

	public Boolean isNull() {
		return this.libelle == null && this.hauteur == null && this.tagYN == null && this.ville == null
				&& this.nbSecteurMin == null;
	}
}
