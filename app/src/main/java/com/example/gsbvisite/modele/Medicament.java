package com.example.gsbvisite.modele;

import android.os.Parcel;
import android.os.Parcelable;

public class Medicament implements Parcelable {

    //region Attributs privés
    private String MDepotLegal;
    private String MNomCommercial;
    private String MComposition;
    private Double MPrixEchant;
    private String Meffet;
    private String contreindic;
    //endregion

    //region Constructeur

    public Medicament(String MDepotLegal, String MNomCommercial, String MComposition, String meffet, String contreindic, Double MPrixEchant) {
        this.MDepotLegal = MDepotLegal;
        this.MNomCommercial = MNomCommercial;
        this.MComposition = MComposition;
        this.Meffet = meffet;
        this.contreindic = contreindic;
        this.MPrixEchant = MPrixEchant;
    }

    public Medicament(Parcel in) {
        this.MDepotLegal = in.readString();
        this.MNomCommercial = in.readString();
        this.MComposition = in.readString();
        this.Meffet = in.readString();
        this.contreindic = in.readString();
        this.MPrixEchant = in.readDouble();
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
        return Meffet;
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
        this.Meffet = effet;
    }

    public void setContreindic(String contreindic) {
        this.contreindic = contreindic;
    }


    public static final Parcelable.Creator<Medicament> CREATOR = new Parcelable.Creator<Medicament>() {
        public Medicament createFromParcel(Parcel in) {
            return new Medicament(in);
        }

        public Medicament[] newArray(int size) {
            return new Medicament[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getMDepotLegal());
        dest.writeString(getMNomCommercial());
        dest.writeString(getMComposition());
        dest.writeString(getEffet());
        dest.writeString(getContreindic());
        dest.writeDouble(getMPrixEchant());
    }

    //endregion

}
