package com.example.jonas.starwarproject.Planets;


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
public class PlanetsAdapter extends ArrayAdapter<Planet> {



    PlanetsAdapter(@NonNull final Context context, final List<Planet> planets) {
        super(context, R.layout.planets_list_item, planets);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        View holder = convertView;
        if (convertView == null) {
            final LayoutInflater vi = LayoutInflater.from(getContext());
            holder = vi.inflate(R.layout.planets_list_item, null);
        }

        final Planet planet = getItem(position);
        if (planet == null) {
            return holder;
        }

        // display the title
        final TextView planetName = holder.findViewById(R.id.planetName);
        if (planetName != null) {
            planetName.setText(planet.getName());
        }
        return holder;
    }
}