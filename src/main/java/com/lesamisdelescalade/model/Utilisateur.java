package com.lesamisdelescalade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Utilisateur entity
 * @author Lilian
 *
 */
@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private String nom;
    private String prenom;
    private String numeroTel;
    private String adresse;
    private String codePostal;
    private String email;
    private String pseudo;
    private String motDePasse;
    @Basic
    @Column(name = "membreAssoY_N")
    private Integer membreAssoYN;
    private transient Collection<Commentaire> commentaires;
    private transient Collection<Topo> toposProprietaire;
    private transient Collection<Topo> toposEmprunteur;

    public Utilisateur() {}

    public Utilisateur(int id, String nom, String prenom, String numeroTel, String adresse,
                       String codePostal, String email, String pseudo, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTel = numeroTel;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.email = email;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
    }

    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom", length = 45)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", length = 45)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "numeroTel", length = 20)
    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    @Basic
    @Column(name = "adresse", length = 45)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "codePostal", length = 45)
    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Basic
    @Column(name = "email", length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "pseudo", length = 45)
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @Basic
    @Column(name = "motDePasse", length = 45)
    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    @Basic
    @Column(name = "membreAssoY_N")
    public Integer getMembreAssoYN() {
		return membreAssoYN;
	}

	public void setMembreAssoYN(Integer membreAssoYN) {
		this.membreAssoYN = membreAssoYN;
	}

	/*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilisateur that = (Utilisateur) o;

        if (id != that.id) return false;
        if (!Objects.equals(nom, that.nom)) return false;
        if (!Objects.equals(prenom, that.prenom)) return false;
        if (!Objects.equals(numeroTel, that.numeroTel)) return false;
        if (!Objects.equals(adresse, that.adresse)) return false;
        if (!Objects.equals(codePostal, that.codePostal)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(pseudo, that.pseudo)) return false;
        return Objects.equals(motDePasse, that.motDePasse);
    }*/

    /*@Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (numeroTel != null ? numeroTel.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (codePostal != null ? codePostal.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (pseudo != null ? pseudo.hashCode() : 0);
        result = 31 * result + (motDePasse != null ? motDePasse.hashCode() : 0);
        return result;
    }*/

    @OneToMany(mappedBy = "utilisateur")
    public Collection<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Collection<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    @OneToMany(mappedBy = "proprietaire")
    public Collection<Topo> getToposProprietaire() {
        return toposProprietaire;
    }

    public void setToposProprietaire(Collection<Topo> toposProprietaire) {
        this.toposProprietaire = toposProprietaire;
    }

    @OneToMany(mappedBy = "emprunteur")
    public Collection<Topo> getToposEmprunteur() {
        return toposEmprunteur;
    }

    public void setToposEmprunteur(Collection<Topo> toposEmprunteur) {
        this.toposEmprunteur = toposEmprunteur;
    }
}
