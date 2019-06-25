package cgg.gov.in.tnsuh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import cgg.gov.in.tnsuh.Model.AmenityDetail;
import cgg.gov.in.tnsuh.Model.ShelterDetailsBean;

public class AmenityAdapter  extends RecyclerView.Adapter<AmenityAdapter.MyViewHolder> {

    private List<AmenityDetail> shelterDetailsBeanList;
    private Context mContext;
    private Activity activity;

    AmenityDetail shelterDetailsBean;
    ListView recyclerView;

    public AmenityAdapter(List<AmenityDetail> shelterDetailsBeanList, Context mContext, Activity activity) {

        this.shelterDetailsBeanList = shelterDetailsBeanList;
        this.mContext = mContext;
        this.activity = activity;
    }


    @Override
    public AmenityAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.amenitycard, parent, false);
        AmenityAdapter.MyViewHolder myViewHolder = new AmenityAdapter.MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final AmenityAdapter.MyViewHolder holder, final int position) {

        shelterDetailsBean = shelterDetailsBeanList.get(position);

        holder.id.setText(shelterDetailsBean.getAmenityId());
        holder.name.setText(shelterDetailsBean.getAmenityName());
        holder.availornot.setText(shelterDetailsBean.getAmenityAvailNotavail());




    }

    @Override
    public int getItemCount() {
        return shelterDetailsBeanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id,name,availornot;
        CardView cardview;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.id = (TextView) itemView.findViewById(R.id.amenity_id);

            this.name = (TextView) itemView.findViewById(R.id.amenity_name);
            this.availornot = (TextView) itemView.findViewById(R.id.amenityavialnot);




        }
    }
}

