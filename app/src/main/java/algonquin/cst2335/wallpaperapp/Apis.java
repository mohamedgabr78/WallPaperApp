package algonquin.cst2335.wallpaperapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apis {

    public static Retrofit retrofit = null;

    public static final String API = "563492ad6f917000010000014802c08f009e4ab49dd5cc61110d27f3";

    public static ApiInterface getApiInterface(){
        if(retrofit == null){
            retrofit=new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(ApiInterface.class);
    }

}
