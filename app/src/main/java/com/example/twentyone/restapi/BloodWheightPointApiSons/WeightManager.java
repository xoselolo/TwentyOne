package com.example.twentyone.restapi.BloodWheightPointApiSons;

import android.util.Log;

import com.example.twentyone.model.data.BloodPressure;
import com.example.twentyone.model.data.Points;
import com.example.twentyone.model.data.UserToken;
import com.example.twentyone.model.data.Weight;
import com.example.twentyone.restapi.BloodWeightPointDataApiManager;
import com.example.twentyone.restapi.RestAPIService;
import com.example.twentyone.restapi.callback.BloodWeightPointsGPSDAPICallBack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeightManager extends BloodWeightPointDataApiManager {
    public WeightManager(UserToken userToken, RestAPIService restApiService) {
        super(userToken, restApiService);
    }
    /*

    protected synchronized void getAll(final BloodWeightPointsGPSDAPICallBack bwpgpsdapiCallBack, final int level){
        Log.d("LRM", "all points GET request");

        Map<String,String> data = new HashMap<>();
        data.put("page",String.valueOf(level));
        Call<Weight[]> call = restApiService.getAllWeight("Bearer " + userToken.getIdToken(),data);
        call.enqueue(new Callback<Weight[]>() {
            @Override
            public void onResponse(Call<Weight[]> call, Response<Weight[]> response) {
                if (response.isSuccessful()) {
                    if(response.body().length>0){
                        genList.addAll(Arrays.asList(response.body()));
                        getAll(bwpgpsdapiCallBack,level+1);
                    }
                    else{
                        Weight[] weights = new Weight[1];
                        bwpgpsdapiCallBack.onFinishedCallback(weights);
                    }
                } else {
                    bwpgpsdapiCallBack.onFailure(new Throwable("ERROR " + response.code() + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Weight[]> call, Throwable t) {
                bwpgpsdapiCallBack.onFailure(t);
            }
        });

    }

    protected synchronized void getAllByUser(final BloodWeightPointsGPSDAPICallBack bwpgpsdapiCallBack, final int level){
        Log.d("LRM", "all points GET request");
        //http://android.byted.xyz/api/points?page=1000&paged=true&sort.sorted=false&sort.unsorted=true
        Map<String, String> map = new HashMap<>();
        map.put("query","SELECT * FROM WEIGHT WHERE USER_ID = "+userToken.getIdToken());
        map.put("page",String.valueOf(level));

        Call<Weight[]> call =  restApiService.getAllWeightByUser("Bearer " + userToken.getIdToken(),map);
        call.enqueue(new Callback<Weight[]>() {
            @Override
            public void onResponse(Call<Weight[]> call, Response<Weight[]> response) {
                if (response.isSuccessful()) {
                    if(response.body().length>0){
                        if(response.body()[response.body().length-1].getUser().getId()!=Integer.parseInt(userToken.getIdToken())){
                            for(Weight w : response.body()){
                                if(w.getUser().getId()==Integer.parseInt(userToken.getIdToken())){
                                    getGenListByUser.add(w);
                                    continue;
                                }
                                break;
                            }
                            Weight[] weights = new Weight[1];
                            bwpgpsdapiCallBack.onFinishedCallback(weights);
                            return;
                        }
                        getGenListByUser.addAll(Arrays.asList(response.body()));
                        getAllByUser(bwpgpsdapiCallBack,level+1);
                    }
                    else{
                        Weight[] weights = new Weight[1];
                        bwpgpsdapiCallBack.onFinishedCallback(weights);
                    }

                } else {
                    bwpgpsdapiCallBack.onFailure(new Throwable("ERROR " + response.code() + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Weight[]> call, Throwable t) {
                bwpgpsdapiCallBack.onFailure(t);
            }
        });
    }

    protected synchronized void getAllByUser(final BloodWeightPointsGPSDAPICallBack bwpgpsdapiCallBack, final int level, String search){
        Log.d("LRM", "all points GET request");
        //http://android.byted.xyz/api/points?page=1000&paged=true&sort.sorted=false&sort.unsorted=true
        Map<String, String> map = new HashMap<>();
        map.put("query","SELECT * FROM POINTS WHERE USER_ID = "+userToken.getIdToken()+ "AND (JHI_TIMESTAMP LIKE '%"+search+"%' OR WEIGHT LIKE '%"+search+"%')");
        map.put("page",String.valueOf(level));

        Call<Points[]> call =  restApiService.getPointsByUser("Bearer " + userToken.getIdToken(),map);
        call.enqueue(new Callback<Points[]>() {
            @Override
            public void onResponse(Call<Points[]> call, Response<Points[]> response) {
                if (response.isSuccessful()) {
                    if(response.body().length>0){
                        if(response.body()[response.body().length-1].getUser().getId()!=Integer.parseInt(userToken.getIdToken())){
                            for(Points p : response.body()){
                                if(p.getUser().getId()==Integer.parseInt(userToken.getIdToken())){
                                    getGenListByUser.add(p);
                                    continue;
                                }
                                break;
                            }
                            Weight[] weights = new Weight[1];
                            bwpgpsdapiCallBack.onFinishedCallback(weights);
                            return;
                        }
                        getGenListByUser.addAll(Arrays.asList(response.body()));
                        getAllByUser(bwpgpsdapiCallBack,level+1);
                    }
                    else{
                        Weight[] weights = new Weight[1];
                        bwpgpsdapiCallBack.onFinishedCallback(weights);
                    }

                } else {
                    bwpgpsdapiCallBack.onFailure(new Throwable("ERROR " + response.code() + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Points[]> call, Throwable t) {
                bwpgpsdapiCallBack.onFailure(t);
            }
        });
    }
    */
}
