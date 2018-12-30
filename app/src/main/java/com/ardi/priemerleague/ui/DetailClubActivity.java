package com.ardi.priemerleague.ui;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ardi.priemerleague.R;
import com.ardi.priemerleague.entity.Club;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailClubActivity extends AppCompatActivity {

    @BindView(R.id.detail_nama_club)
    TextView tvNamaClub;
    @BindView(R.id.detail_liga_club)
    TextView tvLigaClub;
    @BindView(R.id.detail_manajer)
    TextView tvManajerClub;
    @BindView(R.id.detail_negara_club)
    TextView tvNegaraClub;
    @BindView(R.id.nama_stadion)
    TextView tvStadion;
    @BindView(R.id.detail_tahun_club)
    TextView tvTahunClub;
    @BindView(R.id.detail_website_club)
    TextView tvWebsiteClub;
    @BindView(R.id.gambar_club)
    ImageView gambarClub;
    @BindView(R.id.banner_club)
    ImageView bannerClub;
    @BindView(R.id.gambar_stadion)
    ImageView gambarStadion;
    @BindView(R.id.jersey_club)
    ImageView jerseyClub;
    @BindView(R.id.tv_deskripsi_club)
    TextView tvDeskripsiClub;
    @BindView(R.id.lokasi_stadion)
    TextView tvLokasiStadion;
    @BindView(R.id.kapasitas_stadion)
    TextView tvKapasitasStadion;
    @BindView(R.id.detail_jersey)
    TextView tvJerseyClub;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collaps;


    private Club club;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_club);
        ButterKnife.bind(this);
        club = getIntent().getParcelableExtra("club");

        collaps.setTitle(club.getNamaTeam());
        tvNamaClub.setText(club.getNamaTeam());
        tvLigaClub.setText(club.getLigaTeam());
        tvManajerClub.setText(getString(R.string.manager, club.getManagerTeam()));
        tvNegaraClub.setText(getString(R.string.negara, club.getNegaraTeam()));
        tvStadion.setText(getString(R.string.stadion, club.getStadionTeam()));
        tvTahunClub.setText(getString(R.string.tahun_club, club.getTahunTeam()));
        tvWebsiteClub.setText(club.getWebsiteTeam());
        tvLokasiStadion.setText(club.getLokasiStadion());
        tvKapasitasStadion.setText(getString(R.string.kapasitas, club.getKapasitas()));
        tvDeskripsiClub.setText(club.getDeskripsiTeam());
//        tvJerseyClub.setText(club.getJerseyClub());
        Picasso.get()
                .load(club.getLogoTeam())
                .into(gambarClub);
        Picasso.get()
                .load(club.getBannerTeam())
                .into(bannerClub);
        Picasso.get()
                .load(club.getGambarStadion())
                .into(gambarStadion);
        Picasso.get()
                .load(club.getJerseyClub())
                .into(jerseyClub);

        tvWebsiteClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = club.getWebsiteTeam();
                if (url.indexOf("http://") < 0) {
                    url = "http://" + url;
                }
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bahasa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            if (item.getItemId() == R.id.action_settings) {
                Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }


}
