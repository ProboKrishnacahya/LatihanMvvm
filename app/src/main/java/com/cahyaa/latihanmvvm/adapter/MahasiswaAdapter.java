package com.cahyaa.latihanmvvm.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cahyaa.latihanmvvm.R;
import com.cahyaa.latihanmvvm.model.Mahasiswa;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Mahasiswa> listMahasiswa;

    private ArrayList<Mahasiswa> getListMahasiswa() {
        return listMahasiswa;
    }

    public void setListMahasiswa(ArrayList<Mahasiswa> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;
    }

    public MahasiswaAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mahasiswa, parent, false);
        return new MahasiswaAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position) {
        final Mahasiswa m = getListMahasiswa().get(position);
        holder.lbl_name.setText(m.getName());
        holder.lbl_nim.setText(m.getNim());
    }

    @Override
    public int getItemCount() {
        return getListMahasiswa().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        TextView lbl_name, lbl_nim;

        CardViewViewHolder(View item) {
            super(item);
            lbl_name = item.findViewById(R.id.lbl_name_adp_mhs);
            lbl_nim = item.findViewById(R.id.lbl_nim_adp_mhs);
        }
    }
}