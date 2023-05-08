package com.example.task1;



import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    protected  List<String> mData;

    LayoutInflater mlayoutInflator;

    @SuppressLint("NotifyDataSetChanged")
    public  void setFilteredItem(ArrayList<String> filteredItem)
    {
        this.mData=filteredItem;
        notifyDataSetChanged();
    }
    RecyclerViewAdapter(List<String> data , Context context)
    {
        this.mData = data;
        this.mlayoutInflator = LayoutInflater.from(context);
    }

    @NonNull
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mlayoutInflator.inflate(R.layout.recycle_row_student,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String tableVal = mData.get(position);
        holder.mTextViewTables.setText(tableVal);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextViewTables;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTables = itemView.findViewById(R.id.tv_student);
        }
    }

}

