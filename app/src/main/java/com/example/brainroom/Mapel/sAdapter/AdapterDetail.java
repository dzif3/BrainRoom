package com.example.brainroom.Mapel.sAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brainroom.Mapel.Model.DataModel;
import com.example.brainroom.R;

import java.util.List;

public class AdapterDetail extends RecyclerView.Adapter<AdapterDetail.HolderData> {
    private Context ctx;
    private List<DataModel> listmapel;



    public AdapterDetail(Context ctx, List<DataModel> listmapel) {
        this.ctx = ctx;
        this.listmapel = listmapel;
    }


    @NonNull
    @Override
    public AdapterDetail.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_detail,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDetail.HolderData holder, final int position) {
        DataModel dataModel = listmapel.get(position);
        holder.tvid.setText(String.valueOf(dataModel.getId()));
        holder.subjudul.setText(dataModel.getSubjudul());
        holder.subjudul1.setText(dataModel.getSubjudul1());
        holder.subjudul2.setText(dataModel.getSubjudul2());
        holder.subjudul3.setText(dataModel.getSubjudul3());
        holder.subjudul4.setText(dataModel.getSubjudul4());
        holder.isi.setText(dataModel.getIsi());
        holder.isi1.setText(dataModel.getIsi1());
        holder.isi2.setText(dataModel.getIsi2());
        holder.isi3.setText(dataModel.getIsi3());
        holder.isi4.setText(dataModel.getIsi4());

    }

    @Override
    public int getItemCount() {
        return listmapel.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvid,judul, subjudul, subjudul1,subjudul2,subjudul3,subjudul4,
                isi,isi1,isi2,isi3,isi4;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvid = itemView.findViewById(R.id.tvidd);
            subjudul = itemView.findViewById(R.id.subjudul);
            isi = itemView.findViewById(R.id.isi);
            subjudul1 = itemView.findViewById(R.id.subjudul1);
            isi1 = itemView.findViewById(R.id.isi1);
            subjudul2 = itemView.findViewById(R.id.subjudul2);
            isi2 = itemView.findViewById(R.id.isi2);
            subjudul3 = itemView.findViewById(R.id.subjudul3);
            isi3 = itemView.findViewById(R.id.isi3);
            subjudul4 = itemView.findViewById(R.id.subjudul4);
            isi4 = itemView.findViewById(R.id.isi4);

        }
    }
}
