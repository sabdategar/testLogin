package tegar.daily.loginmvp.models;

/**
 * Created by Sabda Tegar Aditya on 10/23/2017.
 * linkedln : Sabda Tegar.
 */

public class Pokemon {
    /*String ver;
    String name;
    String api;

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }*/

    String name;
    String url;
    int number;

    public int getNumber() {
        String[] urlPart = url.split("/");
        return Integer.parseInt(urlPart[urlPart.length-1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
