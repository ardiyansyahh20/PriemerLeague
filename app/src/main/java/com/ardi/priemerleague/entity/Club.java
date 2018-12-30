package com.ardi.priemerleague.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Club implements Parcelable {
    private String idTeam = "id";
    private String namaTeam = "namaTeam";
    private String tahunTeam = "tahunTeam";
    private String managerTeam = "managerTeam";
    private String stadionTeam = "stadionTeam";
    private String logoTeam = "logoTeam";
    private String deskripsiTeam = "deskripsiTeam";
    private String negaraTeam = "negaraTeam";
    private String bannerTeam = "bannerTeam";
    private String ligaTeam = "ligaTeam";
    private String websiteTeam = "websiteTeam";
    private String gambarStadion = "imageStadion";
    private String lokasiStadion = "alamatStadion";
    private String jerseyClub = "jersey";
    private String kapasitas = "kapasitas";


    public Club(JSONObject object) {
        try {
            String id = object.getString("idTeam");
            String nama_team = object.getString("strTeam");
            String tahun = object.getString("intFormedYear");
            String manager = object.getString("strManager");
            String stadion = object.getString("strStadium");
            String logo = object.getString("strTeamBadge");
            String deskripsi = object.getString("strDescriptionEN");
            String negara = object.getString("strCountry");
            String banner = object.getString("strTeamFanart1");
            String liga = object.getString("strLeague");
            String website = object.getString("strWebsite");
            String gambarStadion = object.getString("strStadiumThumb");
            String lokasiStadion = object.getString("strStadiumLocation");
            String jerseyClub = object.getString("strTeamJersey");
            String kapasitas = object.getString("intStadiumCapacity");

            this.idTeam = id;
            this.namaTeam = nama_team;
            this.tahunTeam = tahun;
            this.managerTeam = manager;
            this.stadionTeam = stadion;
            this.logoTeam = logo;
            this.deskripsiTeam = deskripsi;
            this.negaraTeam = negara;
            this.bannerTeam = banner;
            this.ligaTeam = liga;
            this.websiteTeam = website;
            this.gambarStadion = gambarStadion;
            this.lokasiStadion = lokasiStadion;
            this.jerseyClub = jerseyClub;
            this.kapasitas = kapasitas;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(String kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getJerseyClub() {
        return jerseyClub;
    }

    public void setJerseyClub(String jerseyClub) {
        this.jerseyClub = jerseyClub;
    }

    public String getLokasiStadion() {
        return lokasiStadion;
    }

    public void setLokasiStadion(String lokasiStadion) {
        this.lokasiStadion = lokasiStadion;
    }

    public String getGambarStadion() {
        return gambarStadion;
    }

    public void setGambarStadion(String gambarStadion) {
        this.gambarStadion = gambarStadion;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getNamaTeam() {
        return namaTeam;
    }

    public void setNamaTeam(String namaTeam) {
        this.namaTeam = namaTeam;
    }

    public String getTahunTeam() {
        return tahunTeam;
    }

    public void setTahunTeam(String tahunTeam) {
        this.tahunTeam = tahunTeam;
    }

    public String getManagerTeam() {
        return managerTeam;
    }

    public void setManagerTeam(String managerTeam) {
        this.managerTeam = managerTeam;
    }

    public String getStadionTeam() {
        return stadionTeam;
    }

    public void setStadionTeam(String stadionTeam) {
        this.stadionTeam = stadionTeam;
    }

    public String getLogoTeam() {
        return logoTeam;
    }

    public void setLogoTeam(String logoTeam) {
        this.logoTeam = logoTeam;
    }

    public String getDeskripsiTeam() {
        return deskripsiTeam;
    }

    public void setDeskripsiTeam(String deskripsiTeam) {
        this.deskripsiTeam = deskripsiTeam;
    }

    public String getNegaraTeam() {
        return negaraTeam;
    }

    public void setNegaraTeam(String negaraTeam) {
        this.negaraTeam = negaraTeam;
    }

    public String getBannerTeam() {
        return bannerTeam;
    }

    public void setBannerTeam(String bannerTeam) {
        this.bannerTeam = bannerTeam;
    }

    public String getLigaTeam() {
        return ligaTeam;
    }

    public void setLigaTeam(String ligaTeam) {
        this.ligaTeam = ligaTeam;
    }

    public String getWebsiteTeam() {
        return websiteTeam;
    }

    public void setWebsiteTeam(String websiteTeam) {
        this.websiteTeam = websiteTeam;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.idTeam);
        dest.writeString(this.namaTeam);
        dest.writeString(this.tahunTeam);
        dest.writeString(this.managerTeam);
        dest.writeString(this.stadionTeam);
        dest.writeString(this.logoTeam);
        dest.writeString(this.deskripsiTeam);
        dest.writeString(this.negaraTeam);
        dest.writeString(this.bannerTeam);
        dest.writeString(this.ligaTeam);
        dest.writeString(this.websiteTeam);
        dest.writeString(this.gambarStadion);
        dest.writeString(this.lokasiStadion);
        dest.writeString(this.jerseyClub);
        dest.writeString(this.kapasitas);
    }

    protected Club(Parcel in) {
        this.idTeam = in.readString();
        this.namaTeam = in.readString();
        this.tahunTeam = in.readString();
        this.managerTeam = in.readString();
        this.stadionTeam = in.readString();
        this.logoTeam = in.readString();
        this.deskripsiTeam = in.readString();
        this.negaraTeam = in.readString();
        this.bannerTeam = in.readString();
        this.ligaTeam = in.readString();
        this.websiteTeam = in.readString();
        this.gambarStadion = in.readString();
        this.lokasiStadion = in.readString();
        this.jerseyClub = in.readString();
        this.kapasitas = in.readString();
    }

    public static final Creator<Club> CREATOR = new Creator<Club>() {
        @Override
        public Club createFromParcel(Parcel source) {
            return new Club(source);
        }

        @Override
        public Club[] newArray(int size) {
            return new Club[size];
        }
    };
}
