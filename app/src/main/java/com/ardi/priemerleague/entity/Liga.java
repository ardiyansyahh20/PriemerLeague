package com.ardi.priemerleague.entity;

import org.json.JSONException;
import org.json.JSONObject;

public class Liga {
    String mIdLiga;
    String mNamaLiga;
    String mJenis;
    String mAlt;

    public String getmIdLiga() {
        return mIdLiga;
    }

    public void setmIdLiga(String mIdLiga) {
        this.mIdLiga = mIdLiga;
    }

    public String getmNamaLiga() {
        return mNamaLiga;
    }

    public void setmNamaLiga(String mNamaLiga) {
        this.mNamaLiga = mNamaLiga;
    }

    public String getmJenis() {
        return mJenis;
    }

    public void setmJenis(String mJenis) {
        this.mJenis = mJenis;
    }

    public String getmAlt() {
        return mAlt;
    }

    public void setmAlt(String mAlt) {
        this.mAlt = mAlt;
    }

    public Liga(JSONObject object) {
        try {
            String id = object.getString("idLeague");
            String nama = object.getString("strLeague");
            String jenis = object.getString("strSport");
            String alt = object.getString("strLeagueAlternate");

            this.mIdLiga = id;
            this.mNamaLiga = nama;
            this.mJenis = jenis;
            this.mAlt = alt;
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public Liga(){}
}
