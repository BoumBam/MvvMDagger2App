package com.example.daag.di;

import com.example.daag.model.RecyclerList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroServiceInterface {

    @GET("repositories")
    Observable<RecyclerList> getDataFromAPI(@Query("q")String query);
}
