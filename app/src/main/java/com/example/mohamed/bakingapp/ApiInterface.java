package com.example.mohamed.bakingapp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mohamed on 6/2/2017.
 */

public interface ApiInterface {

    @GET("2017/May/59121517_baking/baking.json")
    Call<Recip[]> getRecip();


}
