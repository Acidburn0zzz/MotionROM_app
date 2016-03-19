package com.apavayan.motion;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apavayan on 17-03-2016.
 */
public class infoAdapter extends RecyclerView.Adapter<infoAdapter.ViewHolder> {

    List<AdapterData> mItems;

    public infoAdapter() {
        super();
        mItems = new ArrayList<AdapterData>();
        AdapterData data = new AdapterData();
        data.setName("Warning:");
        data.setDetail("The Rom is under development. The Project is handled By the Motion Team\n Don't delete this App it Will make you go crazy");
        mItems.add(data);

        data = new AdapterData();
        data.setName("Info");
        data.setDetail("This Project was Started by aapav01. To bring the Fun of Touchwiz Lollipop to our device which company had decide to not push the update to our device but our brother S5 mini duos. So Aapav01 and His team Managed to port and make it 100% Working On Other Family Member of Samsung msm8226 chipset.\n\n" +
                "We will love to provide update as The samsung ship to the S5 mini Duos.\n\nAnd Please Don't Forget to give us Thanks om XDA threads");
        mItems.add(data);

        data = new AdapterData();
        data.setName("Device info:");
        data.setDetail(device());
        mItems.add(data);

    }

    private String device()
    {
        String Fullinfo;
        String bootloader = Build.BOOTLOADER;
        String model = bootloader.substring(0,5);
        if (model.equals("G7102")) {
            Fullinfo = "Model: SM-G7102\ncodename: ms013g\nBootloader: "    + bootloader ;
        } else if (model.equals("G7105")) {
            Fullinfo = "Model: SM-G7105\ncodename: ms01lte\nBootloader: "   + bootloader ;
        } else if (model.equals("G710K")) {
            Fullinfo = "Model: SM-G710K\ncodename: ms01ltektt\nBootloader: " + bootloader ;
        } else if (model.equals("G710X")) {
            Fullinfo = "Model: SM-G710\ncodename: ms01xx\nBootloader: " + bootloader ;
        } else if (model.equals("I9300")) {
            Fullinfo = "Model: GT-I9300I\ncodename: s3ve3gds\nBootloader: " + bootloader ;
        } else if (model.equals("I9301")) {
            Fullinfo = "Model: GT-I9301I\ncodename: s3ve3g\nBootloader: "   + bootloader;
        } else {
            Fullinfo = model;
        }
        return  Fullinfo;
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_box, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        AdapterData movie = mItems.get(i);
        viewHolder.natName.setText(movie.getName());
        viewHolder.natDetail.setText(movie.getDetail());
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView natThumbnail;
        public TextView natName;
        public TextView natDetail;
        CardView cv;


        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv_info);
            natName = (TextView)itemView.findViewById(R.id.card_name);
            natDetail = (TextView)itemView.findViewById(R.id.card_detail);
        }
    }
}
