package com.example.jonas.starwarproject.Movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jonas.starwarproject.R;

/**
 * Created by jonas on 16/01/18.
 */


public class MovieDetailActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MOVIE_DETAIL = 1237;
    private TextView titleMovie,episodeNumber,directorName,producerName,dateOfRelease,resume;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Movie movie = (Movie)getIntent().getSerializableExtra("theMovie");

        titleMovie = findViewById(R.id.titleMovie);
        episodeNumber = findViewById(R.id.episodeNumber);
        directorName = findViewById(R.id.directorName);
        producerName = findViewById(R.id.producerName);
        resume = findViewById(R.id.resume);

        titleMovie.setText(movie.getTitle());
        episodeNumber.setText(movie.getEpisode());
        directorName.setText(movie.getDirector());
        producerName.setText(movie.getProducer());
        resume.setText(movie.getOpening_crawl());

    }


    public static Intent getStartIntent(final Context context) {
        return new Intent(context, MovieDetailActivity.class);
    }


}

