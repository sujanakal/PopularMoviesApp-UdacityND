package com.example.android.popularmoviez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        getWindow().setStatusBarColor(getResources().getColor(R.color.statusBar));

        Intent getIn = getIntent();
        Movie getMovie = getIn.getParcelableExtra("Movie");


        if(getMovie != null)
        {
            TextView movieTitle = (TextView) findViewById(R.id.detail_title);
            movieTitle.setText(getMovie.getTitle());

            TextView movieCount = (TextView) findViewById(R.id.detail_count);
            movieCount.setText("Vote count: " + String.valueOf(getMovie.getVote_count()));

            TextView moviePopularity = (TextView) findViewById(R.id.detail_popularity);
            moviePopularity.setText(String.valueOf(getMovie.getPopularity()));

            TextView movieReleaseDate = (TextView) findViewById(R.id.detail_release_date);
            movieReleaseDate.setText(getMovie.getRelease_date());

            TextView movieRating = (TextView) findViewById(R.id.detail_rating);
            movieRating.setText("Vote average: " + String.valueOf(getMovie.getVote_average()));

            TextView movieOverview = (TextView) findViewById(R.id.detail_overview);
            movieOverview.setText(getMovie.getOverview());

            ImageView moviePoster = (ImageView) findViewById(R.id.detail_poster);

            String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185/";

            Picasso
                    .with(this)
                    .load(IMAGE_BASE_URL+getMovie.getPoster_path())
                    .into(moviePoster);

        }
    }
}
