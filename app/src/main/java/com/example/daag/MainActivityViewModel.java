package com.example.daag;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.daag.di.RetroServiceInterface;
import com.example.daag.model.RecyclerList;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<RecyclerList> liveDataList;

    @Inject
    RetroServiceInterface mService;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        ((MyApplication)application).getRetroComponent().inject(MainActivityViewModel.this);
        liveDataList = new MutableLiveData<>();
    }

    public MutableLiveData<RecyclerList> getRecyclerListObserver() {
        return liveDataList;
    }

    public void makeApiCall() {

      /*   Call<RecyclerList> call = mService.getDataFromAPI("network");
        call.enqueue(new Callback<RecyclerList>() {
            @Override
            public void onResponse(Call<RecyclerList> call, Response<RecyclerList> response) {
                 if(response.isSuccessful()) {
                     liveDataList.postValue(response.body());
                 } else {
                     liveDataList.postValue(null);
                 }
            }
            @Overrideu
            public void onFailure(Call<RecyclerList> call, Throwable t) {
                liveDataList.postValue(null);
            }
        });
      */

       /* compositeDisposable.add(mService.getDataFromAPI("network")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RecyclerList>() {
                    @Override
                    public void accept(RecyclerList posts) throws Exception {
                        Log.d("TAG", "accept: "+posts);
                        liveDataList.postValue(posts);
                    }
                })
        ); */

        compositeDisposable.add(mService.getDataFromAPI("network")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<RecyclerList>() {

                    @Override
                    public void onNext(RecyclerList recyclerList) {
                        liveDataList.postValue(recyclerList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "onComplete: is full");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TAG", "onComplete: is full");
                    }
                })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
