package cgg.gov.in.tnsuh;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import cgg.gov.in.tnsuh.Model.AmenityDetail;
import cgg.gov.in.tnsuh.Model.Personaldetails;

public class ProfileAdapter  extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {

    private List<Personaldetails> shelterDetailsBeanList;
    private Context mContext;
    private Activity activity;

    Personaldetails shelterDetailsBean;
    ListView recyclerView;

    public ProfileAdapter(List<Personaldetails> shelterDetailsBeanList, Context mContext, Activity activity) {

        this.shelterDetailsBeanList = shelterDetailsBeanList;
        this.mContext = mContext;
        this.activity = activity;
    }


    @Override
    public ProfileAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profilecard, parent, false);
        ProfileAdapter.MyViewHolder myViewHolder = new ProfileAdapter.MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ProfileAdapter.MyViewHolder holder, final int position) {

        shelterDetailsBean = shelterDetailsBeanList.get(position);

        holder.id.setText(shelterDetailsBean.getId());
        holder.name.setText(shelterDetailsBean.getName());
        holder.availornot.setText(shelterDetailsBean.getPhoneNo());




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

