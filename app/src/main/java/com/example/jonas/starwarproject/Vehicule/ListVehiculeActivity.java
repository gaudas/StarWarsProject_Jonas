package com.example.jonas.starwarproject.Vehicule;

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

public class ListVehiculeActivity extends AppCompatActivity {

    private ListView vehiculeListView;
    private List<Vehicule> vehiculeList = new ArrayList<>();
    private VehiculesAdapter vehiculesAdapter;
    private ProgressBar progressBar;
    public static final int REQUEST_CODE_LIST_VEHICULES = 1235;
    private final ApiService apiService = ApiService.Builder.getInstance();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicules);
        vehiculeListView = findViewById(R.id.vehiculesList);
        progressBar = findViewById(R.id.loaderVehicles);
        progressBar.setVisibility(View.VISIBLE);
        apiService.readVehicles().enqueue(new Callback<Vehicules>() {
            @Override
            public void onResponse(final Call<Vehicules> call, final Response<Vehicules> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        handleResponse(response);
                    }
                });
            }

            @Override
            public void onFailure(final Call<Vehicules> call, final Throwable t) {t.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
    }

    public static Intent getStartIntent(final Context context) {
        return new Intent(context, ListVehiculeActivity.class);
    }

    /**
     * Handle default response for both GET/POST methods
     */
    private void handleResponse(final Response<Vehicules> response) {
        if (response.isSuccessful()) {
            setResultsQuery(response.body());
        } else { // error HTTP
            Toast.makeText(ListVehiculeActivity.this,"unknown_error", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Set the led drawable depending on status
     */
    private void setResultsQuery(final Vehicules newvehicules) {
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.GONE);
        for (int i = 0; i< newvehicules.getResults().size(); i++){
            vehiculeList.add(newvehicules.getResults().get(i));
        }
        vehiculesAdapter = new VehiculesAdapter(this, vehiculeList);
        vehiculeListView.setAdapter(vehiculesAdapter);
        vehiculeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Vehicule vehicule = (Vehicule) parent.getItemAtPosition(position);
                final Intent intent = VehiculeDetailActivity.getStartIntent(ListVehiculeActivity.this);
                intent.putExtra("thevehicule", vehicule);
                startActivityForResult(intent, VehiculeDetailActivity.REQUEST_CODE_VEHICULE_DETAIL);
            }
        });
    }




}

