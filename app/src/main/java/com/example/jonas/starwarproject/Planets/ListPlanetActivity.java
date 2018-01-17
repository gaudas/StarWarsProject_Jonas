package com.example.jonas.starwarproject.Planets;

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

public class ListPlanetActivity extends AppCompatActivity {

    private ListView planetListView;
    private List<Planet> planetList = new ArrayList<>();
    private PlanetsAdapter planetsAdapter;
    private ProgressBar progressBar;
    public static final int REQUEST_CODE_LIST_PLANET = 1235;
    private final ApiService apiService = ApiService.Builder.getInstance();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);

        progressBar = findViewById(R.id.loader);
        progressBar.setVisibility(View.VISIBLE);
        planetListView = findViewById(R.id.planetList);

        apiService.readPlanets().enqueue(new Callback<Planets>() {
            @Override
            public void onResponse(final Call<Planets> call, final Response<Planets> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        handleResponse(response);
                    }
                });
            }

            @Override
            public void onFailure(final Call<Planets> call, final Throwable t) {t.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
    }

    public static Intent getStartIntent(final Context context) {
        return new Intent(context, ListPlanetActivity.class);
    }

    /**
     * Handle default response for both GET/POST methods
     */
    private void handleResponse(final Response<Planets> response) {
        if (response.isSuccessful()) {
            setResultsQuery(response.body());
        } else { // error HTTP
            Toast.makeText(ListPlanetActivity.this,"unknown_error", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Set the led drawable depending on status
     */
    private void setResultsQuery(final Planets newPlanets) {
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.GONE);
        for (int i = 0; i< newPlanets.getResults().size(); i++){
            planetList.add(newPlanets.getResults().get(i));
        }
        planetsAdapter = new PlanetsAdapter(this, planetList);
        planetListView.setAdapter(planetsAdapter);
        planetListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Planet planet = (Planet) parent.getItemAtPosition(position);
                final Intent intent = PlanetDetailActivity.getStartIntent(ListPlanetActivity.this);
                intent.putExtra("thePlanet", planet);
                startActivityForResult(intent, PlanetDetailActivity.REQUEST_CODE_PLANET_DETAIL);
            }
        });
    }




}

