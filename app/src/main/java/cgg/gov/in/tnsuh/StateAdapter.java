package cgg.gov.in.tnsuh;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cgg.gov.in.tnsuh.Model.StateMasterBean;

public class StateAdapter extends BaseAdapter implements android.widget.SpinnerAdapter {

        Context activity;
private ArrayList<StateMasterBean> arrayList;


public StateAdapter(ArrayList<StateMasterBean> typeofworkBeanList, Context applicationContext) {
        this.arrayList=typeofworkBeanList;
        activity = applicationContext;

        }

      public int getCount()
        {
        return arrayList.size();
        }

      public Object getItem(int i)
        {
        return arrayList.get(i);
        }

      public long getItemId(int i)
        {
        return (long)i;
        }



@Override
public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView txt = new TextView(activity);
        txt.setPadding(16, 16, 16, 16);
        txt.setTextSize(18);
        txt.setGravity(Gravity.CENTER_VERTICAL);
        txt.setText(arrayList.get(position).getStateName());
//        txt.setTextColor(Color.parseColor("#ffffff"));
        return  txt;
        }

public View getView(int i, View view, ViewGroup viewgroup) {
        TextView txt = new TextView(activity);
        txt.setGravity(Gravity.LEFT);
        txt.setPadding(16, 16, 16, 16);
        txt.setTextSize(16);
//        txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down_arrow, 0);
        txt.setText(arrayList.get(i).getStateName());
        txt.setTextColor(Color.parseColor("#000000"));
        return  txt;
        }

        }
