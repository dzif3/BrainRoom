package com.example.brainroom.Mapel.sAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brainroom.Detail.DetailIndo;
import com.example.brainroom.Detail.DetailKimia;
import com.example.brainroom.Mapel.Model.DataModel;
import com.example.brainroom.R;

import java.util.List;

public class AdapterKimia extends RecyclerView.Adapter<AdapterKimia.HolderData> {
    private Context ctx;
    private List<DataModel> listmapel;



    public AdapterKimia(Context ctx, List<DataModel> listmapel) {
        this.ctx = ctx;
        this.listmapel = listmapel;
    }


    @NonNull
    @Override
    public AdapterKimia.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_card,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterKimia.HolderData holder, final int position) {
        DataModel dataModel = listmapel.get(position);
        holder.tvid.setText(String.valueOf(dataModel.getId()));
        holder.tvsemester.setText(dataModel.getSemester());
        holder.tvjudul.setText(dataModel.getJudul());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailKimia.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listmapel.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvid, tvjudul, tvsemester;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvid = itemView.findViewById(R.id.tvid);
            tvsemester = itemView.findViewById(R.id.semester);
            tvjudul = itemView.findViewById(R.id.judul);

        }
    }
}
