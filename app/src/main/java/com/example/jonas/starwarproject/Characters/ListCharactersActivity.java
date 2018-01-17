package com.example.jonas.starwarproject.Characters;

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

public class ListCharactersActivity extends AppCompatActivity {

    private ListView characterListView;
    private List<Character> characterList = new ArrayList<>();
    private ProgressBar progressBar;
    private CharactersAdapter charactersAdapter;
    public static final int REQUEST_CODE_LIST = 1235;
    private final ApiService apiService = ApiService.Builder.getInstance();

    private Characters allCharacters = null;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        progressBar = findViewById(R.id.loader);
        progressBar.setVisibility(View.VISIBLE);
        characterListView = findViewById(R.id.charactersList);


        apiService.readPeople().enqueue(new Callback<Characters>() {
            @Override
            public void onResponse(final Call<Characters> call, final Response<Characters> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        handleResponse(response);
                    }
                });
            }

            @Override
            public void onFailure(final Call<Characters> call, final Throwable t) {t.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
    }

    public static Intent getStartIntent(final Context context) {
        return new Intent(context, ListCharactersActivity.class);
    }

    /**
     * Handle default response for both GET/POST methods
     */
    private void handleResponse(final Response<Characters> response) {
        if (response.isSuccessful()) {
            setResultsQuery(response.body());
        } else { // error HTTP
            Toast.makeText(ListCharactersActivity.this,"unknown_error", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Set the led drawable depending on status
     */
    private void setResultsQuery(final Characters newCharacters) {
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.GONE);
        for (int i =0; i<newCharacters.getResults().size();i++){
            characterList.add(newCharacters.getResults().get(i));
        }
        charactersAdapter = new CharactersAdapter(this, characterList);
        characterListView.setAdapter(charactersAdapter);
        characterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Character character = (Character) parent.getItemAtPosition(position);
                final Intent intent = CharacterDetailActivity.getStartIntent(ListCharactersActivity.this);
                intent.putExtra("theCharacter", character);
                startActivityForResult(intent, CharacterDetailActivity.REQUEST_CODE_CHARACTER_DETAIL);
            }
        });
    }

}

