package com.lesamisdelescalade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * Cotation entity
 * @author Lilian
 *
 */
@Entity
@Table(name = "cotation")
public class Cotation implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String libelle;
    private Collection<Longueur> longueurs;
    private Collection<Voie> voies;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "libelle", nullable = false, length = 2)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cotation cotation = (Cotation) o;

        if (id != cotation.id) return false;
        return Objects.equals(libelle, cotation.libelle);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cotation")
    public Collection<Longueur> getLongueurs() {
        return longueurs;
    }

    public void setLongueurs(Collection<Longueur> longueurs) {
        this.longueurs = longueurs;
    }

    @OneToMany(mappedBy = "cotation")
    public Collection<Voie> getVoies() {
        return voies;
    }

    public void setVoies(Collection<Voie> voies) {
        this.voies = voies;
    }
}
