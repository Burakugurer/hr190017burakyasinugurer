package com.hr190017.burak_yasin_ugurer_final.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilmModel {




        @SerializedName("FilmAdi")
        @Expose
        private String filmAdi;
        @SerializedName("FilmYonetmeni")
        @Expose
        private String filmYonetmeni;
        @SerializedName("FilmOyunculari")
        @Expose
        private String filmOyunculari;
        @SerializedName("FilmCikisTarihi")
        @Expose
        private String filmCikisTarihi;
        @SerializedName("FilmKonusu")
        @Expose
        private String filmKonusu;
        @SerializedName("FilmKapakFotoUrl")
        @Expose
        private String filmKapakFotoUrl;
        @SerializedName("Filmicon")
        @Expose
        private String filmicon;

        public String getFilmAdi() {
            return filmAdi;
        }

        public void setFilmAdi(String filmAdi) {
            this.filmAdi = filmAdi;
        }

        public String getFilmYonetmeni() {
            return filmYonetmeni;
        }

        public void setFilmYonetmeni(String filmYonetmeni) {
            this.filmYonetmeni = filmYonetmeni;
        }

        public String getFilmOyunculari() {
            return filmOyunculari;
        }

        public void setFilmOyunculari(String filmOyunculari) {
            this.filmOyunculari = filmOyunculari;
        }

        public String getFilmCikisTarihi() {
            return filmCikisTarihi;
        }

        public void setFilmCikisTarihi(String filmCikisTarihi) {
            this.filmCikisTarihi = filmCikisTarihi;
        }

        public String getFilmKonusu() {
            return filmKonusu;
        }

        public void setFilmKonusu(String filmKonusu) {
            this.filmKonusu = filmKonusu;
        }

        public String getFilmKapakFotoUrl() {
            return filmKapakFotoUrl;
        }

        public void setFilmKapakFotoUrl(String filmKapakFotoUrl) {
            this.filmKapakFotoUrl = filmKapakFotoUrl;
        }

        public String getFilmicon() {
            return filmicon;
        }

        public void setFilmicon(String filmicon) {
            this.filmicon = filmicon;
        }

    }



