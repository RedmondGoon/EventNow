package com.example.redmo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.redmo.myapplication.Adapter.CategoryViewAdapter;
import com.example.redmo.myapplication.Database.EventRepository;
import com.example.redmo.myapplication.Network.ApiUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home extends AppCompatActivity implements CategoryViewAdapter.ItemClickListener {

    private APIService mAPIservice;
    private CategoryViewAdapter adapter;
    Event test = new Event(1,"a","b","c","d","e","f");
    //database
    private CompositeDisposable compositeDisposable;
    private EventRepository eventRepository;
    List<Event> eventList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        /*
        compositeDisposable = new CompositeDisposable();

        //Database
        EventDatabase eventDatabase = EventDatabase.getInstance(this); //create database
        eventRepository = EventRepository.getmInstance(EventDataSource.getInstance(eventDatabase.eventDao()));
        eventRepository.insertEvent(test);
        //loadData();
        */

        mAPIservice = ApiUtils.getAPIService();

        sendPost();


//        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
//
//        Call<Event> call = service.getAllEvents();

        // data to populate the RecyclerView with
        ArrayList<String> catList = new ArrayList<>();
        catList.add("Art");
        catList.add("Business");
        catList.add("Festivals");
        catList.add("Lifestyle");
        catList.add("Nature");
        catList.add("Sports");

        ArrayList<String> catImgList = new ArrayList<>();
        catImgList.add("art");
        catImgList.add("business");
        catImgList.add("festivals");
        catImgList.add("lifestyle");
        catImgList.add("nature");
        catImgList.add("sports");

        ArrayList<String> latList = new ArrayList<>();
        latList.add("bird");


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.category);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        adapter = new CategoryViewAdapter(this, catList, catImgList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    public void sendPost() {
        mAPIservice.getAllEvents().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {

                    Log.e("Home", "Request is Successful. Response code is "+response.code());
                    JsonObject res = response.body();
                    //JsonArray events = res.get("events")
                    Integer noOfEvents = res.get("events").getAsJsonArray().size();
                    for(int i = 0; i < noOfEvents; i++){
                        JsonObject event = res.get("events").getAsJsonArray().get(i).getAsJsonObject();

                        Log.e("asdasd",event.get("name").toString());
                        Log.e("asdasd",event.get("category").getAsJsonObject().get("name").toString());
                        Log.e("asdasd",event.get("description").toString());
                        Log.e("asdasd",event.get("datetime_start").toString() + " - " +event.get("datetime_end").toString());
                        Log.e("asdasd",event.get("location_summary").toString() + ", " + event.get("address").toString());
                        Log.e("asadds",event.get("web_sites").getAsJsonObject().get("web_sites").getAsJsonArray().get(0).getAsJsonObject().get("url").toString());

                        int lol = event.get("images").getAsJsonObject().get("images").getAsJsonArray().get(0).getAsJsonObject().get("transforms").getAsJsonObject().get("transforms").getAsJsonArray().size();
                        Log.e("fdfdfs","lol"+lol);
                        Log.e("asdasd",event.get("images").getAsJsonObject().get("images").getAsJsonArray().get(0).getAsJsonObject().get("transforms").getAsJsonObject().get("transforms").getAsJsonArray().get(lol-1).getAsJsonObject().get("url").toString());


                    }
                    Log.e("asdasda","Events: "+res.get("events").getAsJsonArray().size());


                    Log.e("Home","Printing body:"+response.body().toString());
                } else {
                    Log.e("Home", "Request not successful. Response code is "+response.code());
                    Log.e("Home","Printing body:"+response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on item position " + position, Toast.LENGTH_SHORT).show();
    }
/*
    public void loadData(){
        //user RxJava

        Disposable disposable = eventRepository.getAllEvents()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Scheduler.io()).subscribe(new Consumer<List<Event>>() {
                    @Override
                    public void accept(List<Event> events) throws Exception {
                        onGetAllEventSuccess(events);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(Home.this,""+throwable.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
        compositeDisposable.add(disposable);
    }

    private void onGetAllEventSuccess(List<Event> events){
        eventList.clear();
        eventList.addAll(events);
        adapter.notifyDataSetChanged();

    }*/
}
