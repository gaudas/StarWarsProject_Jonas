package com.example.jonas.starwarproject.Movies;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jonas.starwarproject.R;

import java.util.List;

/**
 * Device adapter
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {



    MoviesAdapter(@NonNull final Context context, final List<Movie> movies) {
        super(context, R.layout.movies_list_item, movies);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        View holder = convertView;
        if (convertView == null) {
            final LayoutInflater vi = LayoutInflater.from(getContext());
            holder = vi.inflate(R.layout.movies_list_item, null);
        }

        final Movie movie = getItem(position);
        if (movie == null) {
            return holder;
        }

        // display the title
        final TextView movieName = holder.findViewById(R.id.movieName);
        if (movieName != null) {
            movieName.setText(movie.getTitle());
        }
        return holder;
    }
}