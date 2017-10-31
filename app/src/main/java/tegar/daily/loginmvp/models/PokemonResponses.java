package tegar.daily.loginmvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sabda Tegar Aditya on 10/23/2017.
 * linkedln : Sabda Tegar.
 */

public class PokemonResponses {
    /*Pokemon[] android;

    public Pokemon[] getAndroid() {
        return android;
    }

    public void setAndroid(Pokemon[] android) {
        this.android = android;
    }*/

    /*ArrayList<Pokemon> android = new ArrayList<>();

    public ArrayList<Pokemon> getAndroid() {
        return android;
    }

    public void setAndroid(ArrayList<Pokemon> android) {
        this.android = android;
    }*/

    String count;
    String previous;
    ArrayList<Pokemon> results = new ArrayList<>();
    String next;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
