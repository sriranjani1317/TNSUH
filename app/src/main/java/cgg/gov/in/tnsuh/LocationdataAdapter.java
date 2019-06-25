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
import cgg.gov.in.tnsuh.Model.LocationDetail;


public class LocationdataAdapter  extends RecyclerView.Adapter<LocationdataAdapter.MyViewHolder> {

    private List<LocationDetail> shelterDetailsBeanList;
    private Context mContext;
    private Activity activity;

    LocationDetail shelterDetailsBean;
    ListView recyclerView;

    public LocationdataAdapter(List<LocationDetail> shelterDetailsBeanList, Context mContext, Activity activity) {

        this.shelterDetailsBeanList = shelterDetailsBeanList;
        this.mContext = mContext;
        this.activity = activity;
    }


    @Override
    public LocationdataAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.locatiodatacard, parent, false);
       LocationdataAdapter.MyViewHolder myViewHolder = new LocationdataAdapter.MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final LocationdataAdapter.MyViewHolder holder, final int position) {

        shelterDetailsBean = shelterDetailsBeanList.get(position);

        holder.latitude.setText(shelterDetailsBean.getLatitude());
        holder.longitude.setText(shelterDetailsBean.getLongitude());




    }

    @Override
    public int getItemCount() {
        return shelterDetailsBeanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView latitude,longitude;
        CardView cardview;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.latitude = (TextView) itemView.findViewById(R.id.latitude);

            this.longitude = (TextView) itemView.findViewById(R.id.Longitude);




        }
    }
}

