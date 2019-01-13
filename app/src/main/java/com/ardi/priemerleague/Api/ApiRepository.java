package com.ardi.priemerleague.Api;

import com.ardi.priemerleague.BuildConfig;

public class ApiRepository {

    public String getLiga(String liga){
        String ligaUrl = "lookup_all_teams.php?id=";
        String url = BuildConfig.SPORT_URL+ligaUrl+liga;
        return url;
    }
    public String getLigaId(){
        String url = BuildConfig.SPORT_URL+"all_leagues.php";
        return  url;
    }
}
