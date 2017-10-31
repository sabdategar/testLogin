package tegar.daily.loginmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import tegar.daily.loginmvp.R;
import tegar.daily.loginmvp.models.Pokemon;

/**
 * Created by Sabda Tegar Aditya on 10/23/2017.
 * linkedln : Sabda Tegar.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    ArrayList<Pokemon> dataset;
    Context context;

    public PokemonAdapter(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }
    @Override
    public PokemonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonAdapter.ViewHolder holder, int position) {
        Pokemon P = dataset.get(position);
        holder.tv_pokemon_name.setText(P.getName());

        Glide.with(context)
                .load("http://pokeapi.co/media/sprites/pokemon/" + P.getNumber() + ".png")
                .placeholder(R.mipmap.ic_launcher)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.iv_pokemon);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addPokemonList(ArrayList<Pokemon> listPokemon) {
        dataset.addAll(listPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_pokemon;
        TextView tv_pokemon_name;
        public ViewHolder(View itemView) {
            super(itemView);

            iv_pokemon = (ImageView)itemView.findViewById(R.id.iv_pokemon);
            tv_pokemon_name = (TextView)itemView.findViewById(R.id.tv_pokemon_name);
        }
    }
}
