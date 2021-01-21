package com.hr190017.burak_yasin_ugurer_final.Adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190017.burak_yasin_ugurer_final.R;

import org.w3c.dom.Text;

public class FilmViewHolder  extends RecyclerView.ViewHolder {

    ImageView imgFilmLogo;
    TextView txtFilmAdi;
    TextView txtTarih;

    public FilmViewHolder(@NonNull View itemView,  FilmAdaptor.OnItemClickListener listener) {
        super(itemView);

        imgFilmLogo =itemView.findViewById(R.id.imgFilmLogo);
        txtFilmAdi =itemView.findViewById(R.id.txtFilmAdi);
        txtTarih =itemView.findViewById(R.id.txtTarih);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               listener.onClick(getAdapterPosition());
            }
        });
    }
}

