package com.ardi.priemerleague.view;

import com.ardi.priemerleague.entity.Club;
import com.ardi.priemerleague.entity.Liga;

import java.util.ArrayList;

public interface MainView {
    void showData(ArrayList<Club> clubs);
    void showLiga(ArrayList<Liga> liga);
}
