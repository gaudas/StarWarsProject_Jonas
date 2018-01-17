package com.example.jonas.starwarproject.Vehicule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jonas.starwarproject.R;

/**
 * Created by jonas on 16/01/18.
 */


public class VehiculeDetailActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_VEHICULE_DETAIL = 1238;
    private TextView name,model,manufacturer,cost_in_credits,length,max_atmosphering_speed,crew,passengers,cargo_capacity,consumables,vehicle_class;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule_details);
        Vehicule vehicule = (Vehicule)getIntent().getSerializableExtra("thevehicule");



        name = findViewById(R.id.nameVehicule);
        model= findViewById(R.id.model);
        manufacturer= findViewById(R.id.manufacturer);
        cost_in_credits= findViewById(R.id.cost_in_credits);
        length= findViewById(R.id.length);
        max_atmosphering_speed= findViewById(R.id.max_atmosphering_speed);
        crew= findViewById(R.id.crew);
        passengers= findViewById(R.id.passengers);
        cargo_capacity= findViewById(R.id.cargo_capacity);
        consumables= findViewById(R.id.consumables);
        vehicle_class= findViewById(R.id.vehicle_class);

        name.setText(vehicule.getName());
        model.setText(vehicule.getModel());
        manufacturer.setText(vehicule.getManufacturer());
        cost_in_credits.setText(vehicule.getCost_in_credits());
        length.setText(vehicule.getLength());
        max_atmosphering_speed.setText(vehicule.getMax_atmosphering_speed());
        crew.setText(vehicule.getCrew());
        passengers.setText(vehicule.getPassengers());
        cargo_capacity.setText(vehicule.getCargo_capacity());
        consumables.setText(vehicule.getConsumables());
        vehicle_class.setText(vehicule.getVehicle_class());





    }


    public static Intent getStartIntent(final Context context) {
        return new Intent(context, VehiculeDetailActivity.class);
    }


}

