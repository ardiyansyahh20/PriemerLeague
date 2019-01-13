package com.ardi.priemerleague.Presenter;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ardi.priemerleague.Api.ApiRepository;
import com.ardi.priemerleague.entity.Club;
import com.ardi.priemerleague.entity.Liga;
import com.ardi.priemerleague.view.MainView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Presenter {
    MainView view;
    StringRequest stringRequest;
    ApiRepository apiRepository;
    Context context;


    public MainView getView() {
        return view;
    }

    public void setView(MainView view) {
        this.view = view;
    }

    public StringRequest getStringRequest() {
        return stringRequest;
    }

    public void setStringRequest(StringRequest stringRequest) {
        this.stringRequest = stringRequest;
    }

    public ApiRepository getApiRepository() {
        return apiRepository;
    }

    public void setApiRepository(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Presenter(Context context, MainView view, ApiRepository apiRepository) {
        this.view = view;
        this.apiRepository = apiRepository;
        this.context = context;
    }

    public void LoadData(String s) {
        String url = apiRepository.getLiga(s);
        final ArrayList<Club> listClub = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("teams");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        Club club = new Club(object);
                        listClub.add(club);
                    }
                    view.showData(listClub);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public void LoadIdLiga() {
        String url = apiRepository.getLigaId();
        final ArrayList<Liga> listLiga = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("leagues");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        Liga liga = new Liga(object);
                        listLiga.add(liga);
                    }
                    view.showLiga(listLiga);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
