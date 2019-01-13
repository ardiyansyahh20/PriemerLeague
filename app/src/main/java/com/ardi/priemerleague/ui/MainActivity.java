package com.ardi.priemerleague.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ardi.priemerleague.Api.ApiRepository;
import com.ardi.priemerleague.Presenter.Presenter;
import com.ardi.priemerleague.R;
import com.ardi.priemerleague.adapter.ClubAdapter;
import com.ardi.priemerleague.entity.Club;
import com.ardi.priemerleague.entity.Liga;
import com.ardi.priemerleague.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.spinner)
    Spinner mSpinner;
    @BindView(R.id.rv_category)
    RecyclerView rvClub;
    Presenter presenter;
    ClubAdapter adapter;
    ApiRepository apiRepository;
    ArrayList<Liga> IdlistLiga;
    String idLiga="4328";

    ArrayList<String> listLiga;
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        adapter = new ClubAdapter(this);
        apiRepository = new ApiRepository();
        listLiga = new ArrayList<>();
        IdlistLiga = new ArrayList<>();



        rvClub.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        presenter = new Presenter(this, this,apiRepository);
        presenter.LoadIdLiga();
        presenter.LoadData(idLiga);
//        String url = "https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php?id=4328";
//        LoadAsync loadAsync = new LoadAsync();
//        loadAsync.execute(url);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idLiga =IdlistLiga.get(position).getmIdLiga();
                presenter.LoadData(idLiga);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void showData(ArrayList<Club> clubs) {
        adapter.setListClub(clubs);
        rvClub.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLiga(ArrayList<Liga> liga) {
        IdlistLiga.addAll(liga);
        String TAG = "TAG";
        Log.d(TAG, "showLiga: "+liga.size());
        for (int i = 0;i<liga.size();i++){

            String namaLiga = liga.get(i).getmNamaLiga();

            listLiga.add(namaLiga);

        }
        listAdapter  = new ArrayAdapter<>(this,R.layout.spinner_item,listLiga);
        listAdapter.setDropDownViewResource(R.layout.spinner_item_drop);
        mSpinner.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_liga,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.england:
                presenter.LoadData("4328");
                break;
            case R.id.spain:
                presenter.LoadData("4335");
                break;
            case R.id.germany:
                presenter.LoadData("4331");
                break;
            case R.id.italy:
                presenter.LoadData("4332");
                break;
            case R.id.france:
                presenter.LoadData("4334");
                break;
        }
        return true;
    }

    //
//    private class LoadAsync extends AsyncTask<String, Void, ArrayList<Club>> {
//        @Override
//        protected ArrayList<Club> doInBackground(String... strings) {
//            String uri = strings[0];
//            final ArrayList<Club> clubss = new ArrayList<>();
//            SyncHttpClient client = new SyncHttpClient();
//
//            client.setSSLSocketFactory(MySSLSocketFactory.getFixedSocketFactory());
//            client.get(uri, new AsyncHttpResponseHandler() {
//                @Override
//                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//
//                    try {
//                        String result = new String(responseBody);
//                        JSONObject jsonClub = new JSONObject(result);
//                        JSONArray jsonArray = jsonClub.getJSONArray("teams");
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            JSONObject obj = jsonArray.getJSONObject(i);
//                            Club club = new Club(obj);
//                            clubss.add(club);
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                @Override
//                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                    Log.d("Tag", "onFailure: " + statusCode);
//                }
//            });
//            return clubss;
//        }
//
//        @Override
//        protected void onPostExecute(ArrayList<Club> clubs) {
//            super.onPostExecute(clubs);
//            rvClub.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//            adapter.setListClub(clubs);
//            rvClub.setAdapter(adapter);
//        }
//    }

}
