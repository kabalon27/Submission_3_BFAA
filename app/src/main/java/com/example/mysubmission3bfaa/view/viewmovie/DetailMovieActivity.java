package com.example.mysubmission3bfaa.view.viewmovie;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mysubmission3bfaa.R;
import com.example.mysubmission3bfaa.model.moviemodel.ResultsItemMovie;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    ResultsItemMovie listMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView mvTitle, mvRelease, mvScore, mvId, mvVoteCount, mvLanguage, mvOverview;
        ImageView mvPoster;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.title_movie);
        }

        mvTitle = findViewById(R.id.text_title_mv);
        mvRelease = findViewById(R.id.text_release_mv);
        mvScore = findViewById(R.id.text_score_mv);
        mvId = findViewById(R.id.text_id_mv);
        mvVoteCount = findViewById(R.id.text_vote_mv);
        mvLanguage = findViewById(R.id.text_ori_text_mv);
        mvOverview = findViewById(R.id.text_overview_mv);
        mvPoster = findViewById(R.id.poster_mv);


        listMovie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        mvTitle.setText(listMovie.getTitle());
        mvRelease.setText(listMovie.getRelease_date());
        mvScore.setText(listMovie.getVote_average().toString());
        mvId.setText(String.valueOf(listMovie.getId()));
        mvVoteCount.setText(String.valueOf(listMovie.getVote_count()));
        mvLanguage.setText(listMovie.getOriginal_language());
        mvOverview.setText(listMovie.getOverview());
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w154" + listMovie.getPoster_path())
                .apply(new RequestOptions().override(350, 550))
                .into(mvPoster);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
