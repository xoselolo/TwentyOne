package com.example.twentyone.adapter;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.twentyone.R;
import com.example.twentyone.activities.PointsDetailActivity;
import com.example.twentyone.model.data.Points;
import com.example.twentyone.model.data.Preferences;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PreferencesRecyclerAdapter extends RecyclerView.Adapter<PreferencesRecyclerAdapter.CustomViewHolder> {

    private static List<Preferences> mData;
    private LayoutInflater mInflater;

    public PreferencesRecyclerAdapter(Context context, List<Preferences> data) {
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
        
        final Preferences current = mData.get(position);
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
        Preferences current;

        public CustomViewHolder(@NonNull final View itemView) {
            super(itemView);
            item_id = itemView.findViewById(R.id.item_id);
            title = itemView.findViewById(R.id.item_title);
            subTitle = itemView.findViewById(R.id.item_subTitle);
        }

        public void setData(Preferences current, int position) {

            this.item_id.setText(String.valueOf(position + 1));
            this.title.setText(current.getWeeklyGoal());
            this.subTitle.setText(current.getWeightUnits());
            this.position = position;
            this.current = current;
        }
    }

    public static Preferences getPoints(int position) {
        return mData.get(position);
    }

    public List<Preferences> getPointsList() {
        return mData;
    }

    public void setPointsList(List<Preferences> data) {
        mData = data;
    }

}
