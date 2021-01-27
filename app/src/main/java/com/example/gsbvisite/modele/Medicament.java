package com.example.gsbvisite.modele;

public class Medicament {


    //region Attributs privés
    private String MDepotLegal;
    private String MNomCommercial;
    private String MComposition;
    private Double MPrixEchant;
    private String effet;
    private String contreindic;
    //endregion

    //region Constructeur
    public Medicament(String MDepotLegal, String MNomCommercial, String MComposition, String effet, String contreindic, Double MPrixEchant) {
        this.MDepotLegal = MDepotLegal;
        this.MNomCommercial = MNomCommercial;
        this.MComposition = MComposition;
        this.effet = effet;
        this.contreindic = contreindic;
        this.MPrixEchant = MPrixEchant;
    }


    //endregion

    //region Accesseur en Lecture (Getter)
    public String getMDepotLegal() {
        return MDepotLegal;
    }

    public String getMNomCommercial() {
        return MNomCommercial;
    }

    public String getMComposition() {
        return MComposition;
    }

    public Double getMPrixEchant() {
        return MPrixEchant;
    }

    public String getEffet() {
        return effet;
    }

    public String getContreindic() {
        return contreindic;
    }
    //endregion

    //region Accesseur en Ecriture (Setter)
    public void setMDepotLegal(String MDepotLegal) {
        this.MDepotLegal = MDepotLegal;
    }

    public void setMNomCommercial(String MNomCommercial) {
        this.MNomCommercial = MNomCommercial;
    }

    public void setMComposition(String MComposition) {
        this.MComposition = MComposition;
    }

    public void setMPrixEchant(Double MPrixEchant) {
        this.MPrixEchant = MPrixEchant;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public void setContreindic(String contreindic) {
        this.contreindic = contreindic;
    }

    //endregion

}
