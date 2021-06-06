package com.lesamisdelescalade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Commentaire entity
 * @author Lilian
 *
 */
@Entity
@Table(name = "commentaire")
public class Commentaire implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String contenu;
    private Utilisateur utilisateur;
    private transient Site site;
    
    public Commentaire() {
		super();
	}

	public Commentaire(int id, String contenu, Utilisateur utilisateur, Site site) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.utilisateur = utilisateur;
		this.site = site;
	}

	@Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "contenu", nullable = true, length = 255)
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commentaire that = (Commentaire) o;

        if (id != that.id) return false;
        return Objects.equals(contenu, that.contenu);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (contenu != null ? contenu.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id", nullable = false)
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @ManyToOne
    @JoinColumn(name = "site_id", referencedColumnName = "id", nullable = false)
    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
    
    @Override
    public String toString() {
        return "Commentaire [id=" + id + "]";
    }
}
