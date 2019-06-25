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
import cgg.gov.in.tnsuh.Model.InmatesDetail;


public class InmatesAdapter  extends RecyclerView.Adapter<InmatesAdapter.MyViewHolder> {

    private List<InmatesDetail> shelterDetailsBeanList;
    private Context mContext;
    private Activity activity;

    InmatesDetail shelterDetailsBean;
    ListView recyclerView;

    public InmatesAdapter(List<InmatesDetail> shelterDetailsBeanList, Context mContext, Activity activity) {

        this.shelterDetailsBeanList = shelterDetailsBeanList;
        this.mContext = mContext;
        this.activity = activity;
    }


    @Override
    public InmatesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inmatescard, parent, false);
        InmatesAdapter.MyViewHolder myViewHolder = new InmatesAdapter.MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final InmatesAdapter.MyViewHolder holder, final int position) {

        shelterDetailsBean = shelterDetailsBeanList.get(position);

        holder.id.setText(shelterDetailsBean.getInmatesId());
        holder.name.setText(shelterDetailsBean.getInmatesName());
        holder.male.setText(shelterDetailsBean.getMale());
        holder.female.setText(shelterDetailsBean.getFemale());




    }

    @Override
    public int getItemCount() {
        return shelterDetailsBeanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id,name,male,female;
        CardView cardview;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.id = (TextView) itemView.findViewById(R.id.amenity_id);

            this.name = (TextView) itemView.findViewById(R.id.amenity_name);
            this.male = (TextView) itemView.findViewById(R.id.Male);
            this.female = (TextView) itemView.findViewById(R.id.Female);




        }
    }
}

