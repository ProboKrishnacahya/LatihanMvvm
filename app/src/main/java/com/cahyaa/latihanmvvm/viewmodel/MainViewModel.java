package com.cahyaa.latihanmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.cahyaa.latihanmvvm.model.Mahasiswa;
import com.cahyaa.latihanmvvm.repositories.MainRepository;

import java.util.ArrayList;

public class MainViewModel extends AndroidViewModel {

    private MainRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = MainRepository.getInstance();
    }

    //*Begin of ViewModel Add Mahasiswa
    private MutableLiveData<ArrayList<Mahasiswa>> resultAddMahasiswa = new MutableLiveData<>();
    public void addMahasiswa(String name, String nim) {
        resultAddMahasiswa = repository.addMahasiswa(name, nim);
    }

    public LiveData<ArrayList<Mahasiswa>> getResultAddMahasiswa() {
        return resultAddMahasiswa;
    }
    //End of ViewModel Add Mahasiswa

    //*Begin of ViewModel Get Mahasiswa
    private MutableLiveData<ArrayList<Mahasiswa>> resultGetMahasiswa = new MutableLiveData<>();
    public void getMahasiswa() {
        resultGetMahasiswa = repository.getMahasiswa();
    }

    public LiveData<ArrayList<Mahasiswa>> getResultGetMahasiswa() {
        return resultGetMahasiswa;
    }
    //End of ViewModel Get Mahasiswa

}