package com.example.twentyone.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.twentyone.R;
import com.example.twentyone.activities.PointsDetailActivity;
import com.example.twentyone.model.data.BloodPressure;
import com.example.twentyone.model.data.Points;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BloodRecyclerAdapter extends RecyclerView.Adapter<BloodRecyclerAdapter.CustomViewHolder> {

    private static List<BloodPressure> mData;
    private LayoutInflater mInflater;

    public BloodRecyclerAdapter(Context context, List<BloodPressure> data) {
        mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder holder, final int position) {
        
        final BloodPressure current = mData.get(position);
        holder.setData(current, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("LISTTT", "viewPressed -> " + ((TextView)holder.itemView.findViewById(R.id.item_subTitle)).getText());
                Context context = v.getContext();
                Intent intent = new Intent(context, PointsDetailActivity.class);
                intent.putExtra("entry_id", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView item_id;
        TextView title;
        TextView subTitle;

        int position;
        BloodPressure current;

        public CustomViewHolder(@NonNull final View itemView) {
            super(itemView);
            item_id = itemView.findViewById(R.id.item_id);
            title = itemView.findViewById(R.id.item_title);
            subTitle = itemView.findViewById(R.id.item_subTitle);
        }

        public void setData(BloodPressure current, int position) {

            this.item_id.setText(String.valueOf(position + 1));
            this.title.setText(current.getTimestamp().toString());
            //this.subTitle.setText(current.getNotes());
            this.position = position;
            this.current = current;
        }
    }

    public static BloodPressure getPoints(int position) {
        return mData.get(position);
    }

    public List<BloodPressure> getPointsList() {
        return mData;
    }

    public void setPointsList(List<BloodPressure> data) {
        mData = data;
    }

}
