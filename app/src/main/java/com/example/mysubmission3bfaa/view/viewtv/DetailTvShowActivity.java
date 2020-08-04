package com.example.mysubmission3bfaa.view.viewtv;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mysubmission3bfaa.R;
import com.example.mysubmission3bfaa.model.tvmodel.ResultsItemTv;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_TV = "extra_tv";
    ResultsItemTv listTvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView tvTitle, tvRelease, tvScore, tvVoteCount, tvStatus, tvId, tvLanguage, tvOverview;
        ImageView tvPoster;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.title_tv);
        }

        tvTitle = findViewById(R.id.title_tv);
        tvRelease = findViewById(R.id.text_release_tv);
        tvScore = findViewById(R.id.text_score_tv);
        tvId = findViewById(R.id.text_id_tv);
        tvVoteCount = findViewById(R.id.text_vote_tv);
        tvLanguage = findViewById(R.id.text_ori_text_tv);
        tvOverview = findViewById(R.id.text_overview_tv);
        tvPoster = findViewById(R.id.poster_tv);

        listTvShow = getIntent().getParcelableExtra(EXTRA_TV);

        tvTitle.setText(listTvShow.getOriginal_name());
        tvRelease.setText(listTvShow.getFirst_air_date());
        tvScore.setText(listTvShow.getVote_average().toString());
        tvId.setText(String.valueOf(listTvShow.getId()));
        tvVoteCount.setText(String.valueOf(listTvShow.getVote_count()));
        tvLanguage.setText(listTvShow.getOriginal_language());
        tvOverview.setText(listTvShow.getOverview());
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w154" + listTvShow.getPoster_path())
                .apply(new RequestOptions().override(350, 550))
                .into(tvPoster);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        return true;
    }
}
