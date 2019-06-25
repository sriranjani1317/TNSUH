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

import cgg.gov.in.tnsuh.Model.RegisterMasterBean;

public class RegisterInspectionAdapter  extends RecyclerView.Adapter<RegisterInspectionAdapter.MyViewHolder> {

    private List<RegisterMasterBean> registerMasterBeanList;
    private Context mContext;
    private Activity activity;

    RegisterMasterBean registerMasterBean;
    ListView recyclerView;

    public RegisterInspectionAdapter(List<RegisterMasterBean> registerMasterBeanList1, Context mContext, Activity activity) {

        this.registerMasterBeanList = registerMasterBeanList1;
        this.mContext = mContext;
        this.activity = activity;
    }


    @Override
    public RegisterInspectionAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.registerinspectioncard, parent, false);
        RegisterInspectionAdapter.MyViewHolder myViewHolder = new RegisterInspectionAdapter.MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final RegisterInspectionAdapter.MyViewHolder holder, final int position) {

        registerMasterBean = registerMasterBeanList.get(position);

        holder.id.setText(registerMasterBean.getRegisterId());
       holder.name.setText(registerMasterBean.getRegisterName());




    }

    @Override
    public int getItemCount() {
        return registerMasterBeanList.size();
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
