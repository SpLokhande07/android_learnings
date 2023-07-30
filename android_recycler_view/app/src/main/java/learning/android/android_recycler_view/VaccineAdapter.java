package learning.android.android_recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VaccineAdapter extends RecyclerView.Adapter<VaccineAdapter.VaccineViewHolder>{


// 4- Create ItemClickListener interface

    private static ItemClickListener itemClickListener;

    // 1-Data source
    public VaccineModel[] vaccineModels;
    public VaccineAdapter(VaccineModel[] vaccineModels){
        this.vaccineModels = vaccineModels;
    }


    public void setClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    //2-Create ViewHolder class

    public static class VaccineViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener{

            public TextView tv_title;
            public ImageView iv_image;

        public VaccineViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_title = itemView.findViewById(R.id.text_view_1);
            this.iv_image = itemView.findViewById(R.id.image_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(itemClickListener != null){
                itemClickListener.onClick(v,getAdapterPosition(),false);
            }
        }
    }



    @NonNull
    @Override
    public VaccineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_item,parent,false);
        VaccineViewHolder viewHolder = new VaccineViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VaccineViewHolder holder, int position) {
        holder.tv_title.setText(vaccineModels[position].getName());
//        holder.iv_image.setImageResource(vaccineModels[position].getImageUrl());

    }

    @Override
    public int getItemCount() {
        return vaccineModels.length;
    }
}
