package com.example.mysubmission3bfaa.model.moviemodel;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String title, overview, release_date, poster_path, original_language;
    private Number vote_average;
    private int id, vote_count;

    public Movie(){

    }

    protected Movie(Parcel in) {
        title = in.readString();
        overview = in.readString();
        release_date = in.readString();
        poster_path = in.readString();
        original_language = in.readString();
        id = in.readInt();
        vote_count = in.readInt();
        vote_average = (Number) in.readSerializable();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(overview);
        dest.writeString(release_date);
        dest.writeString(poster_path);
        dest.writeString(original_language);
        dest.writeInt(id);
        dest.writeInt(vote_count);
        dest.writeSerializable(vote_average);
    }
}
