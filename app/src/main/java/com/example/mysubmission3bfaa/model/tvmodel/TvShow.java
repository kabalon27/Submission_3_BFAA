package com.example.mysubmission3bfaa.model.tvmodel;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private int id, vote_count;
    private String original_name, overview, first_air_date, poster_path, original_language;
    private Number vote_average;

    protected TvShow(Parcel in) {
        id = in.readInt();
        vote_count = in.readInt();
        original_name = in.readString();
        overview = in.readString();
        first_air_date = in.readString();
        poster_path = in.readString();
        original_language = in.readString();
        vote_average = (Number) in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(vote_count);
        dest.writeString(original_name);
        dest.writeString(overview);
        dest.writeString(first_air_date);
        dest.writeString(poster_path);
        dest.writeString(original_language);
        dest.writeSerializable(vote_average);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public Number getVote_average() {
        return vote_average;
    }

    public void setVote_average(Number vote_average) {
        this.vote_average = vote_average;
    }
}
