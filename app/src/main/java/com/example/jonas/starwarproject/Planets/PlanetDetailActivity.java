package com.example.jonas.starwarproject.Planets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jonas.starwarproject.R;

/**
 * Created by jonas on 16/01/18.
 */


public class PlanetDetailActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_PLANET_DETAIL = 1238;
    private TextView name,rotation,orbital,diameter,climate,gravity,terrain,surfaceWater,population;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_details);
        Planet planet = (Planet)getIntent().getSerializableExtra("thePlanet");

        name = findViewById(R.id.planetNameTitle);
        rotation = findViewById(R.id.valueRotationPeriod);
        orbital = findViewById(R.id.valueOrbitalPeriod);
        diameter = findViewById(R.id.diameter);
        climate = findViewById(R.id.climate);
        gravity = findViewById(R.id.gravity);
        terrain = findViewById(R.id.terrain);
        surfaceWater = findViewById(R.id.surface_water);
        population = findViewById(R.id.population);

        name.setText(planet.getName());
        rotation.setText(planet.getRotation_period());
        orbital.setText(planet.getOrbital_period());
        diameter.setText(planet.getDiameter());
        climate.setText(planet.getClimate());
        gravity.setText(planet.getGravity());
        terrain.setText(planet.getTerrain());
        surfaceWater.setText(planet.getSurface_water());
        population.setText(planet.getPopulation());


    }


    public static Intent getStartIntent(final Context context) {
        return new Intent(context, PlanetDetailActivity.class);
    }


}

