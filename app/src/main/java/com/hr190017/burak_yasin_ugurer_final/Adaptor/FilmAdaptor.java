package com.hr190017.burak_yasin_ugurer_final.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190017.burak_yasin_ugurer_final.R;
import com.hr190017.burak_yasin_ugurer_final.Utility.GlideUtil;
import com.hr190017.burak_yasin_ugurer_final.Model.FilmModel;

import java.util.List;

public class FilmAdaptor  extends RecyclerView.Adapter<FilmViewHolder> {


    List<FilmModel> filmler;
    Context context;
    OnItemClickListener listener;


    public interface OnItemClickListener{
        void onClick(int position);
    }


    public FilmAdaptor(List<FilmModel> filmler, Context context,OnItemClickListener listener) {
        this.filmler = filmler;
        this.context = context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_film,parent,false);
        return new FilmViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder viewHolder, int position) {

        viewHolder.txtFilmAdi.setText(filmler.get(position).getFilmAdi());
        viewHolder.txtTarih.setText(filmler.get(position).getFilmCikisTarihi());
        GlideUtil.resmiIndiripGoster(context,filmler.get(position).getFilmicon(),viewHolder.imgFilmLogo);

    }

    @Override
    public int getItemCount() {
        return filmler.size();
    }
}
