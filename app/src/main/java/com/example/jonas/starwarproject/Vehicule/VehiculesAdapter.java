package com.example.jonas.starwarproject.Vehicule;


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
public class VehiculesAdapter extends ArrayAdapter<Vehicule> {



    VehiculesAdapter(@NonNull final Context context, final List<Vehicule> vehicules ) {
        super(context, R.layout.vehicules_list_item, vehicules);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        View holder = convertView;
        if (convertView == null) {
            final LayoutInflater vi = LayoutInflater.from(getContext());
            holder = vi.inflate(R.layout.vehicules_list_item, null);
        }

        final Vehicule vehicule = getItem(position);
        if (vehicule == null) {
            return holder;
        }

        // display the title
        final TextView vehiculeName = holder.findViewById(R.id.vehiculesName);
        if (vehiculeName != null) {
            vehiculeName.setText(vehicule.getName());
        }
        return holder;
    }
}