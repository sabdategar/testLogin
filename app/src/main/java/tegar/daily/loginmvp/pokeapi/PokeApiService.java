package tegar.daily.loginmvp.pokeapi;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tegar.daily.loginmvp.models.PokemonResponses;

/**
 * Created by Sabda Tegar Aditya on 10/23/2017.
 * linkedln : Sabda Tegar.
 */

public interface PokeApiService {

    //@POST("android/jsonandroid")
    @POST("api/v2/pokemon")
    Call<PokemonResponses> showListCity();
}
