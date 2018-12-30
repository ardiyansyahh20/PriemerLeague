package com.ardi.priemerleague.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ardi.priemerleague.R;
import com.ardi.priemerleague.entity.Club;
import com.ardi.priemerleague.listener.OnItemClickListener;
import com.ardi.priemerleague.ui.DetailClubActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {

    ArrayList<Club> listClub;
    Context context;

    public ClubAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Club> getListClub() {
        return listClub;
    }

    public void setListClub(ArrayList<Club> listClub) {
        this.listClub = listClub;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_club, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Club club = listClub.get(position);
        holder.tvNamaClub.setText(getListClub().get(position).getNamaTeam());
        holder.tvLigaClub.setText(getListClub().get(position).getLigaTeam());
        holder.tvManager.setText(getListClub().get(position).getManagerTeam());
        holder.tvWebsite.setText(getListClub().get(position).getWebsiteTeam());
        Picasso.get()
                .load(getListClub().get(position).getLogoTeam())
                .into(holder.logoClub);

        holder.btnShare.setOnClickListener(new OnItemClickListener(position, new OnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, club.getNamaTeam() + " \n" + club.getWebsiteTeam());
                intent.setType("text/plain");
                context.startActivity(intent);
            }
        }));

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Club club1 = listClub.get(position);
                Intent intent = new Intent(context, DetailClubActivity.class);
                intent.putExtra("club", club1);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListClub().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_nama_club)
        TextView tvNamaClub;
        @BindView(R.id.tv_liga_club)
        TextView tvLigaClub;
        @BindView(R.id.tv_manager)
        TextView tvManager;
        @BindView(R.id.tv_website)
        TextView tvWebsite;
        @BindView(R.id.img_item_poster)
        ImageView logoClub;
        @BindView(R.id.btn_set_detail)
        Button btnDetail;
        @BindView(R.id.btn_set_share)
        Button btnShare;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
