package com.example.jonas.starwarproject.Characters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jonas.starwarproject.R;

/**
 * Created by jonas on 16/01/18.
 */


public class CharacterDetailActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_CHARACTER_DETAIL = 1236;
    TextView name,height,mass,hairColor,skinColor,eyeColor,birth,gender;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);
        Character character = (Character)getIntent().getSerializableExtra("theCharacter");
        name = findViewById(R.id.nameCharacter);
        height = findViewById(R.id.height);
        mass = findViewById(R.id.mass);
        hairColor = findViewById(R.id.hair_color);
        skinColor = findViewById(R.id.skin_color);
        eyeColor = findViewById(R.id.eye_color);
        birth = findViewById(R.id.birth_year);
        gender = findViewById(R.id.gender);

        name.setText(character.getName());
        height.setText(character.getHeight());
        mass.setText(character.getMass());
        hairColor.setText(character.getHair_color());
        skinColor.setText(character.getSkin_color());
        eyeColor.setText(character.getEye_color());
        birth.setText(character.getBirth_year());
        gender.setText(character.getGender());
    }


    public static Intent getStartIntent(final Context context) {
        return new Intent(context, CharacterDetailActivity.class);
    }


}

