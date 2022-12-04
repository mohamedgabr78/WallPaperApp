package algonquin.cst2335.wallpaperapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL="https://api.pexels.com/v1/";

    @Header("Authorization"+Apis.API)
    @GET("curated")
    Call<SearchModel> getImage(
            @Query("page") int page
            , @Query("per_page") int per_page);

    @Header("Authorization"+Apis.API)
    @GET("search")
    Call<SearchModel> getImage(
            @Query("query") String query
            ,@Query("page") int page
            , @Query("per_page") int per_page);
}
