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

import cgg.gov.in.tnsuh.Model.ShelterDetailsBean;

public class ShelterAdapter extends RecyclerView.Adapter<ShelterAdapter.MyViewHolder> {

    private List<ShelterDetailsBean> shelterDetailsBeanList;
    private Context mContext;
    private Activity activity;

    ShelterDetailsBean shelterDetailsBean;
    ListView recyclerView;

    public ShelterAdapter(List<ShelterDetailsBean> shelterDetailsBeanList, Context mContext, Activity activity) {

        this.shelterDetailsBeanList = shelterDetailsBeanList;
        this.mContext = mContext;
        this.activity = activity;
    }


    @Override
    public ShelterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shelterdetailscard, parent, false);
        ShelterAdapter.MyViewHolder myViewHolder = new ShelterAdapter.MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ShelterAdapter.MyViewHolder holder, final int position) {

        shelterDetailsBean = shelterDetailsBeanList.get(position);

        holder.excecutive_date.setText(shelterDetailsBean.getShelterExecutiveCommitteeDate());
        holder.municipality_corporation_name.setText(shelterDetailsBean.getMunicipalityCorporationName());
        holder.district_name.setText(shelterDetailsBean.getDistrictName());
        holder.shelter_location.setText(shelterDetailsBean.getShelterLocation());

        holder.shelter_type.setText(shelterDetailsBean.getShelterType());
        holder.shelter_bank_account_formed.setText(shelterDetailsBean.getShelterBankAccountFormed());
        holder.shelter_start_date.setText(shelterDetailsBean.getShelterStartDate());
        holder.shelter_no_inmates.setText(shelterDetailsBean.getShelterNoInmates());
        holder.shelter_extend.setText(shelterDetailsBean.getShelterExtend());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(mContext,Shelterin.class);
                GlobalDeclaration.shelterid=shelterDetailsBean.getShelterId();
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                mContext.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return shelterDetailsBeanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView excecutive_date, municipality_corporation_name, district_name, shelter_location, shelter_type, shelter_bank_account_formed, shelter_start_date, shelter_no_inmates, shelter_extend;
        CardView cardview;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.excecutive_date = (TextView) itemView.findViewById(R.id.excecutive_date);

            this.municipality_corporation_name = (TextView) itemView.findViewById(R.id.municipality_corporation_name);
            this.district_name = (TextView) itemView.findViewById(R.id.district_name);
            this.shelter_location = (TextView) itemView.findViewById(R.id.shelter_location);
            this.shelter_type = (TextView) itemView.findViewById(R.id.shelter_type);
            this.shelter_bank_account_formed = (TextView) itemView.findViewById(R.id.shelter_bank_account_formed);
            this.shelter_start_date = (TextView) itemView.findViewById(R.id.shelter_start_date);
            this.shelter_no_inmates = (TextView) itemView.findViewById(R.id.shelter_no_inmates);
            this.shelter_extend = (TextView) itemView.findViewById(R.id.shelter_extend);

            this.cardview = (CardView) itemView.findViewById(R.id.cardview);


        }
    }
}
