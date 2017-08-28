package com.example.jhuwei.ui_change;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


public class Rcy_Adapter extends RecyclerView.Adapter<Rcy_Adapter.MyViewHolder> {

    private Context mContext;
    private List<String> mDataset;
    private LayoutInflater mInflater;



    public Rcy_Adapter(Context context, List<String> dataset) {
        this.mContext = context;
        this.mDataset = dataset;
        mInflater = LayoutInflater.from (context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = mInflater.inflate (R.layout.rcy_item, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder (view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        viewHolder.mTextView.setText(mDataset.get (position));
    }


    @Override
    public int getItemCount() {
        return mDataset.size ();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        public MyViewHolder(View view) {
            super (view);
            mTextView = (TextView) view.findViewById(R.id.text);
        }
    }
}
