package com.example.redmo.myapplication.Network;

import com.example.redmo.myapplication.APIService;

public class ApiUtils {
    private ApiUtils(){}

    public static APIService getAPIService(){
        return RetrofitClientInstance.getRetrofitInstance().create(APIService.class);
    }
}
