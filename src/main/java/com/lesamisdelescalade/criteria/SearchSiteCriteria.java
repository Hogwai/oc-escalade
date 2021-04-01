package com.lesamisdelescalade.criteria;


public class SearchSiteCriteria {
	// Site
	private String libelle;
	private Float hauteur;
	private Integer tagYN;
	private String ville;
	private String pays;
	
	// Secteur
	private Integer nbSecteurStart;
	private Integer nbSecteurEnd;
	
	// Topo
	private Integer nbTopoStart;
	private Integer nbTopoEnd;
	
	// Cotation
	private Integer cotationId;

	public SearchSiteCriteria(String libelle, Float hauteur, Integer tagYN, String ville, String pays,
			Integer nbSecteurStart, Integer nbSecteurEnd, Integer nbTopoStart, Integer nbTopoEnd, Integer cotationId) {
		super();
		this.libelle = libelle;
		this.hauteur = hauteur;
		this.tagYN = tagYN;
		this.ville = ville;
		this.pays = pays;
		this.nbSecteurStart = nbSecteurStart;
		this.nbSecteurEnd = nbSecteurEnd;
		this.nbTopoStart = nbTopoStart;
		this.nbTopoEnd = nbTopoEnd;
		this.cotationId = cotationId;
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

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Integer getNbSecteurStart() {
		return nbSecteurStart;
	}

	public void setNbSecteurStart(Integer nbSecteurStart) {
		this.nbSecteurStart = nbSecteurStart;
	}

	public Integer getNbSecteurEnd() {
		return nbSecteurEnd;
	}

	public void setNbSecteurEnd(Integer nbSecteurEnd) {
		this.nbSecteurEnd = nbSecteurEnd;
	}

	public Integer getNbTopoStart() {
		return nbTopoStart;
	}

	public void setNbTopoStart(Integer nbTopoStart) {
		this.nbTopoStart = nbTopoStart;
	}

	public Integer getNbTopoEnd() {
		return nbTopoEnd;
	}

	public void setNbTopoEnd(Integer nbTopoEnd) {
		this.nbTopoEnd = nbTopoEnd;
	}

	public Integer getCotationId() {
		return cotationId;
	}

	public void setCotationId(Integer cotationId) {
		this.cotationId = cotationId;
	}
	
	public Boolean isNull() {
		return this.libelle == null && this.hauteur == null && this.tagYN == null && this.ville == null
				&& this.pays == null && this.nbSecteurStart == null && this.nbSecteurEnd == null
				&& this.nbTopoStart == null && this.nbTopoEnd == null && this.cotationId == null;
	}
}
