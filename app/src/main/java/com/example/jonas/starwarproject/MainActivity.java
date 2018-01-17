package com.example.jonas.starwarproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView openButton;
    private ImageView homeImage;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeImage = findViewById(R.id.homeImage);
        homeImage.setOnClickListener(toMenuAction);
        openButton = findViewById(R.id.homeButton1);
        openButton.setOnClickListener(toMenuAction);
    }

    View.OnClickListener toMenuAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Intent intent = MenuActivity.getStartIntent(MainActivity.this);
            startActivityForResult(intent, MenuActivity.REQUEST_CODE_MENU);
            // start devices activity and wait for result
        }
    };
}



