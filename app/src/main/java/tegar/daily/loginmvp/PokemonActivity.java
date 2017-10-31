package tegar.daily.loginmvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tegar.daily.loginmvp.adapter.PokemonAdapter;
import tegar.daily.loginmvp.models.Pokemon;
import tegar.daily.loginmvp.models.PokemonResponses;
import tegar.daily.loginmvp.pokeapi.PokeApiService;

/**
 * Created by Sabda Tegar Aditya on 10/23/2017.
 * linkedln : Sabda Tegar.
 */

public class PokemonActivity extends AppCompatActivity {

    Retrofit retrofit;
    BaseView baseView;
    RecyclerView rv_pokemon;
    PokemonAdapter pokemonAdapter;

    int offset;
    boolean pages;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setSubtitle("Pokemon");
        initView();

        pokemonAdapter = new PokemonAdapter(this);
        rv_pokemon.setAdapter(pokemonAdapter);
        rv_pokemon.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rv_pokemon.setLayoutManager(layoutManager);

        baseView = new BaseView();
        retrofit = new Retrofit.Builder()
                //.baseUrl("http://api.learn2crack.com")
                .baseUrl("https://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        pages = true;
        offset = 0;
        getPokemonData();
    }

    private void initView(){
        rv_pokemon = (RecyclerView)findViewById(R.id.rv_pokemon);
    }
    private void getPokemonData(){
        PokeApiService service = retrofit.create(PokeApiService.class);
        Call<PokemonResponses> pokemonResponsesCall = service.showListCity();

        pokemonResponsesCall.enqueue(new Callback<PokemonResponses>() {
            @Override
            public void onResponse(Call<PokemonResponses> call, Response<PokemonResponses> response) {
                if (response.isSuccessful()){
                    PokemonResponses pokemonResponses =  response.body();
                    ArrayList<Pokemon> listPokemon = new ArrayList<Pokemon>(pokemonResponses.getResults());

                    pokemonAdapter.addPokemonList(listPokemon);
                }else {
                    Log.d("Unseccessful :", ""+ response.errorBody());
                    baseView.makeToast(PokemonActivity.this, response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponses> call, Throwable t) {
                Log.d("Failure :", ""+ t.getMessage());
                baseView.makeToast(PokemonActivity.this, t.getMessage().toString());
            }
        });
    }
}
