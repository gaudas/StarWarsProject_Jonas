package com.example.jonas.starwarproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.jonas.starwarproject.Characters.ListCharactersActivity;
import com.example.jonas.starwarproject.Movies.ListMovieActivity;
import com.example.jonas.starwarproject.Planets.ListPlanetActivity;
import com.example.jonas.starwarproject.Vehicule.ListVehiculeActivity;


/**
 * Created by jonas on 15/01/18.
 */

public class MenuActivity  extends AppCompatActivity {

    private ImageButton toCharactersInformation,toMoviesInformation,toPlanetsInformation,toVehiculeInformation;
    public static final int REQUEST_CODE_MENU = 1234;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        toCharactersInformation = findViewById(R.id.charactersButton);
        toCharactersInformation.setOnClickListener(toCharactersInformationClick);
        toMoviesInformation = findViewById(R.id.movieListButton);
        toMoviesInformation.setOnClickListener(toMoviesInformationClick);
        toPlanetsInformation = findViewById(R.id.planetsListButton);
        toPlanetsInformation.setOnClickListener(toPlanetsInformationClick);
        toVehiculeInformation = findViewById(R.id.vehiculesListButton);
        toVehiculeInformation.setOnClickListener(toVehiculesInformationClick);
    }

    /**
     * Triggered when an activity return to this activity and has been started with 'forResult'
     */
    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ListCharactersActivity.REQUEST_CODE_LIST && resultCode == RESULT_OK) {}
    }

    View.OnClickListener toCharactersInformationClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Intent i = ListCharactersActivity.getStartIntent(MenuActivity.this);
            startActivityForResult(i, ListCharactersActivity.REQUEST_CODE_LIST);
            // start devices activity and wait for result
        }
    };

    View.OnClickListener toMoviesInformationClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Intent i = ListMovieActivity.getStartIntent(MenuActivity.this);
            startActivityForResult(i, ListMovieActivity.REQUEST_CODE_LIST_MOVIE);
        }
    };

    View.OnClickListener toPlanetsInformationClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Intent i = ListPlanetActivity.getStartIntent(MenuActivity.this);
            startActivityForResult(i, ListPlanetActivity.REQUEST_CODE_LIST_PLANET);
        }
    };

    View.OnClickListener toVehiculesInformationClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Intent i = ListVehiculeActivity.getStartIntent(MenuActivity.this);
            startActivityForResult(i, ListVehiculeActivity.REQUEST_CODE_LIST_VEHICULES);
        }
    };


    public static Intent getStartIntent(final Context context) {
        return new Intent(context, MenuActivity.class);
    }
}
