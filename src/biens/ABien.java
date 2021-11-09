package biens;

import fraisGestion.AFraisGestion;
import utilisateurs.IUtilisateur;
import encheres.Encherir;
import encheres.EncherirNotPossibleException;

import java.util.Calendar;
import java.util.Date;

public abstract class ABien implements IBien {
    private String description;
    private double montantD;
    private double montant;
    private IUtilisateur dernierEncherisseur;
    private Calendar dateD;
    private Calendar dateF;

    public ABien(String description, double montantD, Calendar dateD, Calendar dateF) {
        this.description = description;
        this.montantD = montantD;
        this.montant = montantD;
        this.dernierEncherisseur = null;
        this.dateD = dateD;
        this.dateF = dateF;
    }

    // Getters

    @Override
    public IBien getBien() {
        return this;
    }

    public double getMontantD() {
        return montantD;
    }

    public double getMontant() {
        return montant;
    }

    public IUtilisateur getDernierEncherisseur() {
        return dernierEncherisseur;
    }

    public Date getDateD() {
        return dateD.getTime();
    }

    public Date getDateF() {
        return dateF.getTime();
    }

    // Setters

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setDernierEncherisseur(IUtilisateur dernierEncherisseur) {
        this.dernierEncherisseur = dernierEncherisseur;
    }

    // Methods

    public void encherir(double montant, IUtilisateur encherisseur) throws EncherirNotPossibleException {
        new Encherir(this, montant, encherisseur);
    }

    public double consulterFraisGestion() {
        return AFraisGestion.fraisGestionActuel().calculFraisGestion(this);
    }
}
