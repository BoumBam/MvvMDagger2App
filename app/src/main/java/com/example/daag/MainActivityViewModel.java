package com.example.daag;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.daag.di.RetroServiceInterface;
import com.example.daag.model.RecyclerList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<RecyclerList> liveDataList;

    @Inject
    RetroServiceInterface mService;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        ((MyApplication)application).getRetroComponent().inject(MainActivityViewModel.this);
        liveDataList = new MutableLiveData<>();
    }

    public MutableLiveData<RecyclerList> getRecyclerListObserver() {
        return liveDataList;
    }

    public void makeApiCall() {
        Call<RecyclerList> call = mService.getDataFromAPI("network");
        call.enqueue(new Callback<RecyclerList>() {
            @Override
            public void onResponse(Call<RecyclerList> call, Response<RecyclerList> response) {
                 if(response.isSuccessful()) {
                     liveDataList.postValue(response.body());
                 } else {
                     liveDataList.postValue(null);
                 }
            }

            @Override
            public void onFailure(Call<RecyclerList> call, Throwable t) {
                liveDataList.postValue(null);
            }
        });

    }
}
