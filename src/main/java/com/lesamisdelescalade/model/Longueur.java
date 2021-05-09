package com.lesamisdelescalade.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "longueur")
public class Longueur implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private byte relaiYN;
    private Cotation cotation;
    private Voie voie;

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
    @Column(name = "relaiY_N", nullable = false)
    public byte getRelaiYN() {
        return relaiYN;
    }

    public void setRelaiYN(byte relaiYN) {
        this.relaiYN = relaiYN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Longueur longueur = (Longueur) o;

        if (id != longueur.id) return false;
        return relaiYN == longueur.relaiYN;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) relaiYN;
        return result;
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
    @JoinColumn(name = "voie_id", referencedColumnName = "id", nullable = false)
    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }
}
