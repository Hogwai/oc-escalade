package com.lesamisdelescalade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Voie entity
 * @author Lilian
 *
 */
@Entity
@Table(name = "voie")
public class Voie implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private byte equipeeYN;
    private Collection<Longueur> longueurs;
    private Cotation cotation;
    private Secteur secteur;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "equipeeY_N", nullable = false)
    public byte getEquipeeYN() {
        return equipeeYN;
    }

    public void setEquipeeYN(byte equipeeYN) {
        this.equipeeYN = equipeeYN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voie voie = (Voie) o;

        if (id != voie.id) return false;
        return equipeeYN == voie.equipeeYN;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) equipeeYN;
        return result;
    }

    @OneToMany(mappedBy = "voie")
    public Collection<Longueur> getLongueurs() {
        return longueurs;
    }

    public void setLongueurs(Collection<Longueur> longueurs) {
        this.longueurs = longueurs;
    }

    @ManyToOne
    @JoinColumn(name = "cotation_id", referencedColumnName = "id", nullable = false)
    public Cotation getCotation() {
        return cotation;
    }

    public void setCotation(Cotation cotation) {
        this.cotation = cotation;
    }

    @ManyToOne
    @JoinColumn(name = "secteur_id", referencedColumnName = "id", nullable = false)
    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
}
