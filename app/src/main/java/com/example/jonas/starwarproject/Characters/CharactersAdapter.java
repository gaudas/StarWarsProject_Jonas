package com.example.jonas.starwarproject.Characters;


import com.example.jonas.starwarproject.R;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Device adapter
 */
public class CharactersAdapter extends ArrayAdapter<Character> {



    CharactersAdapter(@NonNull final Context context, final List<Character> characters) {
        super(context, R.layout.characters_list_item, characters);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        View holder = convertView;
        if (convertView == null) {
            final LayoutInflater vi = LayoutInflater.from(getContext());
            holder = vi.inflate(R.layout.characters_list_item, null);
        }

        final Character character = getItem(position);
        if (character == null) {
            return holder;
        }

        // display the name
        final TextView characterName = holder.findViewById(R.id.characterName);
        if (characterName != null) {
            characterName.setText(character.getName());
        }



        return holder;
    }
}