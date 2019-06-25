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
import cgg.gov.in.tnsuh.Model.AttendanceBean;
import cgg.gov.in.tnsuh.Model.Personaldetails;

public class AttendanceAdapter  extends RecyclerView.Adapter<AttendanceAdapter.MyViewHolder> {

    private List<AttendanceBean> shelterDetailsBeanList;
    private Context mContext;
    private Activity activity;

    AttendanceBean shelterDetailsBean;
    ListView recyclerView;

    public AttendanceAdapter(List<AttendanceBean> shelterDetailsBeanList, Context mContext, Activity activity) {

        this.shelterDetailsBeanList = shelterDetailsBeanList;
        this.mContext = mContext;
        this.activity = activity;
    }


    @Override
    public AttendanceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attendancecard, parent, false);
        AttendanceAdapter.MyViewHolder myViewHolder = new AttendanceAdapter.MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final AttendanceAdapter.MyViewHolder holder, final int position) {

        shelterDetailsBean = shelterDetailsBeanList.get(position);

        holder.id.setText(shelterDetailsBean.getId());
        holder.name.setText(shelterDetailsBean.getName());
        holder.availornot.setText(shelterDetailsBean.getAttendance());
        holder.dob.setText(shelterDetailsBean.getDateOfBirth());




    }

    @Override
    public int getItemCount() {
        return shelterDetailsBeanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id,name,availornot,dob;
        CardView cardview;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.id = (TextView) itemView.findViewById(R.id.amenity_id);

            this.name = (TextView) itemView.findViewById(R.id.amenity_name);
            this.availornot = (TextView) itemView.findViewById(R.id.amenityavialnot);
            this.dob = (TextView) itemView.findViewById(R.id.dateofbirth);




        }
    }
}

