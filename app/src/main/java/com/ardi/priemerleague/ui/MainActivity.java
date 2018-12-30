package com.ardi.priemerleague.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ardi.priemerleague.R;
import com.ardi.priemerleague.adapter.ClubAdapter;
import com.ardi.priemerleague.entity.Club;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_category)
    RecyclerView rvClub;

    ClubAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        adapter = new ClubAdapter(this);
        String url = "https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php?id=4328";
        LoadAsync loadAsync = new LoadAsync();
        loadAsync.execute(url);

    }


    private class LoadAsync extends AsyncTask<String, Void, ArrayList<Club>> {
        @Override
        protected ArrayList<Club> doInBackground(String... strings) {
            String uri = strings[0];
            final ArrayList<Club> clubss = new ArrayList<>();
            SyncHttpClient client = new SyncHttpClient();

            client.setSSLSocketFactory(MySSLSocketFactory.getFixedSocketFactory());
            client.get(uri, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                    try {
                        String result = new String(responseBody);
                        JSONObject jsonClub = new JSONObject(result);
                        JSONArray jsonArray = jsonClub.getJSONArray("teams");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject obj = jsonArray.getJSONObject(i);
                            Club club = new Club(obj);
                            clubss.add(club);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    Log.d("Tag", "onFailure: " + statusCode);
                }
            });
            return clubss;
        }

        @Override
        protected void onPostExecute(ArrayList<Club> clubs) {
            super.onPostExecute(clubs);
            rvClub.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            adapter.setListClub(clubs);
            rvClub.setAdapter(adapter);
        }
    }

}
