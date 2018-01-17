package com.example.jonas.starwarproject.Movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jonas.starwarproject.R;
import com.example.jonas.starwarproject.remote.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jonas on 15/01/18.
 */

public class ListMovieActivity extends AppCompatActivity {

    private ListView movieListView;
    private List<Movie> movieList = new ArrayList<>();
    private MoviesAdapter moviesAdapter;
    private ProgressBar progressBar;
    public static final int REQUEST_CODE_LIST_MOVIE = 1235;
    private final ApiService apiService = ApiService.Builder.getInstance();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        movieListView = findViewById(R.id.movieList);
        progressBar = findViewById(R.id.loader);
        progressBar.setVisibility(View.VISIBLE);

        apiService.readMovies().enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(final Call<Movies> call, final Response<Movies> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        handleResponse(response);
                    }
                });
            }

            @Override
            public void onFailure(final Call<Movies> call, final Throwable t) {t.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
    }

    public static Intent getStartIntent(final Context context) {
        return new Intent(context, ListMovieActivity.class);
    }

    /**
     * Handle default response for both GET/POST methods
     */
    private void handleResponse(final Response<Movies> response) {
        if (response.isSuccessful()) {
            setResultsQuery(response.body());
        } else { // error HTTP
            Toast.makeText(ListMovieActivity.this,"unknown_error", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Set the led drawable depending on status
     */
    private void setResultsQuery(final Movies newMovies) {
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.GONE);
        for (int i =0; i<newMovies.getResults().size();i++){
            movieList.add(newMovies.getResults().get(i));
        }
        moviesAdapter = new MoviesAdapter(this, movieList);
        movieListView.setAdapter(moviesAdapter);
        movieListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = (Movie) parent.getItemAtPosition(position);
                final Intent intent = MovieDetailActivity.getStartIntent(ListMovieActivity.this);
                intent.putExtra("theMovie", movie);
                startActivityForResult(intent, MovieDetailActivity.REQUEST_CODE_MOVIE_DETAIL);
            }
        });
    }

}

