package com.lesamisdelescalade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "site")
public class Site implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String libelle;
    private Double hauteur;
    private Byte tagYN;
    private String ville;
    private String pays;
    private Collection<Commentaire> commentaires;
    private Collection<Secteur> secteurs;
    private Collection<Topo> topos;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "libelle", length = 45)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "hauteur")
    public Double getHauteur() {
        return hauteur;
    }

    public void setHauteur(Double hauteur) {
        this.hauteur = hauteur;
    }

    @Basic
    @Column(name = "tagY_N")
    public Byte getTagYN() {
        return tagYN;
    }

    public void setTagYN(Byte tagYN) {
        this.tagYN = tagYN;
    }

    @Basic
    @Column(name = "ville", length = 100)
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Basic
    @Column(name = "pays", length = 100)
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Site site = (Site) o;

        if (id != site.id) return false;
        if (!Objects.equals(libelle, site.libelle)) return false;
        if (!Objects.equals(hauteur, site.hauteur)) return false;
        if (!Objects.equals(tagYN, site.tagYN)) return false;
        if (!Objects.equals(ville, site.ville)) return false;
        return Objects.equals(pays, site.pays);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (hauteur != null ? hauteur.hashCode() : 0);
        result = 31 * result + (tagYN != null ? tagYN.hashCode() : 0);
        result = 31 * result + (ville != null ? ville.hashCode() : 0);
        result = 31 * result + (pays != null ? pays.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "site")
    public Collection<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Collection<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    @OneToMany(mappedBy = "site")
    public Collection<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(Collection<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    @OneToMany(mappedBy = "site")
    public Collection<Topo> getTopos() {
        return topos;
    }

    public void setTopos(Collection<Topo> topos) {
        this.topos = topos;
    }
}
