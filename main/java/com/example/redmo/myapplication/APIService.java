package com.example.redmo.myapplication;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService{


    @POST("events.json?fields=event:(name,description,datetime_start,datetime_end,location_summary,address,point,category,images,web_sites),category:(name)")
    @Headers("Authorization: Basic ZXZlbnRzbm93OnM1NzU4cWJ6ZGNxNQ==")
    Call<JsonObject> getAllEvents();


}
