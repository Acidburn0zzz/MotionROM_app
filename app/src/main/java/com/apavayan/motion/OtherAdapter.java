package com.apavayan.motion;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apavayan on 17-03-2016.
 */
public class OtherAdapter extends RecyclerView.Adapter<OtherAdapter.ViewHolder> {

    List<AdapterData> mItems;

    public OtherAdapter() {
        super();
        mItems = new ArrayList<AdapterData>();
        AdapterData data = new AdapterData();
        data.setName("v17.0");
        data.setDetail("*A \n*B \n*C");
        mItems.add(data);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.other, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        AdapterData movie = mItems.get(i);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        CardView cv;


        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.other);
        }
    }
}
