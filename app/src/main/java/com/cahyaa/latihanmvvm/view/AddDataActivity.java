package com.cahyaa.latihanmvvm.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.cahyaa.latihanmvvm.R;
import com.cahyaa.latihanmvvm.model.Mahasiswa;
import com.cahyaa.latihanmvvm.viewmodel.MainViewModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class AddDataActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextInputLayout til_name, til_nim;
    private Button btn_submit;
    private String name = "", nim = "";
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        toolbar = findViewById(R.id.toolbar_add_data);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        til_name = findViewById(R.id.til_name_add_data);
        til_nim = findViewById(R.id.til_nim_add_data);
        btn_submit = findViewById(R.id.btn_submit_add_data);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = til_name.getEditText().getText().toString().trim();
                nim = til_nim.getEditText().getText().toString().trim();
                if (name.isEmpty()) {
                    til_name.setError(getString(R.string.can_not_null));
                } else {
                    if (nim.isEmpty()) {
                        til_nim.setError(getString(R.string.can_not_null));
                    } else {
                        viewModel.addMahasiswa(name, nim);
                        viewModel.getResultAddMahasiswa().observe(AddDataActivity.this, showResult);
                    }
                }
            }
        });
    }

    private Observer<ArrayList<Mahasiswa>> showResult = new Observer<ArrayList<Mahasiswa>>() {
        @Override
        public void onChanged(ArrayList<Mahasiswa> result) {
//            for (int i = 0; i < result.size(); i++) {
//                Log.e("Mhs ke-" + i, result.get(i).getName());
//            }
            finish();
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}