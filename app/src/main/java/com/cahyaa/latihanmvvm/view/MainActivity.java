package com.cahyaa.latihanmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cahyaa.latihanmvvm.R;
import com.cahyaa.latihanmvvm.adapter.MahasiswaAdapter;
import com.cahyaa.latihanmvvm.model.Mahasiswa;
import com.cahyaa.latihanmvvm.viewmodel.MainViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_main;
    private FloatingActionButton fab_main;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_main = findViewById(R.id.rv_main);
        fab_main = findViewById(R.id.fab_add_main);

        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddDataActivity.class);
                startActivity(intent);
            }
        });

        viewModel = new ViewModelProvider(MainActivity.this).get(MainViewModel.class);
        viewModel.getMahasiswa(); //Request
        viewModel.getResultGetMahasiswa().observe(MainActivity.this, showResult); //Response
    }

    private Observer<ArrayList<Mahasiswa>> showResult = new Observer<ArrayList<Mahasiswa>>() {
        @Override
        public void onChanged(ArrayList<Mahasiswa> result) {
            rv_main.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            MahasiswaAdapter adapter = new MahasiswaAdapter(MainActivity.this);
            adapter.setListMahasiswa(result);
            rv_main.setAdapter(adapter);
        }
    };

}