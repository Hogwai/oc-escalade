package com.lesamisdelescalade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "topo")
public class Topo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String nom;
    private String description;
    private Date dateParution;
    private StatutTopo statutTopo;
    private Utilisateur proprietaire;
    private Utilisateur emprunteur;
    private Site site;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom", length = 50)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "description", length = 250)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "date_parution")
    public Date getDateParution() {
        return dateParution;
    }

    public void setDateParution(Date dateParution) {
        this.dateParution = dateParution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topo topo = (Topo) o;

        if (id != topo.id) return false;
        if (!Objects.equals(nom, topo.nom)) return false;
        if (!Objects.equals(description, topo.description)) return false;
        return Objects.equals(dateParution, topo.dateParution);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dateParution != null ? dateParution.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "statut_topo_id", referencedColumnName = "id", nullable = false)
    public StatutTopo getStatutTopo() {
        return statutTopo;
    }

    public void setStatutTopo(StatutTopo statutTopo) {
        this.statutTopo = statutTopo;
    }

    @ManyToOne
    @JoinColumn(name = "proprietaire_id", referencedColumnName = "id", nullable = false)
    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }

    @ManyToOne
    @JoinColumn(name = "emprunteur_id", referencedColumnName = "id")
    public Utilisateur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Utilisateur emprunteur) {
        this.emprunteur = emprunteur;
    }

    @ManyToOne
    @JoinColumn(name = "site_id", referencedColumnName = "id", nullable = false)
    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
